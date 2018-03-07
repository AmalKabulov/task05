package by.tc.task01.dao.impl.searcher;

import by.tc.task01.dao.constanct.Constant;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearcherDao {
    public static final String APPLIANCES_DB_TXT = "/appliances_db.txt";


    private static SearcherDao instance;

    public SearcherDao() {
    }

    public static SearcherDao getInstance() {

        if (instance == null) {
            synchronized (SearcherDao.class) {
                if (instance == null) {
                    instance = new SearcherDao();
                }
            }
        }
        return instance;
    }

    public <E> String findByCriteria(Criteria<E> criteria) throws DAOException {
        String result = null;
        String entityName = getEntityNameByCriteria(criteria);
        String[] split = getCriteriaCondition(criteria).split(Constant.SEMICOLON);
        for (String line : getAllLinesByEntity(entityName)) {
            for (String s : split) {
                if (line.contains(s)) {
                    result = line;
                } else {
                    result = null;
                    break;
                }
            }
            if (result != null) {
                return result;
            }
        }
        return result;
    }


    private <E> String getCriteriaCondition(Criteria<E> criteria) {
        StringBuilder condition = new StringBuilder();
        criteria.getCriteria().forEach((k, v) -> {
            condition.append(k.toString()).append(Constant.EQUAL_SIGN).append(v).append(Constant.SEMICOLON);
        });
        return condition.toString();
    }

    private <E> List<String> getAllLinesByEntity(String entityName) throws DAOException {
        return getAllLines().stream().filter(line -> line.contains(entityName)).collect(Collectors.toList());
    }

    private List<String> getAllLines() throws DAOException {
        List<String> all = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(APPLIANCES_DB_TXT);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                all.add(getCorrectLine(currentLine));
            }
        } catch (IOException e) {
           throw new DAOException("EXCEPTION WHILE READING FILE " + e);
        }
        return all;
    }

    private String getCorrectLine(String line) {
        if (!line.isEmpty()) {

            String replaceLine = line.replace(Constant.COMMA, Constant.SEMICOLON);
            String trimmedLine = line.trim();
            boolean correct = trimmedLine.endsWith(Constant.SEMICOLON);
            if (!correct) {
                return new StringBuilder(trimmedLine).append(Constant.SEMICOLON).toString();
            }
            return replaceLine;
        }
        return line;
    }

    private <E> String getEntityNameByCriteria(Criteria<E> criteria) {
        return criteria.getCriteria().keySet().stream().findFirst().get().getClass().getSimpleName();
    }
}
