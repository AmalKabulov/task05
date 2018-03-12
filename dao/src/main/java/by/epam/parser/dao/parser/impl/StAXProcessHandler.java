package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.parser.Constant;
import by.epam.parser.entity.Book;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StAXProcessHandler {

    private final BookInitializer bookInitializer = new BookInitializer();
    private final Map<String, String> bookValues = new HashMap<>();
    private final List<Book> books = new ArrayList<>();
    private StringBuffer characters = new StringBuffer();
    private String elementName;
    private Book book;


    public void handle(final XMLStreamReader reader) throws XMLStreamException {
        int element = reader.next();

        if (element == XMLStreamConstants.START_ELEMENT) {
            startElementHandler(reader);

        } else if (element == XMLStreamConstants.CHARACTERS) {
            characterHandler(reader);

        } else if (element == XMLStreamConstants.END_ELEMENT) {
            endElementHandler(reader);

        } else if (element == XMLStreamConstants.END_DOCUMENT) {
            reader.close();
        }
    }

    private void startElementHandler(final XMLStreamReader reader) {

        String elementName = reader.getLocalName();
        if (elementName.equals(Constant.BOOK_ELEMENT_TAG)) {
            book = new Book();
            attributeHandler(reader);
        } else {
            this.elementName = elementName;
        }
    }

    private void attributeHandler(final XMLStreamReader reader) {
        for (int i = 0, n = reader.getAttributeCount(); i < n; ++i) {
            String value = reader.getAttributeValue(i);
            book.setId(value);
        }
    }

    private void endElementHandler(final XMLStreamReader reader) {
        String endElementName = reader.getLocalName();
        if (endElementName.equals(Constant.BOOK_ELEMENT_TAG)) {
            bookInitializer.init(book, bookValues);
            books.add(book);
        } else {
            bookValues.put(elementName, characters.toString().trim());
            characters.setLength(0);
        }
    }

    private void characterHandler(final XMLStreamReader reader) throws XMLStreamException {
        String text = reader.getText().trim();
        if (text.length() > 0) {
            text = text.replaceAll(Constant.TWO_SPACES, Constant.SPACE);
            text += Constant.SPACE;
            characters.append(text);
        }


    }

    public List<Book> getBooks() {
        return books;
    }

}
