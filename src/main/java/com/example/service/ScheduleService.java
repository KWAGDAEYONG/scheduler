package com.example.service;

import com.example.model.Schedule;
import com.example.model.User;
import com.example.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Schedule> selectByMonth(String date, User user){
        return scheduleRepository.selectByMonth(date, user);
    }
    public List<Schedule> selectByScheduleMonth(Schedule schedule, User user){
        String date = schedule.getDate().toString();
        return scheduleRepository.selectByMonth(date.substring(0,7), user);
    }

    public Schedule remove(Long id){
        Schedule schedule = scheduleRepository.findOne(id);
        scheduleRepository.delete(id);
        return schedule;
    }
    public Schedule selectOneById(Long id){
        return scheduleRepository.findOne(id);
    }
}
