package edu.kpi.labtime.constants;

@Deprecated
public interface CommandsRegexp {

    String KEY_REGEXP   = "([\\b]+)";

    String PARAM_REGEXP = "([\\b]+)";

    String C_NEW        = "^new";

    String C_DELETE     = "^del(\\s+)"+KEY_REGEXP;

    String C_SET        = "^set(\\s+)"+KEY_REGEXP;

    String C_GET_ALL    = "^get(\\s*)$";

    String C_GET        = "^get (/("+PARAM_REGEXP+"):(\\S))+";

    String C_GET_VALUE  = "^getValue(\\s+)";

    String C_CPY        = "^cpy(\\s+)"+KEY_REGEXP+"(\\s+)"+PARAM_REGEXP;
}
