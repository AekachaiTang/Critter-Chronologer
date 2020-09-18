package com.udacity.jdnd.course3.critter.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "application_user")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "nstring")
    private String name;

    public Long getId(){ return id;}
    public void setId(Long id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

}
