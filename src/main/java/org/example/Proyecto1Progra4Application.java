package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.repository")
public class Proyecto1Progra4Application {

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1Progra4Application.class, args);
    }

}
