package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.XMLParserDao;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;
import by.epam.parser.exception.ParserCreationException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SaxParserDaoImp implements XMLParserDao<Book> {

    private final InputStream inputStream;
    private final SaxProcessHandler saxProcessHandler = new SaxProcessHandler();
    private final SAXParser saxParser;

    {
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new ParserCreationException("ERROR WHILE CREATING SAX PARSER " + e);
        }
    }

    public SaxParserDaoImp(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<Book> getAll() throws DAOException {
        try {
            saxParser.parse(inputStream, saxProcessHandler);
            return saxProcessHandler.getBooks();
        } catch (SAXException | IOException e) {
            throw new DAOException("ERROR WHILE PARSING FILE WITH SAX" + e);
        }
    }


}
