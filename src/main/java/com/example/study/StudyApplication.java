package com.example.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(value = "com.example.study.mapper")
public class StudyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

}
