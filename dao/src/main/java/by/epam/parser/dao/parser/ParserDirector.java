package by.epam.parser.dao.parser;

import by.epam.parser.dao.parser.exception.ParserNotFoundException;
import by.epam.parser.dao.parser.impl.DOMParserImpl;
import by.epam.parser.dao.parser.impl.SAXParserImpl;
import by.epam.parser.dao.parser.impl.StAXParserImpl;

import java.util.*;

public class ParserDirector {

    private static final String SAX_PARSER = "SAX";
    private static final String DOM_PARSER = "DOM";
    private static final String STAX_PARSER = "STAX";

    private static final ParserDirector instance = new ParserDirector();

    private final Map<String, XMLParser> parsers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);


    private ParserDirector() {
        parsers.put(SAX_PARSER, new SAXParserImpl());
        parsers.put(DOM_PARSER, new DOMParserImpl());
        parsers.put(STAX_PARSER, new StAXParserImpl());

    }

    public static ParserDirector getInstance() {
        return instance;
    }

    public XMLParser get(final String parserType) throws ParserNotFoundException {
        XMLParser xmlParser = parsers.get(parserType);
        if (xmlParser == null) {
            throw new ParserNotFoundException("Parser not found " + parserType);
        }
        return xmlParser;
    }

    public Set<String> getNames() {
        return parsers.keySet();
    }



}
