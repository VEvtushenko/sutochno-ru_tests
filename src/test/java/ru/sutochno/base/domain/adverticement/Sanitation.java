package ru.sutochno.base.domain.adverticement;

import ru.sutochno.base.domain.adverticement.equipment.BathroomEquipment;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Sanitation {

    private final Integer cntBathroomsToilet;
    private final Integer cntBathrooms;
    private final Integer cntToilets;
    private final Map<String, Boolean> bathroomEquipments;

    public Sanitation(Random random) {
        this.cntBathroomsToilet = random.nextInt(2);
        this.cntBathrooms = random.nextInt(2);
        this.cntToilets = random.nextInt(2);

        Map<String, Boolean> bathroomEquipments = new HashMap<>();
        for(BathroomEquipment i : BathroomEquipment.values()) {
            bathroomEquipments.put(i.getName(), random.nextBoolean());
        }
        this.bathroomEquipments = bathroomEquipments;
    }

    public Sanitation(Integer cntBathroomsToilet, Integer cntBathrooms, Integer cntToilets, Random random) {
        this.cntBathroomsToilet = cntBathroomsToilet;
        this.cntBathrooms = cntBathrooms;
        this.cntToilets = cntToilets;

        Map<String, Boolean> bathroomEquipments = new HashMap<>();
        for(BathroomEquipment i : BathroomEquipment.values()) {
            bathroomEquipments.put(i.getName(), random.nextBoolean());
        }
        this.bathroomEquipments = bathroomEquipments;
    }

    public Sanitation(Integer cntBathroomsToilet, Integer cntBathrooms, Integer cntToilets, HashMap<String, Boolean> bathroomEquipments) {
        this.cntBathroomsToilet = cntBathroomsToilet;
        this.cntBathrooms = cntBathrooms;
        this.cntToilets = cntToilets;
        this.bathroomEquipments = bathroomEquipments;
    }


    public Integer getCntBathroomsToilet() {
        return cntBathroomsToilet;
    }

    public Integer getCntBathrooms() {
        return cntBathrooms;
    }

    public Integer getCntToilets() {
        return cntToilets;
    }

    public Map<String, Boolean> getBathroomEquipments() {
        return bathroomEquipments;
    }
}
