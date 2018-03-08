package by.epam.parser.service;

import by.epam.parser.dao.XMLParserDao;
import by.epam.parser.dao.DAOFactory;
import by.epam.parser.service.exception.ServiceException;
import by.epam.parser.service.impl.BookServiceImpl;

import java.util.List;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private DAOFactory daoFactory = DAOFactory.getInstance();


    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public XMLParserService getService(final String parserType) {
        XMLParserDao dao = daoFactory.getDAO(parserType);
        return new BookServiceImpl(dao);
    }


}
