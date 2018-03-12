package by.epam.parser.service;

import by.epam.parser.dao.BaseDAO;
import by.epam.parser.entity.Book;
import by.epam.parser.exception.DAOException;

import java.util.Collection;
import java.util.List;

public class BookServiceImpl implements BaseService {

    private BaseDAO dao;
    private String parserType;
    private Integer pageCount;

    public BookServiceImpl(BaseDAO dao, String parserType) {
        this.dao = dao;
        this.parserType = parserType;
    }


    @Override
    public List<Book> get(final int page, final int countOnPage) throws ServiceException {
        int startIndex = (page - 1) * countOnPage;
        int endIndex = countOnPage + startIndex;
        try {
            List books = dao.getAll(parserType);
            pageCount = generatePageCount(books, countOnPage);
            return books.subList(startIndex, endIndex);
        } catch (DAOException e) {
            throw new ServiceException("ERROR WHILE GETTING PART OF BOOKS IN SERVICE " + e);
        }
    }


    private int generatePageCount(final Collection collection, final int countOnPage) {
        return (int) Math.ceil((collection.size() * 1.0) / countOnPage);
    }


    public Integer getPageCount() {
        return pageCount;
    }
}
