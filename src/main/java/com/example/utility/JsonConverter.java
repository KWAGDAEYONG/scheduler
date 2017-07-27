package com.example.utility;

import com.example.model.Schedule;

import java.util.List;

/**
 * Created by user on 2017-05-25.
 */

public class JsonConverter {
    public static String schedulesToJson(List<Schedule> schedules){
        if(schedules==null){
            return "";
        }
        String result = "[";
        for(int i = 0; i<schedules.size(); i++){
            result+="{"+'"'+"id"+'"'+":"+'"'+schedules.get(i).getId()+'"'+","+'"'+"title"+'"'+":"+'"'+schedules.get(i).getTitle()+'"'+","+'"'+"date"+'"'+":"+'"'+schedules.get(i).getDate()+'"'+","+'"'+"time"+'"'+":"+'"'+schedules.get(i).getTime()+'"'
                    +","+'"'+"content"+'"'+":"+'"'+schedules.get(i).getContent()+'"'+"}";
            if(i!=schedules.size()-1){
                result+=",";
            }
        }
        result += "]";
        return result;
    }

    public static String scheduleToJson(Schedule schedule){
        String result = "{"+'"'+"id"+'"'+":"+'"'+schedule.getId()+'"'+","+'"'+"title"+'"'+":"+'"'+schedule.getTitle()+'"'+","+'"'+"date"+'"'+":"+'"'+schedule.getDate()+'"'+","+'"'+"time"+'"'+":"+'"'+schedule.getTime()+'"'+","+'"'+"content"+'"'+":"+'"'+schedule.getContent()+'"'+"}";
        return  result;
    }
}
