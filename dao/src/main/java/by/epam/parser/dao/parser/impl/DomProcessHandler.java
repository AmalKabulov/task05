package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.parser.Constant;
import by.epam.parser.entity.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomProcessHandler {

    private final BookInitializer bookInitializer = new BookInitializer();
    private final Map<String, String> bookValues = new HashMap<>();
    private final List<Book> books = new ArrayList<>();

    public void handle(final Document document) {
        NodeList books = document.getElementsByTagName(Constant.BOOK_ELEMENT_TAG);
        if (books.getLength() > 0) {
            nodeHandler(books);
        }
    }


    private void nodeHandler(final NodeList parentElements) {
        int length = parentElements.getLength();
        for (int i = 0; i < length; i++) {
            Book book = new Book();
            Node parent = parentElements.item(i);
            attributeHandler(parent, book);
            if (parent.hasChildNodes()) {
                NodeList children = parent.getChildNodes();
                childHandler(children);
            }
            bookInitializer.init(book, bookValues);
            books.add(book);
        }
    }


    private void childHandler(final NodeList childElements) {
        int length = childElements.getLength();
        for (int i = 0; i < length; i++) {
            Node child = childElements.item(i);
            if (!child.getNodeName().equals(Constant.TEXT)) {
                parse(child);
            }
        }
    }


    private void attributeHandler(final Node node, final Book book) {
        if (node.hasAttributes()) {
            String id = node.getAttributes().getNamedItem(Constant.ID).getTextContent();
            book.setId(id);
        }
    }


    private void parse(final Node node) {
        String text = null;
        String nodeName = node.getNodeName();
        if (node.getTextContent() != null) {
            text = node.getTextContent();
            text = text.replaceAll(Constant.TWO_SPACES, Constant.SPACE);
        }
        bookValues.put(nodeName, text.trim());
    }

    public List<Book> getBooks() {
        return books;
    }

}
