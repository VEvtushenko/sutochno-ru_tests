package ru.sutochno.base.domain.booking.placementTerm;

import java.util.HashMap;
import java.util.Map;

public enum ChildrenTerm {

    REQUEST(2, "можно с детьми по согласованию с хозяином жилья", false),
    ALLOWED(1, "можно с детьми", true),
    FORBIDDEN(0, "нельзя с детьми", false);

    private final String name;
    private final Integer value;
    private final boolean switchValue;
    private static final Map<Integer, ChildrenTerm> childrenTermMap = new HashMap<Integer, ChildrenTerm>();

    ChildrenTerm(Integer value, String name, boolean switchValue) {
        this.value = value;
        this.name = name;
        this.switchValue = switchValue;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    static {
        int i = 0;
        for (ChildrenTerm childrenTerm : ChildrenTerm.values()) {
            childrenTermMap.put(i, childrenTerm);
            i++;
        }
    }

    public boolean isSwitchValue() {
        return switchValue;
    }

    public static Map<Integer, ChildrenTerm> getChildrenTermMap() {
        return childrenTermMap;
    }

}
