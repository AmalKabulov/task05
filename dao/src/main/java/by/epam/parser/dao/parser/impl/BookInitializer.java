package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.parser.Constant;
import by.epam.parser.entity.Book;
import by.epam.parser.entity.Genre;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.util.Map;

public class BookInitializer {


    public BookInitializer() {
    }


    public void init(final Book book, final Map<String, String> bookValues) {
        book.setAuthor(bookValues.get(Constant.AUTHOR));
        book.setTitle(bookValues.get(Constant.TITLE));
        book.setGenre(Genre.getByValue(bookValues.get(Constant.GENRE)));
        book.setPrice(Double.valueOf(bookValues.get(Constant.PRICE)));
        book.setDate(LocalDate.parse(bookValues.get(Constant.PUBLISH_DATE)));
        book.setDescription(bookValues.get(Constant.DESCRIPTION));
    }

    public void init(final Book book, final Element element) {
        book.setId(element.getAttribute(Constant.ID));
        book.setAuthor(getTextContext(element, Constant.AUTHOR));
        book.setTitle(getTextContext(element, Constant.TITLE));
        book.setGenre(Genre.getByValue(getTextContext(element, Constant.GENRE)));
        book.setPrice(Double.valueOf(getTextContext(element, Constant.PRICE)));
        book.setDate(LocalDate.parse(getTextContext(element, Constant.PUBLISH_DATE)));
        book.setDescription(getTextContext(element, Constant.DESCRIPTION));

    }

    private String getTextContext(final Element element, final String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }




}
