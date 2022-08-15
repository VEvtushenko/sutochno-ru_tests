package ru.sutochno.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectProperties {
	private Integer objectId;
	private Properties properties;
}