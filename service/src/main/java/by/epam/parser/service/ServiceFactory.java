package by.epam.parser.service;

import by.epam.parser.dao.BaseDAO;
import by.epam.parser.dao.DAOFactory;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private DAOFactory parserDirector = DAOFactory.getInstance();


    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public BaseService getService(final String parserType) {
        BaseDAO dao = parserDirector.get();
        return new BookServiceImpl(dao, parserType);
    }



}
