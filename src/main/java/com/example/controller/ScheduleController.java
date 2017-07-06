package com.example.controller;

import com.example.model.Schedule;
import com.example.model.User;
import com.example.service.ScheduleService;
import com.example.utility.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        String schedulesToJson = JsonConverter.schedulesToJson(scheduleService.selectByScheduleMonth(scheduleService.add(schedule)));
        System.out.println(schedulesToJson);
        return schedulesToJson;
    }

    @PostMapping("/remove")
    public String remove(Long id){
        String schedulesToJson = JsonConverter.schedulesToJson(scheduleService.selectByScheduleMonth(scheduleService.remove(id)));
        System.out.println(schedulesToJson);
        return schedulesToJson;
    }

    @PostMapping("/modify")
    public String modify(@RequestBody Schedule schedule, Long id){
        Schedule dbSchedule = scheduleService.selectOneById(id);
        dbSchedule.update(schedule);
        String schedulesToJson = JsonConverter.schedulesToJson(scheduleService.selectByScheduleMonth(scheduleService.add(dbSchedule)));
        System.out.println(schedulesToJson);
        return schedulesToJson;
    }

    @GetMapping("/prevOrNext")
    public String prevOrNext(String date){
        String test = JsonConverter.schedulesToJson(scheduleService.selectByMonth(date));
        System.out.println(test);
        return test;
    }

}
