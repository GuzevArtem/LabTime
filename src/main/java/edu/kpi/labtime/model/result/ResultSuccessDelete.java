package edu.kpi.labtime.model.result;

public class ResultSuccessDelete extends ResultImpl {

    private Integer id;

    public ResultSuccessDelete(Integer id) {
        super(ResultType.SUCCESS_DELETE);
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Successfully deleted " + id + ".";
    }
}
