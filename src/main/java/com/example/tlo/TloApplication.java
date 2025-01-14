package com.example.tlo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.tlo.api")
@SpringBootApplication
public class TloApplication {

    public static void main(String[] args) {
        SpringApplication.run(TloApplication.class, args);
    }

}
