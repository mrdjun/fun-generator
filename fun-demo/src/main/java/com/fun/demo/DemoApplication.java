package com.fun.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DengJun 2021/3/14
 */
@SpringBootApplication
@MapperScan(basePackages = "com.fun.demo.dao")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("--------------项目启动成功--------------");

    }
}
