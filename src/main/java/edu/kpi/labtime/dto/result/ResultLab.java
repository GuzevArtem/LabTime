package edu.kpi.labtime.dto.result;

import edu.kpi.labtime.dto.Lab;

public class ResultLab extends ResultImpl {

    private Lab lab;

    public ResultLab(Lab lab) {
        super(ResultType.LAB);
        this.lab = lab;
    }

    @Override
    public String getMessage() {
        return lab.toString();
    }
}
