package controller.command;

import controller.Constant;
import controller.command.impl.HomeAction;
import controller.command.impl.ParserAction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionFactory {

    private static final ActionFactory instance = new ActionFactory();
    private final Map<String, Action> actions = new ConcurrentHashMap<>();


    private ActionFactory() {
        actions.put(Constant.ACTION_PARSE, new ParserAction());
        actions.put(Constant.ACTION_MAIN, new HomeAction());
    }


    public Action getAction(String command) {
        if (command == null) {
            command = Constant.ACTION_MAIN;
        }
        return actions.get(command.toLowerCase());

    }

    public static ActionFactory getInstance() {
        return instance;
    }
}
