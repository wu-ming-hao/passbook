package com.imooc.passbook.service.impl;

import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.dao.MerchantsDao;
import com.imooc.passbook.entity.Merchants;
import com.imooc.passbook.mapper.PassTemplateRowMapper;
import com.imooc.passbook.service.IInventoryService;
import com.imooc.passbook.service.IUserPassService;
import com.imooc.passbook.service.IUserService;
import com.imooc.passbook.utils.RowKeyGenUtil;
import com.imooc.passbook.vo.*;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import io.netty.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.LongComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <h1>获取库存信息，只返回用户领取的</h1>
 */
@Slf4j
@Service
public class InventoryServiceImpl implements IInventoryService {

    /** hbase客户端 */
    @Autowired
    private HbaseTemplate hbaseTemplate;

    /** 商户 dao 接口 */
    @Autowired
    private MerchantsDao merchantsDao;

    @Autowired
    private IUserPassService userPassService;

    @Override
    @SuppressWarnings("unchecked")
    public Response getInventoryInfo(Long userId) throws Exception {

        Response allUserPass = userPassService.getUserUserPassInfo(userId);
        List<PassInfo> passInfos = (List<PassInfo>) allUserPass.getData();

        List<PassTemplate> excludeObject = passInfos.stream().map(PassInfo::getPassTemplate).collect(Collectors.toList());

        List<String> excludIds = new ArrayList<>();
        excludeObject.forEach(e -> excludIds.add(RowKeyGenUtil.genPassTemplateRowKey(e)));


        return new Response(new InventoryResponse(userId, buildPassTemplateInfo(getAvailablePassTempalte(excludIds))));
    }

    /**
     * <h2>获取系统中可以的优惠卷</h2>
     *
     * @param excludeIds 需要排除的优惠卷 ids
     * @return {@link PassTemplate}
     */
    private List<PassTemplate> getAvailablePassTempalte(List<String> excludeIds) {

        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);

        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.GREATER,
                        new LongComparator(0L)
                )
        );
        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.EQUAL,
                        Bytes.toBytes("-1")
                )
        );
        Scan scan = new Scan();
        scan.setFilter(filterList);
        List<PassTemplate> validTempaltes = hbaseTemplate.find(Constants.PassTemplateTable.TABLE_NAME, scan, new PassTemplateRowMapper());
        List<PassTemplate> availablePassTempaltes = new ArrayList<>();
        Date cur = new Date();
        for (PassTemplate validTempalte : validTempaltes) {
            if (excludeIds.contains(RowKeyGenUtil.genPassTemplateRowKey(validTempalte))) {
                continue;
            }
            if (cur.getTime() >= validTempalte.getStart().getTime() && cur.getTime() <= validTempalte.getEnd().getTime()) {
                availablePassTempaltes.add(validTempalte);
            }
        }
        return availablePassTempaltes;
    }

    /**
     * <h2>构造优惠卷信息</h2>
     *
     * @param passTemplates {@link PassTemplate}
     * @return {@link PassTemplateInfo}
     */
    private List<PassTemplateInfo> buildPassTemplateInfo(List<PassTemplate> passTemplates) {
        Map<Integer, Merchants> merchantsMap = new HashMap<>();
        List<Integer> merchantsIds = passTemplates.stream().map(PassTemplate::getId).collect(Collectors.toList());
        List<Merchants> merchants = merchantsDao.findAllByIn(merchantsIds);
        merchants.forEach(m -> merchantsMap.put(m.getId(), m));

        List<PassTemplateInfo> result = new ArrayList<>(passTemplates.size());

        for (PassTemplate passTemplate : passTemplates) {
            Merchants mc = merchantsMap.getOrDefault(passTemplate.getId(), null);
            if (null == mc) {
                log.error("Merchants Error : {}", passTemplate.getId());
                continue;
            }
            result.add(new PassTemplateInfo(passTemplate, mc));
        }
        return result;
    }

}
