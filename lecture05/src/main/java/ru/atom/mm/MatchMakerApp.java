package ru.atom.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Date;


@SpringBootApplication
public class MatchMakerApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MatchMakerApp.class, args);
    }

    @Bean
    @Scope("request")
    Date time2() {
        return new Date();
    }
    @Bean
    @Scope("request")
    Date time1970() {
        return new Date(0);
    }
}
