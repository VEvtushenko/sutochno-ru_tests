package ru.sutochno.base.domain.booking;

import java.util.HashMap;
import java.util.Map;

public enum ChildrenTerm {

    REQUEST(2, "можно с детьми по согласованию с хозяином жилья"),
    ALLOWED(1, "можно с детьми"),
    FORBIDDEN(0, "запрещено");

    private final String name;
    private final Integer value;
    private static final Map<Integer, ChildrenTerm> childrenTermMap = new HashMap<Integer, ChildrenTerm>();

    ChildrenTerm(Integer value, String name) {
        this.value = value;
        this.name = name;
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

    public static Map<Integer, ChildrenTerm> geChildrenTermMap() {
        return childrenTermMap;
    }

}
