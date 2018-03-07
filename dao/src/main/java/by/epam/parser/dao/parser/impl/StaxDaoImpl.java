package by.epam.parser.dao.parser.impl;

import by.epam.parser.dao.BaseDao;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;
import by.epam.parser.exception.ParserCreationException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.List;

public class StaxDaoImpl implements BaseDao<Book> {

//    private static final InputStream inputStream = ;
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private final StaxProcessHandler staxProcessHandler = new StaxProcessHandler();
    private  XMLStreamReader reader;



    public StaxDaoImpl() {

    }


    @Override
    public List<Book> getAll() throws DAOException {
        try {
            reader = FACTORY.createXMLStreamReader(SourceStream.getInputStream());
            while (reader.hasNext()) {
                staxProcessHandler.handle(reader);
            }
            return staxProcessHandler.getBooks();
        } catch (XMLStreamException e) {
            throw new DAOException("ERROR WHILE PARSING FILE WITH StAX: " + e);
        }
    }





}
