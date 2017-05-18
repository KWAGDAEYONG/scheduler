package com.example.model;


import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


/**
 * Created by user on 2017-05-11.
 */
@Entity
public class User{

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    private String password;

    @OneToMany(mappedBy="owner")
    private Schedule schedule;

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
