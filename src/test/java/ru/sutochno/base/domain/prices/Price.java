package ru.sutochno.base.domain.prices;

import com.github.javafaker.Faker;

public class Price {

    private final Integer price;
    private final Currencies currency;
    private final Integer gethering;
    private final Integer deposit;

    public Price(Faker faker, Currencies currency) {
        this.price = faker.random().nextInt(5000, 50000);
        this.currency = currency;
        this.gethering = faker.random().nextInt(10, 1000);
        this.deposit = faker.random().nextInt(5000, 50000);;
    }

    public Price(Integer  price, Currencies  currency, Integer gethering, Integer deposit) {
        this.price = price;
        this.currency = currency;
        this.gethering = gethering;
        this.deposit = deposit;
    }

    public Integer getPrice() {
        return price;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public Integer getGethering() {
        return gethering;
    }

    public Integer getDeposit() {
        return deposit;
    }
}
