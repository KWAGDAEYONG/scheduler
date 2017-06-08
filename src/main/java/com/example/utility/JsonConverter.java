package com.example.utility;

import com.example.model.Schedule;

import java.util.List;

/**
 * Created by user on 2017-05-25.
 */

public class JsonConverter {
    public static String schedulesToJson(List<Schedule> schedules){
        String result = "[";

        for(int i = 0; i<schedules.size(); i++){
            result+="{"+'"'+"date"+'"'+":"+'"'+schedules.get(i).getDate()+'"'+","+'"'+"time"+'"'+":"+'"'+schedules.get(i).getTime()+'"'
                    +","+'"'+"content"+'"'+":"+'"'+schedules.get(i).getContent()+'"'+"}";
            if(i!=schedules.size()-1){
                result+=",";
            }
        }
        result += "]";
        return result;
    }

    public static String scheduleToJson(Schedule schedule){
        return "{"+'"'+"date"+'"'+":"+'"'+schedule.getDate()+'"'+","+'"'+"time"+'"'+":"+'"'+schedule.getTime()+'"'+","+'"'+"content"+'"'+":"+'"'+schedule.getContent()+'"'+"}";
    }
}
