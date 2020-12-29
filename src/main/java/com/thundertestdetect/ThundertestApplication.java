package com.thundertestdetect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.thundertestdetect.entity"})  // scan JPA entities
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ThundertestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThundertestApplication.class, args);
    }

}
