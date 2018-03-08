package controller;

import by.epam.parser.entity.Book;
import by.epam.parser.service.XMLParserService;
import by.epam.parser.service.ServiceFactory;
import by.epam.parser.service.exception.ServiceException;
import controller.command.ActionDirector;
import controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        prepareResponse(req, resp);


//        String command = req.getParameter("controller/command");
//        System.out.println(command);
//        String parser = req.getParameter("parser");
//        if (parser != null) {
//            ServiceFactory serviceFactory = ServiceFactory.getInstance();
//            XMLParserService service = serviceFactory.getService(parser);
//            try {
//                List all = service.getAll();
//                req.setAttribute("books", all);
//            } catch (ServiceException e) {
//                e.printStackTrace();
//            }
//            System.out.println(parser);
//            req.getRequestDispatcher("WEB-INF/template/books.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/WEB-INF/template/index.jsp").forward(req, resp);
//        }
//        prepareResponce(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prepareResponse(req, resp);
    }


    private void prepareResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActionDirector actionDirector = ActionDirector.getInstance();
        String command = req.getParameter("command");
        if (command != null) {
            Command action = actionDirector.getAction(command);
            String url = action.execute(req);
            req.getRequestDispatcher(url).forward(req, resp);

        }
        req.getRequestDispatcher(URL.INDEX.getValue()).forward(req, resp);
    }
}
