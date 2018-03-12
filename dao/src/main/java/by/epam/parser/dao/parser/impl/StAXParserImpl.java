package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.parser.XMLParser;
import by.epam.parser.entity.Book;
import by.epam.parser.dao.parser.exception.ParseException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.List;

public class StAXParserImpl implements XMLParser {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private final StAXProcessHandler stAXProcessHandler = new StAXProcessHandler();

    private XMLStreamReader reader;


    public StAXParserImpl() {
    }


    @Override
    public List<Book> getAll(InputStream inputStream) throws ParseException {
        try {
            reader = FACTORY.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                stAXProcessHandler.handle(reader);
            }
            return stAXProcessHandler.getBooks();
        } catch (XMLStreamException e) {
            throw new ParseException("ERROR WHILE PARSING FILE WITH StAX: " + e);
        }
    }


}
