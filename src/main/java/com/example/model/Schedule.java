package com.example.model;


import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2017-05-11.
 */
@Entity
public class Schedule {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_schedule_user"))
    private User userId;

    private String title;

    private Date date;

    private String time;

    private String content;

    public Schedule(){
    }

    public Schedule(User userId, Date date, String time, String content){
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        /*String ex = "9:30 PM";
        String temp[] = time.split(" ");
        String hm[] = temp[0].split(":");
        if(temp[1].equals("PM")){
            hm[0] = String.valueOf(Integer.parseInt(hm[0])+12);
        }
        if(Integer.parseInt(hm[0])<10){
            hm[0] = "0"+hm[0];
        }
*/
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public void update(Schedule schedule){
        this.title = schedule.title;
        this.content = schedule.content;
        this.date = schedule.date;
        this.time = schedule.time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
