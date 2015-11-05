package com.qualcomm.ftcrobotcontroller.hardwareinterface;

/**
 * Created by jliu on 11/4/15.
 */
public class HelperClass {
    public static boolean inRange(double number, double max, double min) {
        return number >= min && number <= max;
    }

    public static boolean inRange(int number, int max, int min) {
        return number >= min && number <= max;
    }
}
