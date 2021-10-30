package com.atguigu.mpdemo1010;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.mpdemo1010.mapper")
public class Mpdemo1010Application {

    public static void main(String[] args) {
        SpringApplication.run(Mpdemo1010Application.class, args);
    }

}
