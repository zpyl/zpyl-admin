package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.dorm.mapper")
public class ZpylApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZpylApplication.class);
    }
}
