package com.example.repository.impl;

import com.example.model.QSchedule;
import com.example.model.Schedule;
import com.example.repository.ScheduleRepositoryQueryDsl;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by user on 2017-06-15.
 */
@Service
public class ScheduleRepositoryImpl extends QueryDslRepositorySupport implements ScheduleRepositoryQueryDsl {
    private final String START = "01";
    private final String END = "31";

    public ScheduleRepositoryImpl(){
        super(Schedule.class);
    }

    @Override
    public List<Schedule> selectByMonth(String date){
        System.out.println(date);
        QSchedule qSchedule = QSchedule.schedule;
        Date startDate = Date.valueOf(date+"-"+START);
        System.out.println(startDate);
        Date endDate = Date.valueOf(date+"-"+END);
        System.out.println(endDate);
        return from(qSchedule)
                .where(qSchedule.date.between(startDate,endDate))
                .fetch();
    }
}
