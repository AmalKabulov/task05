package by.epam.parser.dao;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private BaseDAO bookDao = new BookDAOImpl();

    private DAOFactory() {
    }

    public BaseDAO get() {
        return bookDao;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
