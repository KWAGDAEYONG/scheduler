package com.example.controller;

import com.example.model.User;
import com.example.service.ScheduleService;
import com.example.utility.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2017-05-11.
 */
@Controller
public class HomeController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/")
    public String home(HttpSession httpSession, Model model){
        User loginUser = (User)httpSession.getAttribute("loginUser");

        if(loginUser !=null){
            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

            model.addAttribute("user",loginUser);
            model.addAttribute("schedules",JsonConverter.schedulesToJson(scheduleService.selectByMonth(sdf.format(today))));
            return "/schedule/schedule_sample2";
        }
        return "/user/login";
    }

    @GetMapping("/sample")
    public String sample(){ return "/schedule/schedule_sample2";}
}
