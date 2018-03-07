package by.epam.parser.service.impl;

import by.epam.parser.dao.BaseDao;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;
import by.epam.parser.service.BaseService;
import by.epam.parser.service.exception.ServiceException;

import java.util.List;

public class BookServiceImpl implements BaseService<Book> {

    private BaseDao dao;

    public BookServiceImpl(BaseDao dao) {
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
