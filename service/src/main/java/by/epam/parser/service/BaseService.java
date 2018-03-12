package by.epam.parser.service;

import by.epam.parser.entity.Book;

import java.util.List;

public interface BaseService {
    List<Book> get(final int page, final int count) throws ServiceException;
    Integer getPageCount();
}
