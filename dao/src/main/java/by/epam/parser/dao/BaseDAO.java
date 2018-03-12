package by.epam.parser.dao;

import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;

import java.util.List;
import java.util.Set;

public interface BaseDAO {

    List<Book> getAll(String parserType) throws DAOException;

}
