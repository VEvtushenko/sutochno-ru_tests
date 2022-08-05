package ru.sutochno.base.domain;


public enum Currencies {
    RUB("RUB - Российский рубль", "₽", 1),
    USD("USD - Доллар США", "$", 2),
    EUR("EUR - Евро", "€", 3),
    UAH("UAH - Украинская гривна", "₴", 4),
    KZT("KZT - Казахский тенге", "₸", 5),
    BYN("BYN - Белорусский рубль", "Br", 7),
    AZN("AZN - Азербайджанский манат", "AZN", 8),
    BGN("BGN - Болгарский лев", "лв", 9);

    private final String name;
    private final String symbol;
    private final Integer value;

    Currencies(String name, String symbol, Integer value) {
        this.name = name;
        this.symbol = symbol;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getValue() {
        return value;
    }
}
