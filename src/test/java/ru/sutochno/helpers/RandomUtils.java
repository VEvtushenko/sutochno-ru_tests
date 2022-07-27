package ru.sutochno.helpers;

import java.util.Random;

public class RandomUtils {
    public Integer getInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) - random.nextInt(min) + min;
    }
}
