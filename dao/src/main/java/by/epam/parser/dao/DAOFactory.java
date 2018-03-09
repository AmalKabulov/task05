package by.epam.parser.dao;

import by.epam.parser.dao.parser.Constant;
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
        InputStream inputStream = contextClassLoader.getResourceAsStream(Constant.BOOKS_XML);

        if (parserType.equalsIgnoreCase(Constant.SAX_PARSER)) {
            return new SaxParserDaoImp(inputStream);
        } else if (parserType.equalsIgnoreCase(Constant.DOM_PARSER)) {
            return new DomParserDaoImpl(inputStream);
        } else {
            return new StaxParserDaoImpl(inputStream);
        }
    }
}
