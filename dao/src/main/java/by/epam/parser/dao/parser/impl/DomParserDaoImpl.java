package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.XMLParserDao;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;
import by.epam.parser.exception.ParserCreationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DomParserDaoImpl implements XMLParserDao<Book> {

    private final InputStream inputStream;
    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
    private final DomProcessHandler processHandler = new DomProcessHandler();
    private final DocumentBuilder dom;

    {
        try {
//            factory.setIgnoringComments(true);
//            factory.setIgnoringElementContentWhitespace(true);
            dom = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            throw new ParserCreationException("ERROR WHILE CREATING DOM PARSER: " + e);
        }
    }

    public DomParserDaoImpl(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public List<Book> getAll() throws DAOException {
        try {
            Document result = dom.parse(inputStream);
            processHandler.handle(result);
            return processHandler.getBooks();
        } catch (SAXException | IOException e) {
            throw new DAOException("ERROR WHILE PARSING FILE WITH DOM " + e);
        }
    }

}
