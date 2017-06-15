package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    private Date date;

    private int time;

    private String content;

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

    public void setTime(int time) {
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

    public int getTime() {
        return time;
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
