package by.epam.parser.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Book extends BaseEntity{
    private String author;
    private String title;
    private Genre genre;
    private Double price;
    private LocalDate date;
    private String description;


    public Book() {
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId()) &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                genre == book.genre &&
                Objects.equals(price, book.price) &&
                Objects.equals(date, book.date) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), author, title, genre, price, date, description);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", price=" + price +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
