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
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_schedule_owner"))
    private User owner;

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
