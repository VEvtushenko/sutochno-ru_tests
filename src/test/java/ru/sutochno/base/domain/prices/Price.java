package ru.sutochno.base.domain.prices;

public class Price {

    private final String price;
    private final Currencies currency;
    private final String gethering;
    private final String deposit;

    public Price(String  price, Currencies  currency, String gethering, String deposit) {
        this.price = price;
        this.currency = currency;
        this.gethering = gethering;
        this.deposit = deposit;
    }

    public String getPrice() {
        return price;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public String getGethering() {
        return gethering;
    }

    public String getDeposit() {
        return deposit;
    }
}
