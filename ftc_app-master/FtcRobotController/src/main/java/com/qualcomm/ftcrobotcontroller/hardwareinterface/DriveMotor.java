package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by jliu on 11/12/15.
 */
public class DriveMotor extends AdvancedMotor{

    protected final static double countsPerRotation = 1120;
    protected final static double wheelDiameter = 4.75;
    protected final static double wheelCircumference = wheelDiameter *3.1415;
    protected final static double distancePerCount = wheelCircumference/countsPerRotation;

    public DriveMotor(DcMotor dcMotor, DcMotor.Direction direction) {
        super(dcMotor,direction);
    }

    public void driveInches(double inches, double power) {
        driveCounts((int)(distancePerCount/inches), power);
    }
}
