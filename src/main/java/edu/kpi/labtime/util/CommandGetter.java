package edu.kpi.labtime.util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kpi.labtime.constants.Command;
import edu.kpi.labtime.model.Param;

public class CommandGetter {

    private static CommandGetter INSTANCE = new CommandGetter();

    public static CommandGetter getInstance() {
        return INSTANCE;
    }

    private CommandGetter() {}

    private Map<String,List<Param>> commands = null;

    public final Param LAB_ID_PARAM = param("Id", Integer.class);
    public final Param LAB_SUBJECT_PARAM = param("subject", String.class);
    public final Param LAB_NUMBER_PARAM = param("number", Integer.class);
    public final Param LAB_DESCRIPTION_PARAM = param("description", String.class);
    public final Param LAB_TASK_PARAM = param("task", String.class);
    public final Param LAB_REQUIREMENTS_PARAM = param("requirements", String.class);
    public final Param LAB_END_DATE_PARAM = param("endDate", LocalTime.class);

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
