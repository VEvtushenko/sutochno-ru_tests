package ru.sutochno.base.domain.adverticement.equipment;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Equipment {
    private final Map<String, Boolean> childrenEquipment;
    private final Map<String, Boolean> houseEquipment;
    private final Map<String, Boolean> kitchenEquipment;
    private final Map<String, Boolean> restEquipment;
    private final Map<String, Boolean> yardEquipment;
    private final Map<String, Boolean> homeFacilities;

    public Equipment(Faker faker) {
        Map<String, Boolean> childrenEquipment = new HashMap<>();
        for(ChildrenEquipment equipmentUnit : ChildrenEquipment.values()) {
            childrenEquipment.put(equipmentUnit.getName(), faker.random().nextBoolean());
        }
        this.childrenEquipment = childrenEquipment;

        Map<String, Boolean> houseEquipments = new HashMap<>();
        for(HouseEquipment equipmentUnit : HouseEquipment.values()) {
            houseEquipments.put(equipmentUnit.getName(), faker.random().nextBoolean());
        }
        this.houseEquipment = houseEquipments;

        Map<String, Boolean> kitchenEquipment = new HashMap<>();
        for(KitchenEquipment equipmentUnit : KitchenEquipment.values()) {
            kitchenEquipment.put(equipmentUnit.getName(), faker.random().nextBoolean());
        }
        this.kitchenEquipment = kitchenEquipment;

        Map<String, Boolean> restEquipment = new HashMap<>();
        for(RestEquipment equipmentUnit : RestEquipment.values()) {
            restEquipment.put(equipmentUnit.getName(), faker.random().nextBoolean());
        }
        this.restEquipment = restEquipment;

        Map<String, Boolean> yardEquipment = new HashMap<>();
        for(YardEquipment equipmentUnit : YardEquipment.values()) {
            yardEquipment.put(equipmentUnit.getName(), faker.random().nextBoolean());
        }
        this.yardEquipment = yardEquipment;

        Map<String, Boolean> homeFacilities = new HashMap<>();
        for(HomeFacilities equipmentUnit : HomeFacilities.values()) {
            homeFacilities.put(equipmentUnit.getName(), faker.random().nextBoolean());
        }
        this.homeFacilities = homeFacilities;

    }

    public Map<String, Boolean> getChildrenEquipment() {
        return childrenEquipment;
    }

    public Map<String, Boolean> getHouseEquipment() {
        return houseEquipment;
    }

    public Map<String, Boolean> getKitchenEquipment() {
        return kitchenEquipment;
    }

    public Map<String, Boolean> getRestEquipment() {
        return restEquipment;
    }

    public Map<String, Boolean> getYardEquipment() {
        return yardEquipment;
    }

    public Map<String, Boolean> getHomeFacilities() {
        return homeFacilities;
    }
}
