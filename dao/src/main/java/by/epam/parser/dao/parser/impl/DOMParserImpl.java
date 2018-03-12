package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.parser.Constant;
import by.epam.parser.dao.parser.XMLParser;
import by.epam.parser.entity.Book;
import by.epam.parser.dao.parser.exception.ParseException;
import by.epam.parser.dao.parser.exception.ParserCreationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DOMParserImpl implements XMLParser {

    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
    private final BookInitializer bookInitializer = new BookInitializer();
//    private final InputStream inputStream;
    private final DocumentBuilder dom;

    {
        try {
            dom = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            throw new ParserCreationException("ERROR WHILE CREATING DOM PARSER: " + e);
        }
    }

    public DOMParserImpl() {
//        this.inputStream = inputStream;
    }


    @Override
    public List<Book> getAll(InputStream inputStream) throws ParseException {
        try {
            Document result = dom.parse(inputStream);
            return handle(result);
        } catch (SAXException | IOException e) {
            throw new ParseException("ERROR WHILE PARSING FILE WITH DOM " + e);
        }
    }


    private List<Book> handle(final Document document) {
        List<Book> booksList = new ArrayList<>();
        NodeList books = document.getElementsByTagName(Constant.BOOK_ELEMENT_TAG);
        for (int i = 0; i < books.getLength(); i++) {
            Book book = new Book();
            Element bookElement = (Element) books.item(i);
            bookInitializer.init(book, bookElement);
            booksList.add(book);
        }
        return booksList;
    }

}
