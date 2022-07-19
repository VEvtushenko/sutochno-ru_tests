package ru.sutochno.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewAdvertisement {
    public boolean success;

        @lombok.Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Data {
            public String object_id;
            public Integer status_id;
        }

    public Data data;
    public ArrayList<Object> errors;
    public ArrayList<Object> actions;
    public Object platform;
    public Object uuid;
    public Integer timestamp;
}