package edu.kpi.labtime.dto.result;


abstract class ResultImpl implements Result {

    private ResultType type;

    public ResultImpl(ResultType type) {
        this.type = type;
    }

    @Override
    public ResultType getType() {
        return null;
    }

    @Override
    public String toString() {
        return "ResultImpl{" +
                "type=" + type +
                '}';
    }
}
