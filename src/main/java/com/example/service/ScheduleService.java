package com.example.service;

import com.example.model.Schedule;
import com.example.model.User;
import com.example.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by user on 2017-05-12.
 */
@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule add(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
    public List<Schedule> selectByUser(User userId){
        return scheduleRepository.findByUserId(userId);
    }

    public List<Schedule> selectByMonth(String date){
        return scheduleRepository.selectByMonth(date);
    }

}
