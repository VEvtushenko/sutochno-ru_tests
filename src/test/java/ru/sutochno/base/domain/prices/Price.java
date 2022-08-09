package ru.sutochno.base.domain.prices;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Price {

    private final Integer price;
    private final Currencies currency;
    private final Integer gethering;
    private final Integer deposit;
    private final Integer exGuestPrice;

    public Price(Faker faker) {
        this.price = faker.random().nextInt(5000, 50000);
        this.gethering = faker.random().nextInt(10, 1000);
        this.deposit = faker.random().nextInt(5000, 50000);
        this.exGuestPrice = faker.random().nextInt(price/2);
        List<Currencies> currenciesList = new ArrayList<>();
        Collections.addAll(currenciesList, Currencies.values());
        this.currency = currenciesList.get(faker.random().nextInt(currenciesList.size()));
    }

    public Price(Faker faker, Currencies currency) {
        this.price = faker.random().nextInt(5000, 50000);
        this.currency = currency;
        this.gethering = faker.random().nextInt(10, 1000);
        this.deposit = faker.random().nextInt(5000, 50000);
        this.exGuestPrice = faker.random().nextInt(price/2);
    }

    public Price(Integer  price, Currencies  currency, Integer gethering, Integer deposit) {
        this.price = price;
        this.currency = currency;
        this.gethering = gethering;
        this.deposit = deposit;
        this.exGuestPrice = price/2;
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

    public Integer getExGuestPrice() {
        return exGuestPrice;
    }
}
