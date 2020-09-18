package com.udacity.jdnd.course3.critter.model;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee extends User {

    @ElementCollection(targetClass = EmployeeSkill.class)
    private Set<EmployeeSkill> skills;

    @ElementCollection(targetClass = DayOfWeek.class)
    private Set<DayOfWeek> daysAvailable;

    @ManyToMany
    @JoinTable(
            name = "employee_schedule",
            joinColumns = { @JoinColumn(name = "employee_id")},
            inverseJoinColumns = { @JoinColumn(name = "schedule_id")}
    )
    private List<Schedule> schedules;

    public Set<EmployeeSkill> getSkills() {
        return new HashSet<>(this.skills);
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = new HashSet<>(skills);
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return new HashSet<>(this.daysAvailable);
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = new HashSet<>(daysAvailable);
    }

    public List<Schedule> getSchedules() {
        return new ArrayList<>(this.schedules);
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = new ArrayList<>(schedules);
    }

}
