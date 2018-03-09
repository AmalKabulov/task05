package controller.command;

import controller.command.impl.ParserCommandImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionDirector {

    private static final ActionDirector instance = new ActionDirector();
    private final Map<String, Command> commands = new ConcurrentHashMap<>() {
        {
            put("parse", new ParserCommandImpl());
        }
    };


    private ActionDirector() {
    }


    public Command getAction(final String command) {
        return commands.get(command.toLowerCase());

    }

    public static ActionDirector getInstance() {
        return instance;
    }
}
