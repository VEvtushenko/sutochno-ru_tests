package ru.sutochno.base.domain.adverticement.general;

import ru.sutochno.pages.MainPage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.String.format;

public class Beds {

    private Map<String, Integer> beds = new HashMap<>();
    private Integer numberOfBeds;
    private Integer maxGuests;

    public Beds() {
        beds.put("Односпальных кроватей", 1);
        this.numberOfBeds = 1;
        this.maxGuests = 1;
    }

    public  Beds(Integer singleBed, Integer doubleBed, Integer kingBed, Integer superKingBed, Integer yarusBed, Integer bsofaBed) {
        this.beds.put("Односпальных кроватей", singleBed);
        this.beds.put("Двуспальных кроватей", doubleBed);
        this.beds.put("Кроватей king-size", kingBed);
        this.beds.put("Особо широких двуспальных", superKingBed);
        this.beds.put("Двухъярусных кроватей", yarusBed);
        this.beds.put("Диван-кроватей", bsofaBed);

        for (Integer value : this.beds.values()) {
            this.numberOfBeds = this.numberOfBeds + value;
        }

        Integer maxGuests = 0;
        for (Integer value : this.beds.values()) {
            maxGuests = maxGuests + value*2;
        }
        this.maxGuests = maxGuests - this.beds.get("Односпальных кроватей");
    }

    public  Beds(Random random) {
        this.beds.put("Односпальных кроватей", random.nextInt(5));
        this.beds.put("Двуспальных кроватей", random.nextInt(5));
        this.beds.put("Кроватей king-size", random.nextInt(5));
        this.beds.put("Особо широких двуспальных", random.nextInt(5));
        this.beds.put("Двухъярусных кроватей", random.nextInt(5));
        this.beds.put("Диван-кроватей", random.nextInt(5));

        for (Integer value : this.beds.values()) {
            this.numberOfBeds = this.numberOfBeds + value;
        }

        Integer maxGuests = 0;
        for (Integer value : this.beds.values()) {
            maxGuests = maxGuests + value*2;
        }
        this.maxGuests = maxGuests - this.beds.get("Односпальных кроватей");
    }

    public Integer getSingleBed() {
        return this.beds.get("Односпальных кроватей");
    }

    public Integer getDoubleBed() {
        return this.beds.get("Двуспальных кроватей");
    }

    public Integer getKingBed() {
        return this.beds.get("Кроватей king-size");
    }

    public Integer getSuperKingBed() {
        return this.beds.get("Особо широких двуспальных");
    }

    public Integer getYarusBed() {
        return this.beds.get("Двухъярусных кроватей");
    }

    public Integer getSofaBed() {
        return this.beds.get("Диван-кроватей");
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public Integer getMaxGuests() {
        return maxGuests;
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
        if (this.beds.get("Односпальных кроватей") == 1) {
            return format("%s односпальная кровать", this.beds.get("Односпальных кроватей"));
        } else {
            if (this.beds.get("Односпальных кроватей") < 5) {
                return format("%s односпальных кровати", this.beds.get("Односпальных кроватей"));
            } else {
                return format("%s односпальных кроватей", this.beds.get("Односпальных кроватей"));
            }
        }
    }

    public String doubleBedsDesc() {
        if (this.beds.get("Двуспальных кроватей") == 1) {
            return format("%s двуспальные кровать", this.beds.get("Двуспальных кроватей"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s двуспальных кровати", this.beds.get("Двуспальных кроватей"));
            } else {
                return format("%s двуспальных кроватей", this.beds.get("Двуспальных кроватей"));
            }
        }
    }

    public String kingBedsDesc() {
        if (this.beds.get("Кроватей king-size") == 1) {
            return format("%s кровать king-size", this.beds.get("Кроватей king-size"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s кровати king-size", this.beds.get("Кроватей king-size"));
            } else {
                return format("%s кроватей king-size", this.beds.get("Кроватей king-size"));
            }
        }
    }

    public String superKingBedsDesc() {
        if (this.beds.get("Особо широких двуспальных") == 1) {
            return format("%s особо широкая двуспальная кровать", this.beds.get("Особо широких двуспальных"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s особо широкие двуспальные кровати", this.beds.get("Особо широких двуспальных"));
            } else {
                return format("%s особо широких двуспальных кроватей", this.beds.get("Особо широких двуспальных"));
            }
        }
    }

    public String yarusBedsDesc() {
        if (this.beds.get("Двухъярусных кроватей") == 1) {
            return format("%s двухъярусная кровать", this.beds.get("Двухъярусных кроватей"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s двухъярусных кровати", this.beds.get("Двухъярусных кроватей"));
            } else {
                return format("%s двухъярусных кроватей", this.beds.get("Двухъярусных кроватей"));
            }
        }
    }

    public String sofaBedsDesc() {
        if (this.beds.get("Диван-кроватей") == 1) {
            return format("%s диван-кровать", this.beds.get("Диван-кроватей"));
        } else {
            if (this.numberOfBeds < 5) {
                return format("%s диван-кровати", this.beds.get("Диван-кроватей"));
            } else {
                return format("%s диван-кроватей", this.beds.get("Диван-кроватей"));
            }
        }
    }

    public String generalBedsDesc() {
        String desc = "";
        Integer countBeds = this.numberOfBeds;
        if (this.beds.get("Односпальных кроватей") != 0) {
            desc = desc + singleBedsDesc();
            countBeds = countBeds - this.beds.get("Односпальных кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.beds.get("Двуспальных кроватей") != 0) {
            desc = desc + doubleBedsDesc();
            countBeds = countBeds - this.beds.get("Двуспальных кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.beds.get("Кроватей king-size") != 0) {
            desc = desc + kingBedsDesc();
            countBeds = countBeds - this.beds.get("Кроватей king-size");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.beds.get("Особо широких двуспальных") != 0) {
            desc = desc + superKingBedsDesc();
            countBeds = countBeds - this.beds.get("Особо широких двуспальных");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.beds.get("Двухъярусных кроватей") != 0) {
            desc = desc + yarusBedsDesc();
            countBeds = countBeds - this.beds.get("Двухъярусных кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        if (this.beds.get("Диван-кроватей") != 0) {
            desc = desc + sofaBedsDesc();
            countBeds = countBeds - this.beds.get("Диван-кроватей");
            if (countBeds != 0) {
                desc = desc + ", " ;
            }
        }
        return desc;
    }
}
