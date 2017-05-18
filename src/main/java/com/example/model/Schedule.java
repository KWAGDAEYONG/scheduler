package com.example.model;

import javax.persistence.*;

/**
 * Created by user on 2017-05-11.
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_schedule_owner"))
    private User owner;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Schedule(User user){
        this.owner = user;
    }
    public Schedule(){

    }

}
