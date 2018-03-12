package controller.command.impl;

import controller.Page;
import controller.command.Action;

import javax.servlet.http.HttpServletRequest;

public class HomeAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {
        return Page.INDEX.getPath();
    }
}
