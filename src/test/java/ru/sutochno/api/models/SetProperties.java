package ru.sutochno.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SetProperties {
	private int objectId;
	private Properties properties;
	@Data
	public class Properties{
		@JsonProperty("parking")
		private boolean parking;

		@JsonProperty("ext_links")
		private String extLinks;

		@JsonProperty("bsofa_bed")
		private int bsofaBed;

		@JsonProperty("parasol")
		private boolean parasol;

		@JsonProperty("hygienic_shower")
		private boolean hygienicShower;

		@JsonProperty("cnt_bathrooms_toilet")
		private int cntBathroomsToilet;

		@JsonProperty("tgames")
		private boolean tgames;

		@JsonProperty("barbecue_facilities")
		private boolean barbecueFacilities;

		@JsonProperty("attic_floor")
		private boolean atticFloor;

		@JsonProperty("laptop")
		private boolean laptop;

		@JsonProperty("bath1")
		private boolean bath1;

		@JsonProperty("balcony")
		private boolean balcony;

		@JsonProperty("kettle")
		private boolean kettle;

		@JsonProperty("kitchen_flat")
		private String kitchenFlat;

		@JsonProperty("tv_free")
		private boolean tvFree;

		@JsonProperty("bar")
		private boolean bar;

		@JsonProperty("fan")
		private boolean fan;

		@JsonProperty("quality_repair")
		private String qualityRepair;

		@JsonProperty("yarus_bed")
		private int yarusBed;

		@JsonProperty("dvd")
		private boolean dvd;

		@JsonProperty("games")
		private boolean games;

		@JsonProperty("baby_bed")
		private boolean babyBed;

		@JsonProperty("tabletennis")
		private boolean tabletennis;

		@JsonProperty("clothesdryer")
		private boolean clothesdryer;

		@JsonProperty("bedclothes")
		private boolean bedclothes;

		@JsonProperty("electricrange")
		private boolean electricrange;

		@JsonProperty("wifi")
		private boolean wifi;

		@JsonProperty("sofa")
		private boolean sofa;

		@JsonProperty("cnt_bathrooms")
		private int cntBathrooms;

		@JsonProperty("v_fore")
		private boolean vFore;

		@JsonProperty("jacuzzi")
		private boolean jacuzzi;

		@JsonProperty("add_bathroom")
		private boolean addBathroom;

		@JsonProperty("isolation")
		private boolean isolation;

		@JsonProperty("bathrooms")
		private boolean bathrooms;

		@JsonProperty("v_moun")
		private boolean vMoun;

		@JsonProperty("shared_toilet")
		private boolean sharedToilet;

		@JsonProperty("bedrooms")
		private int bedrooms;

		@JsonProperty("books")
		private boolean books;

		@JsonProperty("lift")
		private boolean lift;

		@JsonProperty("hairdryer")
		private boolean hairdryer;

		@JsonProperty("swimpool1")
		private boolean swimpool1;

		@JsonProperty("max_floor")
		private String maxFloor;

		@JsonProperty("v_strt")
		private boolean vStrt;

		@JsonProperty("shower")
		private boolean shower;

		@JsonProperty("folding_bed")
		private boolean foldingBed;

		@JsonProperty("washmachine")
		private boolean washmachine;

		@JsonProperty("max_guests")
		private int maxGuests;

		@JsonProperty("deepfreeze")
		private boolean deepfreeze;

		@JsonProperty("baby_bed_m")
		private boolean babyBedM;

		@JsonProperty("fireplace")
		private boolean fireplace;

		@JsonProperty("patio")
		private boolean patio;

		@JsonProperty("barbecue")
		private boolean barbecue;

		@JsonProperty("v_city")
		private boolean vCity;

		@JsonProperty("sauna")
		private boolean sauna;

		@JsonProperty("coffeemaker")
		private boolean coffeemaker;

		@JsonProperty("terrace")
		private boolean terrace;

		@JsonProperty("carpet_covering")
		private boolean carpetCovering;

		@JsonProperty("kitchen")
		private boolean kitchen;

		@JsonProperty("add_toilet")
		private boolean addToilet;

		@JsonProperty("soundproofing")
		private boolean soundproofing;

		@JsonProperty("veranda")
		private boolean veranda;

		@JsonProperty("garage")
		private boolean garage;

		@JsonProperty("deckchair")
		private boolean deckchair;

		@JsonProperty("babychair")
		private boolean babychair;

		@JsonProperty("cupboard")
		private boolean cupboard;

		@JsonProperty("boat")
		private boolean boat;

		@JsonProperty("v_lake")
		private boolean vLake;

		@JsonProperty("swing")
		private boolean swing;

		@JsonProperty("single_bed")
		private int singleBed;

		@JsonProperty("Toaster")
		private boolean toaster;

		@JsonProperty("cnt_toilets")
		private int cntToilets;

		@JsonProperty("arbor")
		private boolean arbor;

		@JsonProperty("baby_potty")
		private boolean babyPotty;

		@JsonProperty("baby_chang_table")
		private boolean babyChangTable;

		@JsonProperty("double_bed")
		private int doubleBed;

		@JsonProperty("mosquito_net")
		private boolean mosquitoNet;

		@JsonProperty("tv")
		private boolean tv;

		@JsonProperty("wooden_parquet_floor")
		private boolean woodenParquetFloor;

		@JsonProperty("laminate")
		private boolean laminate;

		@JsonProperty("v_rive")
		private boolean vRive;

		@JsonProperty("cutlery")
		private boolean cutlery;

		@JsonProperty("cleaning_products")
		private boolean cleaningProducts;

		@JsonProperty("crockery")
		private boolean crockery;

		@JsonProperty("blender")
		private boolean blender;

		@JsonProperty("radio")
		private boolean radio;

		@JsonProperty("towels")
		private boolean towels;

		@JsonProperty("gfurniture")
		private boolean gfurniture;

		@JsonProperty("wardrobe")
		private boolean wardrobe;

		@JsonProperty("heating")
		private boolean heating;

		@JsonProperty("seating_area")
		private boolean seatingArea;

		@JsonProperty("electric_blankets")
		private boolean electricBlankets;

		@JsonProperty("area")
		private String area;

		@JsonProperty("tv_cable")
		private boolean tvCable;

		@JsonProperty("tiled_marble_floor")
		private boolean tiledMarbleFloor;

		@JsonProperty("dishwasher")
		private boolean dishwasher;

		@JsonProperty("heater")
		private boolean heater;

		@JsonProperty("billiards1")
		private boolean billiards1;

		@JsonProperty("telephone")
		private boolean telephone;

		@JsonProperty("v_yard")
		private boolean vYard;

		@JsonProperty("geyser")
		private boolean geyser;

		@JsonProperty("condition")
		private boolean condition;

		@JsonProperty("super_king_bed")
		private int superKingBed;

		@JsonProperty("safe")
		private boolean safe;

		@JsonProperty("cshower")
		private boolean cshower;

		@JsonProperty("gasstove")
		private boolean gasstove;

		@JsonProperty("gym")
		private boolean gym;

		@JsonProperty("refrigerator")
		private boolean refrigerator;

		@JsonProperty("high_chair_for_child")
		private boolean highChairForChild;

		@JsonProperty("turka")
		private boolean turka;

		@JsonProperty("linoleum")
		private boolean linoleum;

		@JsonProperty("internet")
		private boolean internet;

		@JsonProperty("self_number_object")
		private String selfNumberObject;

		@JsonProperty("king_bed")
		private int kingBed;

		@JsonProperty("music_center")
		private boolean musicCenter;

		@JsonProperty("steel_door")
		private boolean steelDoor;

		@JsonProperty("waterfilter")
		private boolean waterfilter;

		@JsonProperty("disks")
		private boolean disks;

		@JsonProperty("safe_window")
		private boolean safeWindow;

		@JsonProperty("drying_machine")
		private boolean dryingMachine;

		@JsonProperty("tv_sattelite")
		private boolean tvSattelite;

		@JsonProperty("description")
		private String description;

		@JsonProperty("ctable")
		private boolean ctable;

		@JsonProperty("security")
		private boolean security;

		@JsonProperty("toiletries")
		private boolean toiletries;

		@JsonProperty("desktop")
		private boolean desktop;

		@JsonProperty("sofa_bed")
		private boolean sofaBed;

		@JsonProperty("outdoor_furniture")
		private boolean outdoorFurniture;

		@JsonProperty("playground")
		private boolean playground;

		@JsonProperty("v_park")
		private boolean vPark;

		@JsonProperty("intercom")
		private boolean intercom;

		@JsonProperty("mini_bar")
		private boolean miniBar;

		@JsonProperty("floor")
		private int floor;

		@JsonProperty("microwave")
		private boolean microwave;

		@JsonProperty("v_seas")
		private boolean vSeas;

		@JsonProperty("coffee_machine")
		private boolean coffeeMachine;

		@JsonProperty("bathrobe")
		private boolean bathrobe;

		@JsonProperty("shared_bathroom")
		private boolean sharedBathroom;

		@JsonProperty("oven")
		private boolean oven;

		@JsonProperty("slippers")
		private boolean slippers;

		@JsonProperty("multicooker")
		private boolean multicooker;

		@JsonProperty("blu_ray_pl")
		private boolean bluRayPl;

		@JsonProperty("wheater")
		private boolean wheater;

		@JsonProperty("name_object")
		private String nameObject;

		@JsonProperty("dinner_table")
		private boolean dinnerTable;

		@JsonProperty("gridiron")
		private boolean gridiron;

		@JsonProperty("consol")
		private boolean consol;

		@JsonProperty("pc")
		private boolean pc;

		@JsonProperty("outdoor_dining_area")
		private boolean outdoorDiningArea;

		@JsonProperty("hammok")
		private boolean hammok;

		@JsonProperty("iron")
		private boolean iron;

		@JsonProperty("bidet")
		private boolean bidet;

		@JsonProperty("check_in")
		private String checkIn;

		@JsonProperty("check_out")
		private String checkOut;

		@JsonProperty("pets")
		private String pets;

		@JsonProperty("cleaning")
		private int cleaning;

		@JsonProperty("before_days")
		private String beforeDays;

		@JsonProperty("gethering")
		private int gethering;

		@JsonProperty("is_children")
		private String isChildren;

		@JsonProperty("transfer_description")
		private String transferDescription;

		@JsonProperty("is_guest_negative")
		private boolean isGuestNegative;

		@JsonProperty("transfer")
		private boolean transfer;

		@JsonProperty("smoking")
		private String smoking;

		@JsonProperty("deposit")
		private int deposit;

		@JsonProperty("min_nights")
		private int minNights;

		@JsonProperty("party")
		private String party;

		@JsonProperty("precost_percent")
		private int precostPercent;

		@JsonProperty("before_hours")
		private String beforeHours;

	}
}