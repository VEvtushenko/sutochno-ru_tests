package ru.sutochno.data.adverticement;

import java.util.Random;

public class Beds {

    private Integer singleBed;
    private Integer doubleBed;
    private Integer kingBed;
    private Integer superKingBed;
    private Integer yarusBed;
    private Integer bsofaBed;
    private Integer numberOfBeds;
    private Integer maxGuests;

    public Beds() {
        this.singleBed = 1;
        this.doubleBed = 0;
        this.kingBed = 0;
        this.superKingBed = 0;
        this.yarusBed = 0;
        this.bsofaBed = 0;
        this.numberOfBeds = this.singleBed + this.doubleBed + this.kingBed + this.superKingBed + this.yarusBed + this.bsofaBed;
        this.maxGuests =  this.singleBed + this.doubleBed*2 + this.kingBed*2 + this.superKingBed*2 + this.yarusBed*2 + this.bsofaBed*2;
    }

    public  Beds(Integer singleBed, Integer doubleBed, Integer kingBed, Integer superKingBed, Integer yarusBed, Integer bsofaBed, Integer getSingleBed) {
        this.singleBed = singleBed;
        this.doubleBed = doubleBed;
        this.kingBed = kingBed;
        this.superKingBed = superKingBed;
        this.yarusBed = yarusBed;
        this.bsofaBed = bsofaBed;
        this.numberOfBeds = this.singleBed + this.doubleBed + this.kingBed + this.superKingBed + this.yarusBed + this.bsofaBed;
        this.maxGuests =  this.singleBed + this.doubleBed*2 + this.kingBed*2 + this.superKingBed*2 + this.yarusBed*2 + this.bsofaBed*2;
    }

    public  Beds(Random random) {
        this.singleBed = random.nextInt(2);
        this.doubleBed = random.nextInt(2);
        this.kingBed = random.nextInt(2);
        this.superKingBed = random.nextInt(2);
        this.yarusBed = random.nextInt(2);
        this.bsofaBed = random.nextInt(2);
        this.numberOfBeds = this.singleBed + this.doubleBed + this.kingBed + this.superKingBed + this.yarusBed + this.bsofaBed;
        this.maxGuests =  this.singleBed + this.doubleBed*2 + this.kingBed*2 + this.superKingBed*2 + this.yarusBed*2 + this.bsofaBed*2;
    }

    public void setSingleBed(Integer singleBed) {
        this.numberOfBeds = this.numberOfBeds + singleBed - this.singleBed;
        this.maxGuests = this.maxGuests + singleBed - this.singleBed;
        this.singleBed = singleBed;
    }

    public Integer getDoubleBed() {
        return doubleBed;
    }

    public void setDoubleBed(Integer doubleBed) {
        this.numberOfBeds = this.numberOfBeds + doubleBed - this.doubleBed;
        this.maxGuests = this.maxGuests + doubleBed*2 - this.doubleBed*2;
        this.doubleBed = doubleBed;
    }

    public Integer getKingBed() {
        return kingBed;
    }

    public void setKingBed(Integer kingBed) {
        this.numberOfBeds = this.numberOfBeds + kingBed - this.kingBed;
        this.maxGuests = this.maxGuests + kingBed*2 - this.kingBed*2;
        this.kingBed = kingBed;
    }

    public Integer getSuperKingBed() {
        return superKingBed;
    }

    public void setSuperKingBed(Integer superKingBed) {
        this.numberOfBeds = this.numberOfBeds + superKingBed - this.superKingBed;
        this.maxGuests = this.maxGuests + superKingBed*2 - this.superKingBed*2;
        this.superKingBed = superKingBed;
    }

    public Integer getYarusBed() {
        return yarusBed;
    }

    public void setYarusBed(Integer yarusBed) {
        this.numberOfBeds = this.numberOfBeds + yarusBed - this.yarusBed;
        this.maxGuests = this.maxGuests + yarusBed*2 - this.yarusBed*2;
        this.yarusBed = yarusBed;
    }

    public Integer getBsofaBed() {
        return bsofaBed;
    }

    public void setBsofaBed(Integer bsofaBed) {
        this.numberOfBeds = this.numberOfBeds + bsofaBed - this.bsofaBed;
        this.maxGuests = this.maxGuests + bsofaBed*2 - this.bsofaBed*2;
        this.bsofaBed = bsofaBed;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

}
