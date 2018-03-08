package controller;

public enum URL {
    INDEX("WEB-INF/template/index.jsp"),
    BOOKS("WEB-INF/template/books.jsp"),
    ERROR("WEB-INF/template/error.jsp");

    private String value;

    URL(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
