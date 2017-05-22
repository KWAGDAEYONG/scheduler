package com.example.controller;

import com.example.model.Schedule;
import com.example.model.User;
import com.example.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by user on 2017-05-12.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/add")
    public String add(HttpSession session, @RequestBody Schedule schedule){
        if(session.getAttribute("loginUser")==null){
            System.out.println("로그인을 먼저 해주세요");
            return "/user/login";
        }

        System.out.println(schedule);

        scheduleService.add(schedule);
        return "/schedule/schedule_sample";
    }
}
