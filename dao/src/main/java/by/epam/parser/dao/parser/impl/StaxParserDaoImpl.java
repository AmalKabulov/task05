package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.XMLParserDao;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.List;

public class StaxParserDaoImpl implements XMLParserDao<Book> {

    private final InputStream inputStream;
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private final StaxProcessHandler staxProcessHandler = new StaxProcessHandler();
    private  XMLStreamReader reader;



    public StaxParserDaoImpl(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    @Override
    public List<Book> getAll() throws DAOException {
        try {
            reader = FACTORY.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                staxProcessHandler.handle(reader);
            }
            return staxProcessHandler.getBooks();
        } catch (XMLStreamException e) {
            throw new DAOException("ERROR WHILE PARSING FILE WITH StAX: " + e);
        }
    }





}
