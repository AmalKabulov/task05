package by.epam.parser.dao;

import by.epam.parser.entity.BaseEntity;
import by.epam.parser.exception.DAOException;

import java.io.InputStream;
import java.util.List;

public interface XMLParserDao<E extends BaseEntity> {
    List<E> getAll() throws DAOException;
}
