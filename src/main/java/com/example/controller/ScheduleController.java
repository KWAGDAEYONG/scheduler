package com.example.controller;

import com.example.model.Schedule;
import com.example.model.User;
import com.example.service.ScheduleService;
import com.example.service.UserService;
import com.example.utility.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 2017-05-12.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public String add(@RequestBody Schedule schedule, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("loginUser");

        Schedule addSchedule = schedule;
        addSchedule.setUserId(user);
        addSchedule.setMonth(schedule.getDate());
        String test = JsonConverter.scheduleToJson(scheduleService.add(addSchedule));
        System.out.println(test);
        return test;
    }

    @GetMapping("/prevOrNext")
    public String prevOrNext(int month){
        String test = JsonConverter.schedulesToJson(scheduleService.prevOrNextSchedule(++month));
        System.out.println(test);
        return test;
    }
}
