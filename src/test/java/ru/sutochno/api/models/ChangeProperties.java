package ru.sutochno.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.sutochno.pages.MainPage;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeProperties {
	private Integer objectId;
	private Properties properties;
}