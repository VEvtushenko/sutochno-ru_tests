package ru.sutochno.base.domain.booking;

import java.util.HashMap;
import java.util.Map;

public enum PartyTerm {

    REQUEST(2, "вечеринки и мероприятия по согласованию с хозяином жилья"),
    ALLOWED(1, "можно проводить вечеринки и мероприятия"),
    FORBIDDEN(0, "запрещено");

    private final String name;
    private final Integer value;
    private static final Map<Integer, PartyTerm> partyTermMap = new HashMap<Integer, PartyTerm>();

    PartyTerm(Integer value, String name) {
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
        for (PartyTerm partyTerm : PartyTerm.values()) {
            partyTermMap.put(i, partyTerm);
            i++;
        }
    }

    public static Map<Integer, PartyTerm> gePartyTermMap() {
        return partyTermMap;
    }

}
