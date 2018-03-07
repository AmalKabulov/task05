package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.impl.dataeditor.DataEditor;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.impl.searcher.SearcherDao;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class RefrigeratorDAOImpl implements ApplianceDAO {

    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String WEIGHT = "WEIGHT";
    private static final String FREEZER_CAPACITY = "FREEZER_CAPACITY";
    private static final String OVERALL_CAPACITY = "OVERALL_CAPACITY";
    private static final String HEIGHT = "HEIGHT";
    private static final String WIDTH = "WIDTH";

    private static RefrigeratorDAOImpl instance;

    public RefrigeratorDAOImpl() {
    }

    public static RefrigeratorDAOImpl getInstance() {

        if (instance == null) {
            synchronized (RefrigeratorDAOImpl.class) {
                if (instance == null) {
                    instance = new RefrigeratorDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public <E> Appliance find(Criteria<E> criteria) throws DAOException {
        String lines = SearcherDao.getInstance().findByCriteria(criteria);
        if (lines != null) {
            Map<String, String> validData = DataEditor.getInstance().getValidData(lines.split(Constant.SPACE));
            return initializedRefrigerator(validData);
        } else {
            throw new DAOException("ENTITY NOT FOUND");
        }
    }

    private Appliance initializedRefrigerator(Map<String, String> values) {
        Refrigerator refrigerator = null;
        if(values != null && !values.isEmpty()) {
            refrigerator = new Refrigerator();
            refrigerator.setPowerConsumption(Integer.valueOf(values.get(POWER_CONSUMPTION)));
            refrigerator.setWeight(Integer.valueOf(values.get(WEIGHT)));
            refrigerator.setFreezerCapacity(Integer.valueOf(values.get(FREEZER_CAPACITY)));
            refrigerator.setOverallCapacity(Double.valueOf(values.get(OVERALL_CAPACITY)));
            refrigerator.setHeight(Integer.valueOf(values.get(HEIGHT)));
            refrigerator.setWidth(Integer.valueOf(values.get(WIDTH)));
        }

        return refrigerator;
    }
}
