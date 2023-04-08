package com.zx.im.service;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Mr.xin
 */
@ComponentScan({"com.zx.im.service", "com.zx.im.common","com.zx.im.codec"})
@MapperScan("com.zx.im.service.*.dao.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
