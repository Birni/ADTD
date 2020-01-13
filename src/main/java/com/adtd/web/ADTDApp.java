package com.adtd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ADTDApp extends SpringBootServletInitializer {



    public static void main(String[] args) {
        SpringApplication.run(ADTDApp.class, args);
    }

}