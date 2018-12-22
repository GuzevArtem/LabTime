package edu.kpi.labtime.controller;

import edu.kpi.labtime.exception.LTException;
import edu.kpi.labtime.dto.result.Result;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestController {
    private Controller controller;


    private final String INPUT_NEW_LAB = "new /subject:java /task:tdd /requirements:todo";

    @Before
    public void _init() {
        controller = new Controller();
    }

    @Test
    public void newLabTest() {
        try {
            Result result = controller.execute(controller.parseInput(INPUT_NEW_LAB));
            Assert.assertEquals(Result.ResultType.LAB, result.getType());
            Assert.assertTrue(result.getMessage().contains("subject='java'"));
            Assert.assertTrue(result.getMessage().contains("task='tdd'"));
            Assert.assertTrue(result.getMessage().contains("requirements='todo'"));
        } catch (LTException e) {
            Assert.fail(e.getMessage());
        }
    }
}
