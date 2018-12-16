package edu.kpi.labtime.model.result;

import edu.kpi.labtime.model.Lab;

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
