package edu.kpi.labtime.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity(name="remainders")
public class RemainderEntity {

    @Id
    @Column(name = "remainder_id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    private LocalTime timeStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private LocalTime timeEnd;

    @OneToOne
    @JoinColumn(name = "text_id",
            foreignKey = @ForeignKey(name = "TEXT_ID_FK")
    )
    private String remainderMsg;

    @ManyToOne
    @JoinColumn(name = "lab_id",
            foreignKey = @ForeignKey(name = "LAB_ID_FK")
    )
    private LabEntity lab;

    public RemainderEntity() {
    }

    public RemainderEntity(LocalTime timeStart, LocalTime timeEnd, String remainderMsg, LabEntity lab) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.remainderMsg = remainderMsg;
        this.lab = lab;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getRemainderMsg() {
        return remainderMsg;
    }

    public void setRemainderMsg(String remainderMsg) {
        this.remainderMsg = remainderMsg;
    }

    public LabEntity getLab() {
        return lab;
    }

    public void setLab(LabEntity lab) {
        this.lab = lab;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemainderEntity that = (RemainderEntity) o;
        return Objects.equals(getTimeStart(), that.getTimeStart()) &&
                Objects.equals(getTimeEnd(), that.getTimeEnd()) &&
                Objects.equals(getRemainderMsg(), that.getRemainderMsg()) &&
                Objects.equals(getLab(), that.getLab());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTimeStart(), getTimeEnd(), getRemainderMsg(), getLab());
    }
}
