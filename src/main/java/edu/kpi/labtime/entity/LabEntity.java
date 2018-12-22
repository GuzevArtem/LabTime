package edu.kpi.labtime.entity;

import edu.kpi.labtime.entity.RemainderEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity(name="labs")
public class LabEntity {

    @Id
    @Column(name = "lab_id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column(name="subject")
    @OneToOne
    @JoinColumn(name = "subject_id",
            foreignKey = @ForeignKey(name = "SUBJECT_ID_FK")
    )
    private String subject;

    @Column(name="numbet")
    @OneToOne
    @JoinColumn(name = "number_id",
            foreignKey = @ForeignKey(name = "TEXT_ID_FK")
    )
    private Integer number;

    @Column(name="description")
    @OneToOne
    @JoinColumn(name = "text_id",
            foreignKey = @ForeignKey(name = "TEXT_ID_FK")
    )
    private String description;

    @Column(name="task")
    @OneToOne
    @JoinColumn(name = "text_id",
            foreignKey = @ForeignKey(name = "TEXT_ID_FK")
    )
    private String task;

    @Column(name="requirements")
    @OneToOne
    @JoinColumn(name = "text_id",
            foreignKey = @ForeignKey(name = "TEXT_ID_FK")
    )
    private String requirements;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private LocalTime endTime;

    @OneToMany(mappedBy = "lab_id" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RemainderEntity> remainders = new ArrayList<>();

    public LabEntity() {
    }

    public LabEntity(String subject, Integer number, LocalTime endTime) {
        this.subject = subject;
        this.number = number;
        this.endTime = endTime;
    }

    public LabEntity(String subject, Integer number, String description, String task, String requirements, LocalTime endTime, List<RemainderEntity> remainders) {
        this.subject = subject;
        this.number = number;
        this.description = description;
        this.task = task;
        this.requirements = requirements;
        this.endTime = endTime;
        this.remainders = remainders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<RemainderEntity> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<RemainderEntity> remainders) {
        this.remainders = remainders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabEntity labEntity = (LabEntity) o;
        return Objects.equals(getSubject(), labEntity.getSubject()) &&
                Objects.equals(getNumber(), labEntity.getNumber()) &&
                Objects.equals(getDescription(), labEntity.getDescription()) &&
                Objects.equals(getTask(), labEntity.getTask()) &&
                Objects.equals(getRequirements(), labEntity.getRequirements()) &&
                Objects.equals(getEndTime(), labEntity.getEndTime()) &&
                Objects.equals(getRemainders(), labEntity.getRemainders());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSubject(), getNumber(), getDescription(), getTask(), getRequirements(), getEndTime(), getRemainders());
    }
}
