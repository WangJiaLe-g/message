package com.jc.message.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: MessageServer
 * @Author: wangjiale
 * @Date: 2023-02-17
 * @Version 1.0
 */
@SpringBootApplication
public class MessageServer {
    public static void main(String[] args) {
        SpringApplication.run(MessageServer.class, args);
    }
}
