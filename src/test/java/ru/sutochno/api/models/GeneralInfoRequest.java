package ru.sutochno.api.models;

import lombok.Data;

@Data
public class GeneralInfoRequest{
	private int objectId;
	private Properties properties;
	@Data
	public class Properties{
		private String area;
		private String qualityRepair;
		private boolean lift;
		private boolean atticFloor;
		private int floor;
		private String maxFloor;
		private String kitchenFlat;
	}
}