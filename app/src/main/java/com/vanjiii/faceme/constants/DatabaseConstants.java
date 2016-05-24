package com.vanjiii.faceme.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vanjiii on 5/23/16.
 */
public enum DatabaseConstants {

    SENT(1, true), NOT_SENT(0, false);

    private Integer valueInt;
    private Boolean valueBool;

    private static Map<Integer, DatabaseConstants> intValueMap;
    private static Map<Boolean, DatabaseConstants> boolValueMap;

    static {
        intValueMap = new HashMap<Integer, DatabaseConstants>();
        boolValueMap = new HashMap<Boolean, DatabaseConstants>();

        for (DatabaseConstants value : values()) {
            intValueMap.put(value.getValueInt(), value);
            boolValueMap.put(value.getValueBool(), value);
        }
    }

    DatabaseConstants(int valueInt, boolean valueBool) {
        this.valueInt = valueInt;
        this.valueBool = valueBool;
    }

    public int getValueInt () {
        return this.valueInt;
    }

    public boolean getValueBool() {
        return this.valueBool;
    }

    public static DatabaseConstants getStateForValue(int value) {
        return intValueMap.get(value);
    }

    public static DatabaseConstants getStateForValue(boolean value) {
        return boolValueMap.get(value);
    }

}
