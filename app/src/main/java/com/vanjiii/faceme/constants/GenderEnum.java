package com.vanjiii.faceme.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains all the different genders.
 * <p/>
 * Created by vanjiii on 4/10/16.
 */
public enum GenderEnum {
    //TODO: Add more genders if needed.
    MALE("male"), FEMALE("female"), OTHER("other");

    private String value;

    private static Map<String, GenderEnum> genderMap;

    static {
        genderMap = new HashMap<>();
        for (GenderEnum value : values()) {
            genderMap.put(value.getValue(), value);
        }
    }

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isGenderOf(String sex) {
        if (sex == null) {
            return false;
        }
        return value.equals(sex);
    }

    public static GenderEnum getGenderForValue(String value) {
        return genderMap.get(value);
    }

    public static int getIndex(GenderEnum sex) {
        int index = 0;
        for (GenderEnum value : values()) {
            if (value.equals(sex)) {
                break;
            }
            index++;
        }
        return index;
    }

    public static List<String> getAllGenders() {
        List<String> result = new ArrayList<>();

        for (GenderEnum value : values()) {
            result.add(value.getValue());
        }
        return result;
    }
}
