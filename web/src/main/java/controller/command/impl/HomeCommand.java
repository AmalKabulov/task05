package controller.command.impl;

import controller.URL;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return URL.INDEX.getValue();
    }
}
