package edu.kpi.labtime.model;

import java.time.LocalTime;
import java.util.List;

public class Lab {

    private static Integer lastId = 0;

    private Integer id;
    private String subject;
    private Integer number;
    private String description;
    private String task;
    private String requirements;
    private LocalTime endTime;
    private List<Remainder> remainders;

    public Lab(String subject, Integer number, String description, String task, LocalTime endTime) {
        this.id = lastId++;
        this.subject = subject;
        this.number = number;
        this.description = description;
        this.task = task;
        this.endTime = endTime;
    }

    public Lab(String subject, Integer number, String description, String task, LocalTime endTime, String requirements) {
        this.id = lastId++;
        this.subject = subject;
        this.number = number;
        this.description = description;
        this.task = task;
        this.endTime = endTime;
        this.requirements = requirements;
    }

    public Lab(String subject, Integer number, String description, String task, LocalTime endTime, String requirements, List<Remainder> remainders) {
        this.id = lastId++;
        this.subject = subject;
        this.number = number;
        this.description = description;
        this.task = task;
        this.endTime = endTime;
        this.requirements = requirements;
        this.remainders = remainders;
    }

    public Integer getId(){
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<Remainder> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<Remainder> remainders) {
        this.remainders = remainders;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", task='" + task + '\'' +
                ", requirements='" + requirements + '\'' +
                ", endTime=" + endTime +
                ", remainders=" + remainders +
                '}';
    }
}
