package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by user on 2017-05-11.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "/index";
    }

    @GetMapping("/sample")
    public String sample(){ return "/schedule/schedule_sample2";}
}
