package controller.command;

import controller.ParamConst;
import controller.command.impl.HomeCommand;
import controller.command.impl.ParserCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionDirector {

    private static final ActionDirector instance = new ActionDirector();
    private final Map<String, Command> actions = new ConcurrentHashMap<>() {
        {
            put("parse", new ParserCommand());
            put("main", new HomeCommand());
        }
    };


    private ActionDirector() {
    }


    public String runAction(final HttpServletRequest req) {
        String command = req.getParameter(ParamConst.COMMAND);
        return actions.get(command.toLowerCase()).execute(req);

    }

    public static ActionDirector getInstance() {
        return instance;
    }
}
