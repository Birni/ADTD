package com.adtd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired


    @RequestMapping("/home")
    public String starten() {
        return "index.html";
    }



}
