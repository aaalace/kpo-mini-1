package com.aaalace.kpomini1.util;

import com.aaalace.kpomini1.common.enums.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandUtil {
    private static final String OPTION_1 = "1. Post new animal";
    private static final String OPTION_2 = "2. Get all animals";
    private static final String OPTION_3 = "3. Get total needed food";
    private static final String OPTION_4 = "4. Get contacting animals";
    private static final String OPTION_5 = "5. Exit application";

    private static final Map<String, Command> commandMap = new HashMap<>();

    static {
        for (Command cmd : Command.values()) {
            commandMap.put(cmd.id, cmd);
        }
    }

    public static Command getCommandById(String id) throws Exception {
        final Command command = commandMap.get(id);
        if (command == null) {
            throw new Exception("Incorrect command");
        }
        return command;
    }

    public static void outCommands() {
        System.out.println("[ Choose command ]");
        System.out.println(OPTION_1);
        System.out.println(OPTION_2);
        System.out.println(OPTION_3);
        System.out.println(OPTION_4);
        System.out.println(OPTION_5);
        System.out.print(">>> ");
    }
}