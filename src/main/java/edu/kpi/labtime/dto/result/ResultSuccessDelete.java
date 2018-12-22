package edu.kpi.labtime.dto.result;

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
