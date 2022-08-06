package ru.sutochno.base.domain.booking;

import java.util.Random;

public class PlacementTerm {

    private final ChildrenTerm children;
    private final Integer childrenAge;
    private final SmokingTerm smoking;
    private final PetsTerm pets;
    private final PartyTerm party;

    public PlacementTerm(Random random) {
        this.pets = PetsTerm.getPetsTermMap().get(random.nextInt(PetsTerm.getPetsTermMap().size()));
    }
}
