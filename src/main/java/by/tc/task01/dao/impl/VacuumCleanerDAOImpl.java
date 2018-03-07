package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.impl.dataeditor.DataEditor;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.impl.searcher.SearcherDao;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class VacuumCleanerDAOImpl implements ApplianceDAO {
    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String FILTER_TYPE = "FILTER_TYPE";
    private static final String BAG_TYPE = "BAG_TYPE";
    private static final String WAND_TYPE = "WAND_TYPE";
    private static final String MOTOR_SPEED_REGULATION = "MOTOR_SPEED_REGULATION";
    private static final String CLEANING_WIDTH = "CLEANING_WIDTH";

    private static VacuumCleanerDAOImpl instance;

    public VacuumCleanerDAOImpl() {
    }

    public static VacuumCleanerDAOImpl getInstance() {

        if (instance == null) {
            synchronized (VacuumCleanerDAOImpl.class) {
                if (instance == null) {
                    instance = new VacuumCleanerDAOImpl();
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
            return initializedVacuumCleaner(validData);
        } else {
            throw new DAOException("ENTITY NOT FOUND");
        }
    }

    private Appliance initializedVacuumCleaner(Map<String, String> values){
        VacuumCleaner vacuumCleaner = null;
        if (values != null && !values.isEmpty()){
            vacuumCleaner = new VacuumCleaner();
            vacuumCleaner.setPowerConsumption(Integer.valueOf(values.get(POWER_CONSUMPTION)));
            vacuumCleaner.setFilterType(values.get(FILTER_TYPE));
            vacuumCleaner.setBagType(values.get(BAG_TYPE));
            vacuumCleaner.setWandType(values.get(WAND_TYPE));
            vacuumCleaner.setMotorSpeedRegulation(Integer.valueOf(values.get(MOTOR_SPEED_REGULATION)));
            vacuumCleaner.setCleaningWidth(Integer.valueOf(values.get(CLEANING_WIDTH)));
        }
        return  vacuumCleaner;
    }
}
