package edu.kpi.labtime.controller;

import edu.kpi.labtime.dto.Param;
import edu.kpi.labtime.exception.validation.InvalidCommandNameException;
import edu.kpi.labtime.exception.validation.InvalidParamException;
import edu.kpi.labtime.exception.validation.InvalidParamNameException;
import edu.kpi.labtime.exception.validation.InvalidParamTypeException;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestParser {

    private Parser parser;

    @Before
    public void _init() {
        parser = Parser.getInstance();
    }

    @Test
    public void parseCommandUnknownTest() {
        try {
            parser.parseCommand("someRandomCommandToParseDataFail");
        } catch (InvalidCommandNameException e) {
            return; //success
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.fail();
    }

    @Test
    public void parseCommandInvalidParam1Test() {
        try {
            parser.parseCommand("new number");
        } catch (InvalidParamException e) {
            //success
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.fail();
    }

    @Test
    public void parseCommandInvalidParam2Test() {
        try {
            parser.parseCommand("new /number");
        } catch (InvalidParamException e) {
            //success
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.fail();
    }

    @Test
    public void parseCommandInvalidParam3Test() {
        try {
            parser.parseCommand("new /number:aaa");
        } catch (InvalidParamTypeException e) {
            return; //success
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.fail();
    }

    @Test
    public void parseCommandInvalidParamNameTest() {
        try {
            parser.parseCommand("get 0 /name:test");
        } catch (InvalidParamNameException e) {
            return; //success
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.fail();
    }

    @Test
    public void parseCommandGetSimpleTest() {
        boolean isIdFounded = false;
        Pair<String, List<Param>> command = null;
        try {
            command = parser.parseCommand("get 0");
            isIdFounded = command.getValue().stream().anyMatch(param -> "Id".equals(param.getName()));
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertTrue("IdParamMustBeSpecified", isIdFounded);
        Integer actual = (Integer) command.getValue().stream().filter(param -> "Id".equals(param.getName())).findFirst().get().getValue();
        Assert.assertEquals(Integer.valueOf("0"),actual);
    }

    @Test
    public void parseCommandGetTest() {
        final String paramName = "subject";
        Pair<String, List<Param>> command = null;
        try {
            command = parser.parseCommand("get 0 /"+paramName+":test");
        } catch (Exception e) {
            Assert.fail();
        }
        String actual = (String) command.getValue().stream().filter(param -> paramName.equals(param.getName())).findFirst().get().getValue();
        Assert.assertEquals("test",actual);
    }
}
