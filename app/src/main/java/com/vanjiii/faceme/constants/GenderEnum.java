package com.vanjiii.faceme.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains all the different genders.
 *
 * Created by vanjiii on 4/10/16.
 */
public enum GenderEnum {
    //TODO: Add more genders if needed.
    MALE("male"), FEMALE("female"), OTHER("other");

    private String value;

    private static Map<String, GenderEnum> genderMap;
    static {
        genderMap = new HashMap<>();
        for(GenderEnum value : values()) {
            genderMap.put(value.getValue(), value);
        }
    }

    private GenderEnum(String value) {
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
}
