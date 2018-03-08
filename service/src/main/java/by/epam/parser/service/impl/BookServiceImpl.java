package by.epam.parser.service.impl;

import by.epam.parser.dao.XMLParserDao;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;
import by.epam.parser.service.XMLParserService;
import by.epam.parser.service.exception.ServiceException;

import java.util.List;

public class BookServiceImpl implements XMLParserService<Book> {

    private XMLParserDao dao;

    public BookServiceImpl(XMLParserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            throw new ServiceException("ERROR WHILE WORKING WITH DAO " + e);
        }
    }
}
