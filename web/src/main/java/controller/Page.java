package controller;

public enum Page {
    INDEX("WEB-INF/template/index.jsp"),
    BOOKS("WEB-INF/template/books.jsp"),
    ERROR("WEB-INF/template/error.jsp");

    private String path;

    Page(String value) {
        this.path = value;
    }

    public String getPath() {
        return path;
    }
}
