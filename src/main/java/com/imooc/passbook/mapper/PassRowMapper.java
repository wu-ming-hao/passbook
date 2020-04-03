package com.imooc.passbook.mapper;

import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.vo.Pass;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.commons.lang.time.DateUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import javax.swing.tree.TreePath;

/**
 * <h1> HBase Pass Row To Pass Object </h1>
 */
public class PassRowMapper implements RowMapper<Pass> {

    private static byte[] FAMLY_I = Constants.PassTable.FAMILY_I.getBytes();
    private static byte[] USER_ID = Constants.PassTable.USER_ID.getBytes();
    private static byte[] TEMPLATE_ID = Constants.PassTable.TEMPLATE_ID.getBytes();
    private static byte[] TOKEN = Constants.PassTable.TOKEN.getBytes();
    private static byte[] ASSIGEND_DATE = Constants.PassTable.ASSIGEND_DATE.getBytes();
    private static byte[] CON_DATE = Constants.PassTable.CON_DATE.getBytes();


    @Override
    public Pass mapRow(Result result, int i) throws Exception {
        Pass pass = new Pass();
        pass.setUserId(Bytes.toLong(result.getValue(FAMLY_I, USER_ID)));
        pass.setTemplateId(Bytes.toString(result.getValue(FAMLY_I, TEMPLATE_ID)));
        pass.setToken(Bytes.toString(result.getValue(FAMLY_I, TOKEN)));
        String[] patterns = new String[]{"yyyy-MM-dd"};
        pass.setAssignedDate(DateUtils.parseDate(Bytes.toString(result.getValue(FAMLY_I, ASSIGEND_DATE)), patterns));

        String conDateStr = Bytes.toString(result.getValue(FAMLY_I, CON_DATE));
        if ("-1".equals(conDateStr)) {
            //代表优惠卷没有被销毁
            pass.setConDate(null);
        } else {
            pass.setConDate(DateUtils.parseDate(conDateStr, patterns));
        }
        pass.setRowKey(Bytes.toString(result.getRow()));
        return pass;
    }


}
