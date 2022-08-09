package ru.sutochno.base.domain.booking.placementTerm;

import com.github.javafaker.Faker;
import ru.sutochno.base.domain.adverticement.address.StreetType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlacementTerm {

    private final ChildrenTerm children;
    private final Integer childrenAge;
    private final SmokingTerm smoking;
    private final PetsTerm pets;
    private final PartyTerm party;

    public PlacementTerm(Faker faker) {

        List<PetsTerm> petsTermList = new ArrayList<>();
        Collections.addAll(petsTermList, PetsTerm.values());
        this.pets = petsTermList.get(faker.random().nextInt(petsTermList.size()));

        List<ChildrenTerm> childrenTermList = new ArrayList<>();
        Collections.addAll(childrenTermList, ChildrenTerm.values());
        this.children = childrenTermList.get(faker.random().nextInt(childrenTermList.size()));

        List<PartyTerm> partyTermList = new ArrayList<>();
        Collections.addAll(partyTermList, PartyTerm.values());
        this.party = partyTermList.get(faker.random().nextInt(partyTermList.size()));

        List<SmokingTerm> smokingTermList = new ArrayList<>();
        Collections.addAll(smokingTermList, SmokingTerm.values());
        this.smoking = smokingTermList.get(faker.random().nextInt(smokingTermList.size()));

        this.childrenAge = faker.random().nextInt(17);
    }

    public PlacementTerm(ChildrenTerm children, Integer childrenAge, SmokingTerm smoking, PetsTerm pets, PartyTerm party) {
        this.childrenAge = childrenAge;
        this.smoking = smoking;
        this.pets = pets;
        this.children = children;
        this.party = party;
    }

    public ChildrenTerm getChildren() {
        return children;
    }

    public Integer getChildrenAge() {
        return childrenAge;
    }

    public SmokingTerm getSmoking() {
        return smoking;
    }

    public PetsTerm getPets() {
        return pets;
    }

    public PartyTerm getParty() {
        return party;
    }
}
