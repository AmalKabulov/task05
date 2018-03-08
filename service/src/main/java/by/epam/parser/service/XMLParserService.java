package by.epam.parser.service;

import by.epam.parser.entity.BaseEntity;
import by.epam.parser.service.exception.ServiceException;

import java.util.List;

public interface XMLParserService<E extends BaseEntity> {
    List<E> get(final int page, final int count) throws ServiceException;
    Integer getPageCount();
}
