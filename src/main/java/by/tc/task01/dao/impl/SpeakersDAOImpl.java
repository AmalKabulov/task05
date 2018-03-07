package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.impl.dataeditor.DataEditor;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.impl.searcher.SearcherDao;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class SpeakersDAOImpl implements ApplianceDAO {

    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String NUMBER_OF_SPEAKERS = "NUMBER_OF_SPEAKERS";
    private static final String FREQUENCY_RANGE = "FREQUENCY_RANGE";
    private static final String CORD_LENGTH = "CORD_LENGTH";


    private static SpeakersDAOImpl instance;

    public SpeakersDAOImpl() {
    }

    public static SpeakersDAOImpl getInstance() {

        if (instance == null) {
            synchronized (SpeakersDAOImpl.class) {
                if (instance == null) {
                    instance = new SpeakersDAOImpl();
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
            return initializedSpeakers(validData);
        } else {
            throw new DAOException("ENTITY NOT FOUND");
        }
    }

    private Appliance initializedSpeakers(Map<String, String> values) {
        Speakers speakers = null;
        if (values != null && !values.isEmpty()) {
            speakers = new Speakers();
            speakers.setPowerConsumption(Integer.valueOf(values.get(POWER_CONSUMPTION)));
            speakers.setNumberOfSpeakers(Integer.valueOf(values.get(NUMBER_OF_SPEAKERS)));
            speakers.setFrequencyRange(values.get(FREQUENCY_RANGE));
            speakers.setCordLength(values.get(CORD_LENGTH));
        }
        return speakers;

    }
}
