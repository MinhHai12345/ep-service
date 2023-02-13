package com.hai.minh.epservice.utils;

import com.hai.minh.epservice.commons.constants.EPConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Slf4j
public class EPFilterUtils<T> {
    public String findFieldName(T data, String value) throws IllegalAccessException {
        Field[] fld = data.getClass().getDeclaredFields();
        for (Field f : fld) {
            ReflectionUtils.makeAccessible(f);
            if (value.equals(f.get(data)) && f.get(data) != null) {
                log.info(f.getName() + " : " + f.get(data));
                return f.getName();
            }
        }
        return "EMPTY";
    }

    public String buildFilter(String fieldName, String value, String operators) {
        if (StringUtils.isEmpty(operators)) {
            if (fieldName.equals(EPConstants.DESCRIPTION)) {
                operators = EPConstants.LIKE;
            } else {
                operators = EPConstants.EQ;
            }
        }
        String condition = "(%s, %s)";
        return operators + String.format(condition, replaceFieldName(fieldName), value);
    }

    private String replaceFieldName(String fieldName) {
        if (fieldName.equals("manageStock")) {
            return "manage_stock";
        }
        if (fieldName.equals("commodityType")) {
            return "commodity_type";
        }
        return fieldName;
    }
}