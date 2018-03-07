package by.epam.parser.service;

import by.epam.parser.entity.BaseEntity;
import by.epam.parser.service.exception.ServiceException;

import java.util.List;

public interface BaseService<E extends BaseEntity> {
    List<E> getAll() throws ServiceException;

}