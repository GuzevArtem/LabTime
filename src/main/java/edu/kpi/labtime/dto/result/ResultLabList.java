package edu.kpi.labtime.dto.result;

import edu.kpi.labtime.dto.Lab;

import java.util.List;

public class ResultLabList extends ResultImpl {

    private List<Lab> labs;

    public ResultLabList(List<Lab> labs) {
        super(ResultType.LIST_LAB);
        this.labs = labs;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        for (Lab lab: labs) {
            sb.append(lab.toString());
        }
        return sb.toString();
    }
}
