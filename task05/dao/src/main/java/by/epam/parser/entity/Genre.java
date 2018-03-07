package by.epam.parser.entity;

import java.util.HashMap;
import java.util.Map;

public enum Genre {
    COMPUTER("Computer"),
    FANTASY("Fantasy"),
    ROMANCE("Romance"),
    HORROR("Horror");

    private static final Map<String, Genre> genres = new HashMap<>();

    static {
        for (Genre genre : values()) {
            genres.put(genre.getValue(), genre);
        }
    }

    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Genre getByValue(final String value) {
        return genres.get(value);
    }

}
