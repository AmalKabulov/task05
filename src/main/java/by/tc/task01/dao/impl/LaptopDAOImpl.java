package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.impl.dataeditor.DataEditor;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.impl.searcher.SearcherDao;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class LaptopDAOImpl implements ApplianceDAO {

    private static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    private static final String OS = "OS";
    private static final String MEMORY_ROM = "MEMORY_ROM";
    private static final String SYSTEM_MEMORY = "SYSTEM_MEMORY";
    private static final String CPU = "CPU";
    private static final String DISPLAY_INCHS = "DISPLAY_INCHS";


    private static LaptopDAOImpl instance;

    public LaptopDAOImpl() {
    }

    public static LaptopDAOImpl getInstance() {

        if (instance == null) {
            synchronized (LaptopDAOImpl.class) {
                if (instance == null) {
                    instance = new LaptopDAOImpl();
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
            return initializedLaptop(validData);
        } else {
            throw new DAOException("ENTITY NOT FOUND");
        }
    }


    private Appliance initializedLaptop(Map<String, String> values) {
        Laptop laptop = null;
        if(values != null && !values.isEmpty()) {
             laptop = new Laptop();
            laptop.setBatteryCapacity(Double.valueOf(values.get(BATTERY_CAPACITY)));
            laptop.setOs(values.get(OS));
            laptop.setMemoryRom(Integer.valueOf(values.get(MEMORY_ROM)));
            laptop.setSystemMemory(Integer.valueOf(values.get(SYSTEM_MEMORY)));
            laptop.setCpu(Double.valueOf(values.get(CPU)));
            laptop.setDisplayInches(Integer.valueOf(values.get(DISPLAY_INCHS)));
        }
        return laptop;
    }


}
