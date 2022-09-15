package com.example.mapjinniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapjinniu.modules.fence.mapper")
@MapperScan("com.example.mapjinniu.modules.user.mapper")
public class MapJinniuApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapJinniuApplication.class, args);
    }

}
