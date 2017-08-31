package com.example.controller;

import com.example.model.Schedule;
import com.example.model.User;
import com.example.service.ScheduleService;
import com.example.utility.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
        return JsonConverter.schedulesToJson(scheduleService.selectByScheduleMonth(scheduleService.add(schedule),user));
    }

    @PostMapping("/remove")
    public String remove(@RequestBody Schedule schedule, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("loginUser");
        Long id = schedule.getId();
        return JsonConverter.schedulesToJson(scheduleService.selectByScheduleMonth(scheduleService.remove(id),user));
    }

    @PostMapping("/modifyPage")
    public String modifyPage(@RequestBody Schedule schedule){
        Long id = schedule.getId();
        Schedule dbSchedule = scheduleService.selectOneById(id);
        return JsonConverter.scheduleToJson(dbSchedule);
    }

    @PostMapping("/modify")
    public String modify(@RequestBody Schedule schedule, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("loginUser");
        Long id = schedule.getId();
        Schedule dbSchedule = scheduleService.selectOneById(id);
        dbSchedule.update(schedule);
        return JsonConverter.schedulesToJson(scheduleService.selectByScheduleMonth(scheduleService.add(dbSchedule),user));
    }

    @GetMapping("/prevOrNext")
    public String prevOrNext(String date, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("loginUser");
        return JsonConverter.schedulesToJson(scheduleService.selectByMonth(date,user));
    }

}
