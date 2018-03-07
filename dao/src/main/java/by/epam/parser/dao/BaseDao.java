package by.epam.parser.dao;

import by.epam.parser.entity.BaseEntity;
import by.epam.parser.exception.DAOException;

import java.util.List;

public interface BaseDao<E extends BaseEntity> {
    List<E> getAll() throws DAOException;
}
