package by.epam.parser.dao;

import by.epam.parser.dao.parser.impl.DomParserDaoImpl;
import by.epam.parser.dao.parser.impl.SaxParserDaoImp;
import by.epam.parser.dao.parser.impl.StaxParserDaoImpl;

import java.io.InputStream;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();


    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public XMLParserDao getDAO(final String parserType) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = contextClassLoader.getResourceAsStream("books.xml");

        if (parserType.equalsIgnoreCase("SAX")) {
            return new SaxParserDaoImp(inputStream);
        } else if (parserType.equalsIgnoreCase("DOM")) {
            return new DomParserDaoImpl(inputStream);
        } else {
            return new StaxParserDaoImpl(inputStream);
        }
    }
}
