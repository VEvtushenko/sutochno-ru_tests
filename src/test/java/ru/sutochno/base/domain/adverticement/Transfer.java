package ru.sutochno.base.domain.adverticement;

import com.github.javafaker.Faker;

public class Transfer {

    private final boolean transfer;
    private final String transferTerm;

    public Transfer(Faker faker, String transferTerm) {
        this.transfer = faker.random().nextBoolean();
        this.transferTerm = transferTerm;
    }

    public Transfer(Faker faker) {
        this.transfer = faker.random().nextBoolean();
        this.transferTerm = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
    }

    public boolean isTransfer() {
        return transfer;
    }

    public String getTransferTerm() {
        return transferTerm;
    }
}
