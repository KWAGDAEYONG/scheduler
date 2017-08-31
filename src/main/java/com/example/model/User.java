package com.example.model;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty
    private Long id;

    @JsonProperty
    private String userId;

    private String password;

    private String email;

    @OneToMany(mappedBy="userId")
    @OrderBy("date ASC")
    private List<Schedule> schedules;

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String eamil) {
        this.email = eamil;
    }

    public String getEmail() {
        return email;
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

}
