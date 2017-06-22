package com.example.controller;

import com.example.model.Schedule;
import com.example.model.User;
import com.example.service.ScheduleService;
import com.example.service.UserService;
import com.example.utility.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by user on 2017-05-12.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/add")
    public String add(@RequestBody Schedule schedule, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("loginUser");
        schedule.setUserId(user);
        Schedule addSchedule = scheduleService.add(schedule);
        String scheduleToJson = JsonConverter.scheduleToJson(addSchedule);
        System.out.println(scheduleToJson);
        return scheduleToJson;
    }

    @GetMapping("/prevOrNext")
    public String prevOrNext(String date){
        String test = JsonConverter.schedulesToJson(scheduleService.selectByMonth(date));
        System.out.println(test);
        return test;
    }

    @GetMapping("/selectOneDay")
    public String selectOneDay(String date){
        Date day = Date.valueOf(date);
        String test = JsonConverter.schedulesToJson(scheduleService.selectByOneDay(day));
        return test;
    }
}
