package com.mr;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.Duration;
import java.time.Instant;

/**
 * 启动程序
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.mr.mapper")
public class MyProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(MyProjectApplication.class);

    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        SpringApplication.run(MyProjectApplication.class, args);
        log.info("基于 Spring Boot {} ", SpringBootVersion.getVersion());
        log.info("启动成功!耗时:{}秒 ", Duration.between(inst1, Instant.now()).getSeconds());
    }

}