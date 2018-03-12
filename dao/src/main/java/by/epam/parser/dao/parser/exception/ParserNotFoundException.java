package by.epam.parser.dao.parser.exception;

public class ParserNotFoundException extends Exception {



    public ParserNotFoundException() {
        super();
    }

    public ParserNotFoundException(String message) {
        super(message);
    }

    public ParserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ParserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    //TODO
//    private String parserType;
//
//    ParserNotFoundException(String parserType) {
//        super();
//        this.parserType = parserType;
//    }
//
//    public String getMessage() {
//        return "PARSER TYPE: " + parserType + " NOT FOUND";
//    }


}
