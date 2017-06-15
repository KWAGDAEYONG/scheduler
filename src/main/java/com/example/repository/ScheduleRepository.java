package com.example.repository;

import com.example.model.Schedule;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017-05-11.
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryQueryDsl{
    List<Schedule> findByUserId(User userId);
}
