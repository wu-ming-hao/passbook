package com.imooc.passbook.mapper;

import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.vo.PassTemplate;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.commons.lang.time.DateUtils;
import org.apache.hadoop.hbase.util.Bytes;


/**
 * <h1>HBase PassTemplate Row To PassTemplate Object</h1>
 */
public class PassTemplateRowMapper implements RowMapper<PassTemplate> {

    private static final byte[] FAMILY_B = Constants.PassTemplateTable.FAMILY_B.getBytes();
    private static final byte[] ID = Constants.PassTemplateTable.ID.getBytes();
    private static final byte[] TITLE = Constants.PassTemplateTable.TITILE.getBytes();
    private static final byte[] SUMMARY = Constants.PassTemplateTable.SUMMARY.getBytes();
    private static final byte[] DES = Constants.PassTemplateTable.DESC.getBytes();
    private static final byte[] HAS_TOKEN = Constants.PassTemplateTable.HAS_TOKEN.getBytes();
    private static final byte[] BACKGROUND = Constants.PassTemplateTable.BACKGROUND.getBytes();

    private static final byte[] FAMILY_C = Constants.PassTemplateTable.FAMILY_C.getBytes();
    private static final byte[] LIMIT = Constants.PassTemplateTable.LIMIT.getBytes();
    private static final byte[] START = Constants.PassTemplateTable.START.getBytes();
    private static final byte[] END = Constants.PassTemplateTable.END.getBytes();


    @Override
    public PassTemplate mapRow(org.apache.hadoop.hbase.client.Result result, int i) throws Exception {
        PassTemplate passTemplate = new PassTemplate();

        passTemplate.setId(Bytes.toInt(result.getValue(FAMILY_B, ID)));
        passTemplate.setTitle(Bytes.toString(result.getValue(FAMILY_B,TITLE)));
        passTemplate.setSummary(Bytes.toString(result.getValue(FAMILY_B,SUMMARY)));
        passTemplate.setDesc(Bytes.toString(result.getValue(FAMILY_B,DES)));
        passTemplate.setHasTooken(Bytes.toBoolean(result.getValue(FAMILY_B,HAS_TOKEN)));
        passTemplate.setBackground(Bytes.toInt(result.getValue(FAMILY_B,BACKGROUND)));

        String [] patterns = new String[]{"yyyy-MM-dd"};
        passTemplate.setLimit(Bytes.toLong(result.getValue(FAMILY_C,LIMIT)));
        passTemplate.setStart(DateUtils.parseDate(Bytes.toString(result.getValue(FAMILY_C,START)),patterns));
        passTemplate.setEnd(DateUtils.parseDate(Bytes.toString(result.getValue(FAMILY_C,END)),patterns));

        return passTemplate;
    }
}