package by.epam.parser.dao.parser;

import by.epam.parser.entity.BaseEntity;
import by.epam.parser.dao.parser.exception.ParseException;
import by.epam.parser.entity.Book;

import java.io.InputStream;
import java.util.List;

public interface XMLParser {
    List<Book> getAll(InputStream inputStream) throws ParseException;
}
