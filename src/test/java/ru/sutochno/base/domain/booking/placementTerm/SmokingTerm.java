package ru.sutochno.base.domain.booking.placementTerm;

import java.util.HashMap;
import java.util.Map;

public enum SmokingTerm {

    IN_PLACES(3, "курение разрешено в специально отведенных местах", false),
    ALLOWED(1, "курение разрешено", true),
    FORBIDDEN(0, "курение запрещено", false);

    private final String name;
    private final Integer value;
    private final boolean switchValue;
    private static final Map<Integer, SmokingTerm> smokingTermMap = new HashMap<Integer, SmokingTerm>();

    SmokingTerm(Integer value, String name, boolean switchValue) {
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
        for (SmokingTerm smokingTerm : SmokingTerm.values()) {
            smokingTermMap.put(i, smokingTerm);
            i++;
        }
    }

    public boolean isSwitchValue() {
        return switchValue;
    }

    public static Map<Integer, SmokingTerm> getSmokingTermMap() {
        return smokingTermMap;
    }
    
}
