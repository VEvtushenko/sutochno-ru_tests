package ru.sutochno.base.domain.adverticement;

import com.github.javafaker.Faker;

import java.util.Random;

public class Transfer {

    private final boolean transfer;
    private final String transferTerm;

    public Transfer(Random random, String transferTerm) {
        this.transfer = random.nextBoolean();
        this.transferTerm = transferTerm;
    }

    public Transfer(Random random, Faker faker) {
        this.transfer = random.nextBoolean();
        this.transferTerm = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
    }

}
