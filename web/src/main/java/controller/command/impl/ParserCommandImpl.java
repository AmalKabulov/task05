package controller.command.impl;

import by.epam.parser.entity.Book;
import by.epam.parser.service.ServiceFactory;
import by.epam.parser.service.BaseService;
import by.epam.parser.service.exception.ServiceException;
import controller.ParamConst;
import controller.URL;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ParserCommandImpl implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter(ParamConst.COMMAND);
        String parserParam = request.getParameter(ParamConst.PARSER);

        ServiceFactory service = ServiceFactory.getInstance();
        BaseService parser = service.getService(parserParam);
        try {
            Integer page = Integer.valueOf(request.getParameter(ParamConst.PAGE));

            List<Book> books = (List<Book>) parser.get(page, ParamConst.PAGE_COUNT_VALUE);
            Integer pageCount = parser.getPageCount();


            request.setAttribute(ParamConst.PARSER, parserParam);
            request.setAttribute(ParamConst.PAGE_COUNT, pageCount);
            request.setAttribute(ParamConst.BOOKS, books);
            request.setAttribute(ParamConst.PAGE, page);
            request.setAttribute(ParamConst.COMMAND, command);
            return URL.BOOKS.getValue();
        } catch (ServiceException e) {
            e.printStackTrace();
            return URL.ERROR.getValue();
        }
    }


}
