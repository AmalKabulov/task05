package by.epam.parser.dao;

import by.epam.parser.dao.parser.impl.DomDaoImpl;
import by.epam.parser.dao.parser.impl.SaxDaoImp;
import by.epam.parser.dao.parser.impl.StaxDaoImpl;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();


    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public BaseDao getDAO(final String parserType) {
        if (parserType.equalsIgnoreCase("SAX")) {
            return new SaxDaoImp();
        } else if (parserType.equalsIgnoreCase("DOM")) {
            return new DomDaoImpl();
        } else {
            return new StaxDaoImpl();
        }
    }
}
