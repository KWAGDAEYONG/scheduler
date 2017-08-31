package com.example.repository;

import com.example.model.Schedule;
import com.example.model.User;

import java.util.List;

/**
 * Created by user on 2017-06-15.
 */
public interface ScheduleRepositoryQueryDsl {
    List<Schedule> selectByMonth(String date, User user);
}
