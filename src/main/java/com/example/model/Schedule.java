package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 2017-05-11.
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_schedule_owner"))
    private User userId;

    private String date;

    private String time;

    private String content;

    public Long getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(User owner) {
        this.userId = owner;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
