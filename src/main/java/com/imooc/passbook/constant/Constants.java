package com.imooc.passbook.constant;

/**
 * <h1>常类定义</h1>
 */
public class Constants {

    /** 商户优惠卷 kafka Topic */
    public static final String  TEMPLATE_TOPIC = "merchants-template";

    /** token 文件存储目录 */
    public static final String TOKEN_DIR = "/tmp/token";

    /** 已使用的 token 文件后缀名 */
    public static final String USED_TOKEN_SUFFIX = "_";

    /** 用户数的 redis key*/
    public static final String USE_COUNT_REDIS_KEY = "imooc_user_count";


    /**
     * <h2>User HBase Tbale</h2>
     */
    public class UserTable{

        /** User HBase 表名 */
        public static final String TABLE_NAME = "pb:user";

        /** 基本信息列族 b*/
        public static final String FAMILY_B = "b";

        /** 额外信息列族 o */
        public static final String FAMILY_O = "o";

        /** 用户名 */
        public static final String NAME = "name";

        /** 用户年龄*/
        public static final String AGE = "age";

        /** 用户性别 */
        public static final String SEX = "sex";

        /** 额外信息列族 */
        public static final String ADDRESS = "address";

        /** 用户电话 */
        public static final String PHONE = "phone";
    }


    /**
     * <h2>PassTemplate HBase Table</h2>
     */
    public class PassTemplateTable{

        /** PassTemplate HBase 表名 */
        public static final String TABLE_NAME = "pb:passtemplate";

        /** 基本信息列族 */
        public static final String FAMILY_B = "b";

        /** 商户id */
        public static final String ID = "id";

        /** 优惠卷标题 */
        public static final String TITILE = "title";

        /** 优惠卷摘要信息 */
        public static final String SUMMARY = "summary";

        /** 优惠卷详细信息 */
        public static final String DESC = "desc";

        /** 优惠卷是否有token */
        public static final String HAS_TOKEN = "has_token";

        /** 优惠卷背景颜色 */
        public static final String BACKGROUND = "background";

        /** 约束信息列族 */
        public static final String FAMILY_C = "c";

        /** 最大个数限制 */
        public static final String LIMIT = "limit";

        /** 优惠卷开始时间 */
        public static final String START ="start";

        /** 优惠卷结束时间 */
        public static final String END = "end";
    }


    /**
     * <h2>Pass HBase Table</h2>
     */
    public class PassTable{

        /** Pass HBase 表名 */
        public static final String TABLE_NAME = "pb:pass";

        /** 信息列族 */
        public static final String FAMILY_I = "i";

        /** 用户id */
        public static final String USER_ID = "user_id";

        /** 优惠卷id */
        public static final String TEMPLATE_ID = "template_id";

        /** 优惠卷识别码 */
        public static final String TOKEN = "token";

        /** 领取日期 */
        public static final String ASSIGEND_DATE = "assingend_date";

        /** 消费日期 */
        public static final String CON_DATE = "con_date";
    }

    /**
     * <h2>Feedback Hbase table</h2>
     */
    public class Feedback{

        /** Feedback HBase 表名 */
        public static final String TABLE_NAME = "pb:feedback";

        /** 信息列族 */
        public static final String FAMILY_I = "i";

        /** 用户id */
        public static final String USER_ID = "user_id";

        /** 评论类型 */
        public static final String TYPE = "type";

        /** PassTemplate Rowkey ，如果是app 评论，则是 -1 */
        public static final String TEMPLATE_ID = "template_id";

        /** 评论内容 */
        public static final String COMMENT = "comment";
    }

}
