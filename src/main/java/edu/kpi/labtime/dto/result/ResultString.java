package edu.kpi.labtime.dto.result;

public class ResultString extends ResultImpl {

    private String message;

    public ResultString(String message) {
        super(ResultType.NONE);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
