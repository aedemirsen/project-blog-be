package com.aedemirsen.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.aedemirsen")
@EntityScan(basePackages = "com.aedemirsen.domain.entity")
@EnableJpaRepositories(basePackages ="com.aedemirsen.domain.repository")
@RequiredArgsConstructor
public class RestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }
}
