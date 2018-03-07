package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;


public class ApplianceDAOImpl implements ApplianceDAO {

    private Map<String, ApplianceDAO> commands = new HashMap<>();

    public ApplianceDAOImpl() {
        commands.put(Constant.OVEN_ENTITY_NAME, OvenDAOImpl.getInstance());
        commands.put(Constant.LAPTOP_ENTITY_NAME, LaptopDAOImpl.getInstance());
        commands.put(Constant.REFRIGERATOR_ENTITY_NAME, RefrigeratorDAOImpl.getInstance());
        commands.put(Constant.SPEAKERS_ENTITY_NAME, SpeakersDAOImpl.getInstance());
        commands.put(Constant.TABLET_PC_ENTITY_NAME, TabletPCDAOImpl.getInstance());
        commands.put(Constant.VACUUM_CLEANER_ENTITY_NAME, VacuumCleanerDAOImpl.getInstance());
    }


    @Override
    public <E> Appliance find(Criteria<E> criteria) throws DAOException {
        ApplianceDAO applianceDAO = commands.get(criteria.getCriteria().keySet().stream()
                .findFirst()
                .get()
                .getClass()
                .getSimpleName());
        return applianceDAO.find(criteria);
    }

}
