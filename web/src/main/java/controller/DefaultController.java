package controller;

import controller.command.ActionFactory;
import controller.command.Action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DefaultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prepareResponse(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prepareResponse(req, resp);
    }


    private void prepareResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionFactory actionFactory = ActionFactory.getInstance();
        String command = req.getParameter(Constant.COMMAND);
        Action action = actionFactory.getAction(command);
        String url = action.execute(req);
        req.getRequestDispatcher(url).forward(req, resp);

    }
}
