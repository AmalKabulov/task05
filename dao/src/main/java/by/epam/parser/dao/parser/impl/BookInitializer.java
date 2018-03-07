package by.epam.parser.dao.parser.impl;

import by.epam.parser.entity.Book;
import by.epam.parser.entity.Genre;

import java.time.LocalDate;
import java.util.Map;

public class BookInitializer {
    //    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String GENRE = "genre";
    private static final String PRICE = "price";
    private static final String PUBLISH_DATE = "publish_date";
    private static final String DESCRIPTION = "description";


    public BookInitializer() {
    }


    public void init(final Book book, final Map<String, String> bookValues) {
        String author = bookValues.get(AUTHOR);
        String title = bookValues.get(TITLE);
        String genreValue = bookValues.get(GENRE);
        Genre genre = Genre.getByValue(genreValue);
        Double price = Double.parseDouble(bookValues.get(PRICE));
        String publishDate = bookValues.get(PUBLISH_DATE);
        LocalDate formattedDate = LocalDate.parse(publishDate);
        String description = bookValues.get(DESCRIPTION);


        book.setAuthor(author);
        book.setTitle(title);
        book.setGenre(genre);
        book.setPrice(price);
        book.setDate(formattedDate);
        book.setDescription(description);
    }


}
