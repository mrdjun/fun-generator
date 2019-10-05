package com.fun;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DJun
 */
@SpringBootApplication
@MapperScan("com.fun.project.mapper")
public class FunCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(FunCoreApplication.class,args);
    }
}
