package com.udacity.jdnd.course3.critter.model;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "employee_schedule",
            joinColumns = { @JoinColumn(name = "employee_id")},
            inverseJoinColumns = { @JoinColumn(name = "schedule_id")}
    )
    private Set<User> employeeIds;

    @ManyToMany
    @JoinTable(
            name = "pet_schedule",
            joinColumns = { @JoinColumn(name = "pet_id")},
            inverseJoinColumns = { @JoinColumn(name = "schedule_id")}
    )
    private Set<Pet> petIds;

    @Type(type = "LocalDate")
    private LocalDate date;

    @ElementCollection(targetClass = EmployeeSkill.class)
    private Set<EmployeeSkill> activities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getEmployeeIds() {
        return new HashSet<>(this.employeeIds);
    }

    public void setEmployeeIds(Set<User> employeeIds) {
        this.employeeIds = new HashSet<>(employeeIds);
    }

    public Set<Pet> getPetIds() {
        return new HashSet<>(this.petIds);
    }

    public void setPetIds(Set<Pet> petIds) {
        this.petIds = new HashSet<>(petIds);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return new HashSet<>(this.activities);
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = new HashSet<>(activities);
    }

}
