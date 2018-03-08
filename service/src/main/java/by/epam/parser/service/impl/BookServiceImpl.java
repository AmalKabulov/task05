package by.epam.parser.service.impl;

import by.epam.parser.dao.XMLParserDao;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;
import by.epam.parser.service.XMLParserService;
import by.epam.parser.service.exception.ServiceException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements XMLParserService<Book> {

    private XMLParserDao dao;
    private Integer pageCount;

    public BookServiceImpl(XMLParserDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Book> get(final int page, final int countOnPage) throws ServiceException {
        int startIndex =  (page - 1)  * countOnPage;
        int endIndex = countOnPage + startIndex;
        try {
            List books = dao.getAll();
            pageCount = generatePageCount(books, countOnPage);
            return books.subList(startIndex, endIndex);
        } catch (DAOException e) {
            throw new ServiceException("ERROR WHILE GETTING PART OF BOOKS IN SERVICE " + e);
        }
    }

    public Integer getPageCount() {
        return pageCount;
    }

    private int generatePageCount(final Collection collection, final int countOnPage) {
        return (int) Math.ceil( (collection.size() * 1.0) / countOnPage);
    }
}
