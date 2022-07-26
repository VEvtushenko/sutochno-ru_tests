package ru.sutochno.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertisementChangeResponse{
	private Data data;

	@lombok.Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Data{
		@JsonProperty("object_id")
		private int objectId;
		private Properties properties;
	}

	private boolean success;
	private List<Object> actions;
	private Object uuid;
	private List<Object> errors;
	private Object platform;
	private int timestamp;
}