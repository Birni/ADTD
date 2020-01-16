package com.adtd.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Main Application ADTD
 *
 * @author  Matthias Birnthaler
 */
@SpringBootApplication
public class ADTDApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ADTDApp.class, args);
    }

}