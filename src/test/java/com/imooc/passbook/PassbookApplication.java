package com.imooc.passbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <h1>测试程序入口</h1>
 */
@SpringBootApplication
public class PassbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassbookApplication.class, args);
    }

}
