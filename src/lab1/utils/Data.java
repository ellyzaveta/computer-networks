package lab1.utils;

import java.util.Random;

public class Data {
    public static final int    portTCP = 52170;
    public static final int    portUDP = 36281;
    public static final int    time    = 1000;
    public static final String host    = "localhost";

    public static float getRandFloat() {
        return new Random().nextFloat() * 10000;
    }

    public static double getRandDouble() {
        return new Random().nextDouble() * 10000;
    }
}
