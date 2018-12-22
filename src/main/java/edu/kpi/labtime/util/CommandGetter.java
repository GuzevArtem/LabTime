package edu.kpi.labtime.util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kpi.labtime.constants.Command;
import edu.kpi.labtime.dto.Param;

public class CommandGetter {

    private static CommandGetter INSTANCE = new CommandGetter();

    public static CommandGetter getInstance() {
        return INSTANCE;
    }

    private CommandGetter() {}

    private Map<String,List<Param>> commands = null;

    public static final String LAB_ID_STR = "Id";
    public static final String LAB_SUBJECT_STR = "subject";
    public static final String LAB_NUMBER_STR = "number";
    public static final String LAB_DESCRIPTION_STR = "description";
    public static final String LAB_TASK_STR = "task";
    public static final String LAB_REQUIREMENTS_STR = "requirements";
    public static final String LAB_END_DATE_STR = "endDate";

    public static final Param LAB_ID_PARAM = param(LAB_ID_STR, Integer.class);
    public static final Param LAB_SUBJECT_PARAM = param(LAB_SUBJECT_STR, String.class);
    public static final Param LAB_NUMBER_PARAM = param(LAB_NUMBER_STR, Integer.class);
    public static final Param LAB_DESCRIPTION_PARAM = param(LAB_DESCRIPTION_STR, String.class);
    public static final Param LAB_TASK_PARAM = param(LAB_TASK_STR, String.class);
    public static final Param LAB_REQUIREMENTS_PARAM = param(LAB_REQUIREMENTS_STR, String.class);
    public static final Param LAB_END_DATE_PARAM = param(LAB_END_DATE_STR, LocalTime.class);

    public Map<String,List<Param>> getCommands(){
        if(commands == null) {
            commands = new HashMap<>();
            commands.put(Command.C_NEW, new ArrayList<Param>() {{
                add(LAB_SUBJECT_PARAM);
                add(LAB_NUMBER_PARAM);
                add(LAB_DESCRIPTION_PARAM);
                add(LAB_TASK_PARAM);
                add(LAB_REQUIREMENTS_PARAM);
                add(LAB_END_DATE_PARAM);
            }});
            commands.put(Command.C_DELETE, new ArrayList<Param>() {{
                add(LAB_ID_PARAM);
            }});
            commands.put(Command.C_GET, new ArrayList<Param>() {{
                add(LAB_ID_PARAM);
                add(LAB_SUBJECT_PARAM);
                add(LAB_NUMBER_PARAM);
                add(LAB_DESCRIPTION_PARAM);
                add(LAB_TASK_PARAM);
                add(LAB_REQUIREMENTS_PARAM);
                add(LAB_END_DATE_PARAM);
            }});
            commands.put(Command.C_SET, new ArrayList<Param>() {{
                add(LAB_ID_PARAM);
                add(LAB_SUBJECT_PARAM);
                add(LAB_NUMBER_PARAM);
                add(LAB_DESCRIPTION_PARAM);
                add(LAB_TASK_PARAM);
                add(LAB_REQUIREMENTS_PARAM);
                add(LAB_END_DATE_PARAM);
            }});
            commands.put(Command.C_ALTER, new ArrayList<Param>() {{
                add(LAB_ID_PARAM);
                add(LAB_SUBJECT_PARAM);
                add(LAB_NUMBER_PARAM);
                add(LAB_DESCRIPTION_PARAM);
                add(LAB_TASK_PARAM);
                add(LAB_REQUIREMENTS_PARAM);
                add(LAB_END_DATE_PARAM);
            }});
            commands.put(Command.C_GET_VALUE, new ArrayList<Param>() {{
                add(LAB_ID_PARAM);
                add(LAB_SUBJECT_PARAM);
                add(LAB_NUMBER_PARAM);
                add(LAB_DESCRIPTION_PARAM);
                add(LAB_TASK_PARAM);
                add(LAB_REQUIREMENTS_PARAM);
                add(LAB_END_DATE_PARAM);
            }});
            commands.put(Command.C_COPY, new ArrayList<Param>() {{
                add(LAB_ID_PARAM);
            }});
        }
        return commands;
    }

    private static Param param(String name, Class clazz) {
        return new Param(name,clazz);
    }
}
