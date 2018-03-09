package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.parser.Constant;
import by.epam.parser.entity.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaxProcessHandler extends DefaultHandler {

    private final BookInitializer bookInitializer = new BookInitializer();
    private final Map<String, String> bookValues = new HashMap<>();
    private StringBuffer characters = new StringBuffer();
    private String elementName;
    private List<Book> books;
    private Book book;


    public SaxProcessHandler() {
    }

    @Override
    public void startDocument() throws SAXException {
        books = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(Constant.BOOK_ELEMENT_TAG)) {
            book = new Book();
            String id = attributes.getValue(Constant.ID);
            book.setId(id);
        } else {
            elementName = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(Constant.BOOK_ELEMENT_TAG)) {
            bookInitializer.init(book, bookValues);
            books.add(book);
        } else {
            bookValues.put(elementName, characters.toString().trim());
            characters.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String characters = new String(ch, start, length).trim();

        if (characters.length() > 0) {
            characters = characters.replaceAll(Constant.TWO_SPACES, Constant.SPACE);
            characters += " ";
            this.characters.append(characters);
        }
    }


    public List<Book> getBooks() {
        return books;
    }


}
