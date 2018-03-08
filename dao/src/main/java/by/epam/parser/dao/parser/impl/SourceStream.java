package by.epam.parser.dao.parser.impl;

import java.io.InputStream;

public class SourceStream {
//    private static final InputStream inputstream;

    public SourceStream() {
    }

    // TODO need new one
//    static {
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        inputstream = classLoader.getResourceAsStream("books.xml");
//    }

    // TODO return new one
    public InputStream getInputStream() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResourceAsStream("books.xml");
//        return inputstream;
    }
}
