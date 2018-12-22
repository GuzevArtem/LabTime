package edu.kpi.labtime.dto.result;

public interface Result {

    ResultType getType();

    String getMessage();

    static enum ResultType {
        NONE,
        LAB,
        LIST_LAB,
        SUCCESS_DELETE,
    }
}
