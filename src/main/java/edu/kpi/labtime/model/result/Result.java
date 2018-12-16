package edu.kpi.labtime.model.result;

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
