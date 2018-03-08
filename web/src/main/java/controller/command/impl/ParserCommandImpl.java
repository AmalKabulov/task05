package controller.command.impl;

import by.epam.parser.entity.Book;
import by.epam.parser.service.ServiceFactory;
import by.epam.parser.service.XMLParserService;
import by.epam.parser.service.exception.ServiceException;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ParserCommandImpl implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter("command");
        String parserParam = request.getParameter("parser");

        ServiceFactory service = ServiceFactory.getInstance();
        XMLParserService parser = service.getService(parserParam);
        try {
            Integer page = Integer.valueOf(request.getParameter("page"));

            List<Book> books = (List<Book>) parser.get(page, 3);
            Integer pageCount = parser.getPageCount();


            request.setAttribute("parser", parserParam);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("books", books);
            request.setAttribute("page", page);
            request.setAttribute("command", command);
            return "WEB-INF/template/books.jsp";
        } catch (ServiceException e) {
            e.printStackTrace();
            return "WEB-INF/template/error.jsp";
        }
    }


}
