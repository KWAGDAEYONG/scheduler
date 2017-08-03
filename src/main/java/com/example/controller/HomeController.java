package com.example.controller;

import com.example.model.User;
import com.example.utility.JsonConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 2017-05-11.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(HttpSession httpSession, Model model){
        User loginUser = (User)httpSession.getAttribute("loginUser");
        if(loginUser !=null){
            model.addAttribute("user",loginUser);
            model.addAttribute("schedules",JsonConverter.schedulesToJson(loginUser.getSchedules()));
            return "/schedule/schedule_sample2";
        }
        return "/user/login";
    }

    @GetMapping("/sample")
    public String sample(){ return "/schedule/schedule_sample2";}
}
