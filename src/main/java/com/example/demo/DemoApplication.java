package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
@EnableScheduling
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args); }
}
