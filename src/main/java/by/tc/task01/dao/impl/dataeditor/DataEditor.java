package by.tc.task01.dao.impl.dataeditor;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataEditor {

    public static final String GET_NAME_OF_ENTITY_FIELD_CONDITION = "\\w+";
    public static final String GET_VALUE_OF_ENTITY_FIELD_WITH_EQUAL_SIGN_CONDITION = "=([A-Za-z0-9\\-]+|\\d+\\.\\d|\\d+)";
    public static final String GET_VALUE_OF_ENTITY_FIELD_WTHOUT_EQUAL_SIGN_CONDITION = "[A-Za-z0-9\\-]+|\\d+\\.\\d|\\d+";

    private static DataEditor instance;

    public DataEditor() {
    }

    public static DataEditor getInstance() {

        if (instance == null) {
            synchronized (DataEditor.class) {
                if (instance == null) {
                    instance = new DataEditor();
                }
            }
        }
        return instance;
    }

    public Map<String, String> getValidData(String[] lines) {
        Map<String, String> datas = new HashMap<>();
        if (lines != null) {
            for (String line : lines) {
                String key = checkByCondition(line, GET_NAME_OF_ENTITY_FIELD_CONDITION);
                String incorrectVal = checkByCondition(line, GET_VALUE_OF_ENTITY_FIELD_WITH_EQUAL_SIGN_CONDITION);
                    if (incorrectVal != null) {
                        String correctVal = checkByCondition(incorrectVal, GET_VALUE_OF_ENTITY_FIELD_WTHOUT_EQUAL_SIGN_CONDITION);
                        if (correctVal != null) {
                            datas.put(key, correctVal);
                        }
                    }
            }
        }
        return datas;
    }

    private String checkByCondition(String line, String condition) {
        Pattern pattern = Pattern.compile(condition);
        Matcher matcher = pattern.matcher(line);
        return matcher.find() ? matcher.group() : null;
    }

}
