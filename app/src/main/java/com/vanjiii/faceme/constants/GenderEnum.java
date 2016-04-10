package com.vanjiii.faceme.constants;

/**
 * Contains all the different genders.
 *
 * Created by vanjiii on 4/10/16.
 */
public enum GenderEnum {
    MALE("male"), FEMALE("female"), OTHER("other");

    private String value;

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
}
