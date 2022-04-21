package com.jt808.web;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@EnableScheduling
@EnableSwagger2
@EnableWebSocketMessageBroker
@MapperScan("com.jt808.web.mapper")
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        //JDBC Connection connection validity detection provided by Hikari connection pool, the default is 500 milliseconds
        System.setProperty("com.zaxxer.hikari.aliveBypassWindowMs", "2000");
        SpringApplication.run(Application.class, args);
        log.info("***Spring Started successfully***");
    }
}