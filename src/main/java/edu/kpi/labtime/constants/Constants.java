package edu.kpi.labtime.constants;

public interface Constants {

    String HELP_INFO = "new /paramname1:value1 [.../paramnameN:valueN]   --create item with specified param(s)\n" +
            "del <key>                                                   --delete item by key\n" +
            "set <key> /paramname1:new_value1 [.../paramnameN:new_valueN]--replace param with new value\n" +
            "alt <key> /paramname1:delta1 [.../paramnameN:deltaN]        --change selected param on specified delta\n" +
            "get                                                         --get all items\n" +
            "get <key>                                                   --get disieredItem\n" +
            "get /paramname:value                                        --get all with same param\n" +
            "get /paramname:value_min&value_max                          --get all in selected param range \t&\n" +
            "get /paramname:value1|value2                                --get all with paramname value equals to value1 or value2\t|\n" +
            "get /paramname1:value1 [.../paramnameN:valueN]              --get all with paramname1 value equals to value1 (and paramnameN value equals to valueN)\n" +
            "getValue <paramname> <item key>                             --get specified param value of specified item\n" +
            "getValue <paramname>                                        --get all used values of specified params\n" +
            "cpy <key>                                                   --creates a copy of selected item with new key\n";
}
