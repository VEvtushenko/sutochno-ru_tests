package ru.sutochno.api.models;

import java.util.List;
import lombok.Data;

@Data
public class AdvertisementChangeResponse{
	private Data data;

	@lombok.Data
	public class Data{
		private int objectId;
		private Properties properties;

		@lombok.Data
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

	private boolean success;
	private List<Object> actions;
	private Object uuid;
	private List<Object> errors;
	private Object platform;
	private int timestamp;
}