package ru.sutochno.base.domain.booking.placementTerm;

import java.util.HashMap;
import java.util.Map;

public enum PartyTerm {

    REQUEST(2, "вечеринки и мероприятия по согласованию с хозяином жилья", false),
    ALLOWED(1, "можно проводить вечеринки и мероприятия", true),
    FORBIDDEN(0, "без вечеринок и мероприятий", false);

    private final String name;
    private final Integer value;
    private final boolean switchValue;
    private static final Map<Integer, PartyTerm> partyTermMap = new HashMap<Integer, PartyTerm>();

    PartyTerm(Integer value, String name, boolean switchValue) {
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
        for (PartyTerm partyTerm : PartyTerm.values()) {
            partyTermMap.put(i, partyTerm);
            i++;
        }
    }

    public boolean isSwitchValue() {
        return switchValue;
    }

    public static Map<Integer, PartyTerm> getPartyTermMap() {
        return partyTermMap;
    }

}
