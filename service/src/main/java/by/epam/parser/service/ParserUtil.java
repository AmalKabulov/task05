package by.epam.parser.service;

import by.epam.parser.dao.parser.ParserDirector;

import java.util.Set;

public class ParserUtil {

    private ParserUtil() {
    }

    public static Set<String> getParsers() {
        return ParserDirector.getInstance().getNames();
    }
}
