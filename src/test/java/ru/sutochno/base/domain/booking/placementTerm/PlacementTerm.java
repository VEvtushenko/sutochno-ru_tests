package ru.sutochno.base.domain.booking.placementTerm;

import java.util.Random;

public class PlacementTerm {

    private final ChildrenTerm children;
    private final Integer childrenAge;
    private final SmokingTerm smoking;
    private final PetsTerm pets;
    private final PartyTerm party;

    public PlacementTerm(Random random) {
        this.pets = PetsTerm.getPetsTermMap().get(random.nextInt(PetsTerm.getPetsTermMap().size()));
        this.children = ChildrenTerm.getChildrenTermMap().get(random.nextInt(ChildrenTerm.getChildrenTermMap().size()));
        this.party = PartyTerm.getPartyTermMap().get(random.nextInt(PartyTerm.getPartyTermMap().size()));
        this.smoking = SmokingTerm.getSmokingTermMap().get(random.nextInt(SmokingTerm.getSmokingTermMap().size()));
        this.childrenAge = random.nextInt(17);
    }

    public PlacementTerm(ChildrenTerm children, Integer childrenAge, SmokingTerm smoking, PetsTerm pets, PartyTerm party) {
        this.childrenAge = childrenAge;
        this.smoking = smoking;
        this.pets = pets;
        this.children = children;
        this.party = party;
    }
}
