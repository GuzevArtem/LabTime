package edu.kpi.labtime.model;

import java.time.LocalTime;

public class Remainder {
    LocalTime timeStart;
    LocalTime timeEnd;
    String remainderMsg;
    Lab lab; //backreference

    public Remainder(Lab lab, String remainderMsg, LocalTime timeStart, LocalTime timeEnd) {
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
}
