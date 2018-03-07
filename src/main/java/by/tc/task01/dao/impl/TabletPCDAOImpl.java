package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.impl.dataeditor.DataEditor;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.impl.searcher.SearcherDao;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class TabletPCDAOImpl implements ApplianceDAO {
    private static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    private static final String DISPLAY_INCHES = "DISPLAY_INCHES";
    private static final String MEMORY_ROM = "MEMORY_ROM";
    private static final String FLASH_MEMORY_CAPACITY = "FLASH_MEMORY_CAPACITY";
    private static final String COLOR = "COLOR";

    private static TabletPCDAOImpl instance;

    public TabletPCDAOImpl() {
    }

    public static TabletPCDAOImpl getInstance() {

        if (instance == null) {
            synchronized (TabletPCDAOImpl.class) {
                if (instance == null) {
                    instance = new TabletPCDAOImpl();
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
            return initializedTabletPC(validData);
        } else {
            throw new DAOException("ENTITY NOT FOUND");
        }
    }

    private Appliance initializedTabletPC(Map<String, String> values) {
        TabletPC tabletPC = null;
        if (values != null && !values.isEmpty()) {
            tabletPC = new TabletPC();
            tabletPC.setBatteryCapacity(Integer.valueOf(values.get(BATTERY_CAPACITY)));
            tabletPC.setDisplayInches(Integer.valueOf(values.get(DISPLAY_INCHES)));
            tabletPC.setMemoryRom(Integer.valueOf(values.get(MEMORY_ROM)));
            tabletPC.setFlashMemoryCapacity(Integer.valueOf(values.get(FLASH_MEMORY_CAPACITY)));
            tabletPC.setColour(values.get(COLOR));
        }
        return tabletPC;
    }
}
