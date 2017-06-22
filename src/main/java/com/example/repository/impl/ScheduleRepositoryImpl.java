package com.example.repository.impl;

import com.example.model.QSchedule;
import com.example.model.Schedule;
import com.example.repository.ScheduleRepositoryQueryDsl;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 2017-06-15.
 */
@Service
public class ScheduleRepositoryImpl extends QueryDslRepositorySupport implements ScheduleRepositoryQueryDsl {
    private final String START = "01";
    public ScheduleRepositoryImpl(){
        super(Schedule.class);
    }

    @Override
    public List<Schedule> selectByMonth(String date){
        QSchedule qSchedule = QSchedule.schedule;
        Date startDate = Date.valueOf(date+"-"+START);
        Calendar calendar = Calendar.getInstance();

        String tempDate[] = date.split("-");

        int year = Integer.parseInt(tempDate[0]);
        int month = Integer.parseInt(tempDate[1]);

        calendar.set(year, month-1, 1);

        String end = String.valueOf(calendar.getActualMaximum(Calendar.DATE));

        Date endDate = Date.valueOf(date+"-"+end);

        return from(qSchedule)
                .where(qSchedule.date.between(startDate,endDate))
                .fetch();
    }
}
