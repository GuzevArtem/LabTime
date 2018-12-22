package edu.kpi.labtime.dto;

import java.time.LocalTime;

public class Remainder {
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private String remainderMsg;
    private Lab lab; //backreference

    public Remainder(LocalTime timeStart, LocalTime timeEnd, String remainderMsg, Lab lab) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.remainderMsg = remainderMsg;
        this.lab = lab;
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

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }
}
