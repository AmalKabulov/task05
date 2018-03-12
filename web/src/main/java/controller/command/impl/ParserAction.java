package controller.command.impl;

import by.epam.parser.entity.Book;
import by.epam.parser.service.ServiceFactory;
import by.epam.parser.service.BaseService;
import by.epam.parser.service.ServiceException;
import controller.Constant;
import controller.Page;
import controller.command.Action;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.apache.log4j.Logger;

public class ParserAction implements Action {

    private static final Logger logger = Logger.getLogger(ParserAction.class);

    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter(Constant.COMMAND);
        String parserParam = request.getParameter(Constant.PARSER);

        ServiceFactory service = ServiceFactory.getInstance();
        BaseService parser = service.getService(parserParam);
        try {
            Integer page = Integer.valueOf(request.getParameter(Constant.PAGE));

            List<Book> books = parser.get(page, Constant.PAGE_COUNT_VALUE);
            Integer pageCount = parser.getPageCount();


            request.setAttribute(Constant.PARSER, parserParam);
            request.setAttribute(Constant.PAGE_COUNT, pageCount);
            request.setAttribute(Constant.BOOKS, books);
            request.setAttribute(Constant.PAGE, page);
            request.setAttribute(Constant.COMMAND, command);
            return Page.BOOKS.getPath();
        } catch (ServiceException e) {
            logger.error(e.getMessage());

            request.setAttribute(Constant.ERR_MESSAGE, Constant.ERR_MESSAGE_VAL);

            return Page.ERROR.getPath();
        }
    }


}
