package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.impl.dataeditor.DataEditor;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.impl.searcher.SearcherDao;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class OvenDAOImpl implements ApplianceDAO {

    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String WEIGHT = "WEIGHT";
    private static final String CAPACITY = "CAPACITY";
    private static final String DEPTH = "DEPTH";
    private static final String HEIGHT = "HEIGHT";
    private static final String WIDTH = "WIDTH";

    private static OvenDAOImpl instance;

    public OvenDAOImpl() {
    }

    public static OvenDAOImpl getInstance() {

        if (instance == null) {
            synchronized (OvenDAOImpl.class) {
                if (instance == null) {
                    instance = new OvenDAOImpl();
                }
            }
        }
        return instance;
    }


    @Override
    public <E> Appliance find(Criteria<E> criteria) throws DAOException {
//        String[] lines = SearcherDao.getInstance().findByCriteria(criteria).split(" ");// null check.
        String lines = SearcherDao.getInstance().findByCriteria(criteria);
        if (lines != null) {
            Map<String, String> validData = DataEditor.getInstance().getValidData(lines.split(Constant.SPACE));
            return initializedOven(validData);
        } else {
            throw new DAOException("ENTITY NOT FOUND");
        }

    }

    private Appliance initializedOven(Map<String, String> values) {
        Oven oven = null;
        if(values != null && !values.isEmpty()) {
            oven = new Oven();
            oven.setPowerConsumption(Integer.valueOf(values.get(POWER_CONSUMPTION)));
            oven.setWeight(Integer.valueOf(values.get(WEIGHT)));
            oven.setCapacity(Integer.valueOf(values.get(CAPACITY)));
            oven.setDepth(Integer.valueOf(values.get(DEPTH)));
            oven.setHeight(Double.valueOf(values.get(HEIGHT)));
            oven.setWidth(Double.valueOf(values.get(WIDTH)));
        }
        return oven;
    }
}
