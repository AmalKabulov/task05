package by.epam.parser.dao;

import by.epam.parser.dao.parser.ParserDirector;
import by.epam.parser.dao.parser.XMLParser;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;
import by.epam.parser.dao.parser.exception.ParseException;
import by.epam.parser.dao.parser.exception.ParserNotFoundException;

import java.io.InputStream;
import java.util.List;

public class BookDAOImpl implements BaseDAO {

    private static final String BOOKS_XML = "books.xml";


    public List<Book> getAll(String parserType) throws DAOException {

        XMLParser parser = null;
        try {
            parser = ParserDirector.getInstance().get(parserType);
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = contextClassLoader.getResourceAsStream(BOOKS_XML);

            return parser.getAll(inputStream);
        } catch (ParserNotFoundException | ParseException e) {
            throw new DAOException("ERROR WHILE PARSING ", e);
        }

    }

}
