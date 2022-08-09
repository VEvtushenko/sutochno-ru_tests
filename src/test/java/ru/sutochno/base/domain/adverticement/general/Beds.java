package ru.sutochno.base.domain.adverticement.general;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Beds {

    private final Map<String, Integer> bedsList = new HashMap<>();
    private Integer numberOfBeds;
    private final Integer maxGuests;

    public Beds() {
        bedsList.put("Односпальных кроватей", 1);
        this.numberOfBeds = 1;
        this.maxGuests = 1;
    }

    public  Beds(Integer singleBed, Integer doubleBed, Integer kingBed, Integer superKingBed, Integer yarusBed, Integer bsofaBed) {
        this.bedsList.put("Односпальных кроватей", singleBed);
        this.bedsList.put("Двуспальных кроватей", doubleBed);
        this.bedsList.put("Кроватей king-size", kingBed);
        this.bedsList.put("Особо широких двуспальных", superKingBed);
        this.bedsList.put("Двухъярусных кроватей", yarusBed);
        this.bedsList.put("Диван-кроватей", bsofaBed);

        for (Integer value : this.bedsList.values()) {
            this.numberOfBeds = this.numberOfBeds + value;
        }

        Integer maxGuests = 0;
        for (Integer value : this.bedsList.values()) {
            maxGuests = maxGuests + value*2;
        }
        this.maxGuests = maxGuests - this.bedsList.get("Односпальных кроватей");
    }

    public  Beds(Faker faker) {
        this.bedsList.put("Односпальных кроватей", faker.random().nextInt(1, 9));
        this.bedsList.put("Двуспальных кроватей", faker.random().nextInt(1, 9));
        this.bedsList.put("Кроватей king-size", faker.random().nextInt(1, 9));
        this.bedsList.put("Особо широких двуспальных", faker.random().nextInt(1, 9));
        this.bedsList.put("Двухъярусных кроватей", faker.random().nextInt(1, 9));
        this.bedsList.put("Диван-кроватей", faker.random().nextInt(1, 9));

        Integer numberOfBeds = 0;
        for (Integer value : this.bedsList.values()) {
            numberOfBeds = numberOfBeds + value;
        }
        this.numberOfBeds = numberOfBeds;

        Integer maxGuests = 0;
        for (Integer value : this.bedsList.values()) {
            maxGuests = maxGuests + value*2;
        }
        this.maxGuests = maxGuests - this.bedsList.get("Односпальных кроватей");
    }

    public Integer getSingleBed() {
        return this.bedsList.get("Односпальных кроватей");
    }

    public Integer getDoubleBed() {
        return this.bedsList.get("Двуспальных кроватей");
    }

    public Integer getKingBed() {
        return this.bedsList.get("Кроватей king-size");
    }

    public Integer getSuperKingBed() {
        return this.bedsList.get("Особо широких двуспальных");
    }

    public Integer getYarusBed() {
        return this.bedsList.get("Двухъярусных кроватей");
    }

    public Integer getSofaBed() {
        return this.bedsList.get("Диван-кроватей");
    }

    public Integer getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public Map<String, Integer> getBedsList() {
        return bedsList;
    }

    public String bedsNumDesc() {
        if (this.numberOfBeds == 1) {
            return format("%s кровать", this.numberOfBeds);
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s кровати", this.numberOfBeds);
            } else {
                return format("%s кроватей", this.numberOfBeds);
            }
        }
    }

    public String singleBedsDesc() {
        if (this.bedsList.get("Односпальных кроватей") == 1) {
            return format("%s односпальная кровать", this.bedsList.get("Односпальных кроватей"));
        } else {
            if (this.bedsList.get("Односпальных кроватей") < 5) {
                return format("%s односпальных кровати", this.bedsList.get("Односпальных кроватей"));
            } else {
                return format("%s односпальных кроватей", this.bedsList.get("Односпальных кроватей"));
            }
        }
    }

    public String doubleBedsDesc() {
        if (this.bedsList.get("Двуспальных кроватей") == 1) {
            return format("%s двуспальные кровать", this.bedsList.get("Двуспальных кроватей"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s двуспальных кровати", this.bedsList.get("Двуспальных кроватей"));
            } else {
                return format("%s двуспальных кроватей", this.bedsList.get("Двуспальных кроватей"));
            }
        }
    }

    public String kingBedsDesc() {
        if (this.bedsList.get("Кроватей king-size") == 1) {
            return format("%s кровать king-size", this.bedsList.get("Кроватей king-size"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s кровати king-size", this.bedsList.get("Кроватей king-size"));
            } else {
                return format("%s кроватей king-size", this.bedsList.get("Кроватей king-size"));
            }
        }
    }

    public String superKingBedsDesc() {
        if (this.bedsList.get("Особо широких двуспальных") == 1) {
            return format("%s особо широкая двуспальная кровать", this.bedsList.get("Особо широких двуспальных"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s особо широкие двуспальные кровати", this.bedsList.get("Особо широких двуспальных"));
            } else {
                return format("%s особо широких двуспальных кроватей", this.bedsList.get("Особо широких двуспальных"));
            }
        }
    }

    public String yarusBedsDesc() {
        if (this.bedsList.get("Двухъярусных кроватей") == 1) {
            return format("%s двухъярусная кровать", this.bedsList.get("Двухъярусных кроватей"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s двухъярусных кровати", this.bedsList.get("Двухъярусных кроватей"));
            } else {
                return format("%s двухъярусных кроватей", this.bedsList.get("Двухъярусных кроватей"));
            }
        }
    }

    public String sofaBedsDesc() {
        if (this.bedsList.get("Диван-кроватей") == 1) {
            return format("%s диван-кровать", this.bedsList.get("Диван-кроватей"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s диван-кровати", this.bedsList.get("Диван-кроватей"));
            } else {
                return format("%s диван-кроватей", this.bedsList.get("Диван-кроватей"));
            }
        }
    }

    public String generalBedsDesc() {
        String desc = "";
        Integer countBeds = this.numberOfBeds;
        if (this.bedsList.get("Односпальных кроватей") != 0) {
            desc = desc + singleBedsDesc();
            countBeds = countBeds - this.bedsList.get("Односпальных кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.bedsList.get("Двуспальных кроватей") != 0) {
            desc = desc + doubleBedsDesc();
            countBeds = countBeds - this.bedsList.get("Двуспальных кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.bedsList.get("Кроватей king-size") != 0) {
            desc = desc + kingBedsDesc();
            countBeds = countBeds - this.bedsList.get("Кроватей king-size");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.bedsList.get("Особо широких двуспальных") != 0) {
            desc = desc + superKingBedsDesc();
            countBeds = countBeds - this.bedsList.get("Особо широких двуспальных");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.bedsList.get("Двухъярусных кроватей") != 0) {
            desc = desc + yarusBedsDesc();
            countBeds = countBeds - this.bedsList.get("Двухъярусных кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.bedsList.get("Диван-кроватей") != 0) {
            desc = desc + sofaBedsDesc();
            countBeds = countBeds - this.bedsList.get("Диван-кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        return desc;
    }
}
