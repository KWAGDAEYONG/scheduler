package com.example.repository;

import com.example.model.Schedule;

import java.sql.Date;
import java.util.List;

/**
 * Created by user on 2017-06-15.
 */
public interface ScheduleRepositoryQueryDsl {
    List<Schedule> selectByMonth(String date);
}
