package by.epam.parser.dao.parser.impl;

import by.epam.parser.entity.Book;
import by.epam.parser.entity.Genre;

import java.time.LocalDate;
import java.util.Map;

public class BookInitializer {


    public BookInitializer() {
    }


    public void init(final Book book, final Map<String, String> bookValues) {
        String author = bookValues.get(Constant.AUTHOR);
        String title = bookValues.get(Constant.TITLE);
        String genreValue = bookValues.get(Constant.GENRE);
        Genre genre = Genre.getByValue(genreValue);
        Double price = Double.parseDouble(bookValues.get(Constant.PRICE));
        String publishDate = bookValues.get(Constant.PUBLISH_DATE);
        LocalDate formattedDate = LocalDate.parse(publishDate);
        String description = bookValues.get(Constant.DESCRIPTION);


        book.setAuthor(author);
        book.setTitle(title);
        book.setGenre(genre);
        book.setPrice(price);
        book.setDate(formattedDate);
        book.setDescription(description);
    }


}
