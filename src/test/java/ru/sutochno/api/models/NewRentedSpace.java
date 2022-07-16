package ru.sutochno.api.models;

import java.util.ArrayList;

public class NewRentedSpace{
    public boolean success;
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