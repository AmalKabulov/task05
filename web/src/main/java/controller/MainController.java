package controller;

import controller.command.ActionDirector;
import controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prepareResponse(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prepareResponse(req, resp);
    }


    private void prepareResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionDirector actionDirector = ActionDirector.getInstance();
        String command = req.getParameter(ParamConst.COMMAND);
        if (command != null) {
            Command action = actionDirector.getAction(command);
            String url = action.execute(req);
            req.getRequestDispatcher(url).forward(req, resp);

        }
        req.getRequestDispatcher(URL.INDEX.getValue()).forward(req, resp);
    }
}
