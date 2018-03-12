package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.parser.XMLParser;
import by.epam.parser.entity.Book;
import by.epam.parser.dao.parser.exception.ParseException;
import by.epam.parser.dao.parser.exception.ParserCreationException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SAXParserImpl implements XMLParser {

    private final SAXProcessHandler SAXProcessHandler = new SAXProcessHandler();
//    private final InputStream inputStream;
    private final SAXParser saxParser;

    {
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new ParserCreationException("ERROR WHILE CREATING SAX PARSER " + e);
        }
    }

    public SAXParserImpl() {
//        this.inputStream = inputStream;
    }

    public List<Book> getAll(InputStream inputStream) throws ParseException {
        try {
            saxParser.parse(inputStream, SAXProcessHandler);
            return SAXProcessHandler.getBooks();
        } catch (SAXException | IOException e) {
            throw new ParseException("ERROR WHILE PARSING FILE WITH SAX" + e);
        }
    }


}
