package by.epam.parser.exception;

public class ParserCreationException extends RuntimeException {
    public ParserCreationException() {
        super();
    }

    public ParserCreationException(String message) {
        super(message);
    }

    public ParserCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserCreationException(Throwable cause) {
        super(cause);
    }

    protected ParserCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
