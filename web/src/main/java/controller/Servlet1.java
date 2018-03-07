package controller;

import by.epam.parser.service.BaseService;
import by.epam.parser.service.ServiceFactory;
import by.epam.parser.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@WebServlet("/")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parser = req.getParameter("parser");
        if (parser != null) {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BaseService service = serviceFactory.getService(parser);
            try {
                List all = service.getAll();
                req.setAttribute("books", all);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            System.out.println(parser);
            req.getRequestDispatcher("WEB-INF/template/books.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/template/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String[] strings = req.getParameterMap().values().stream().filter(Objects::nonNull).findAny().orElse(null);
//        System.out.println(strings[1]);
//        String sax = req.getParameter("parser");
//        System.out.println(sax);
//        doGet(req, resp);
    }
}
