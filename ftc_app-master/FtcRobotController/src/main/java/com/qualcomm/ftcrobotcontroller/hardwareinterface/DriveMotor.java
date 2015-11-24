package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by jliu on 11/12/15.
 */
public class DriveMotor extends AdvancedMotor{

    protected final static double countsPerRotation = 1120;
    protected final static double wheelDiameter = 4.75;
    protected final static double wheelCircumference = wheelDiameter *3.1415;
    protected final static double distancePerCount = wheelCircumference/countsPerRotation;

    public DriveMotor(DcMotorController controller,int port) {
        super(controller,port);
    }

    public DriveMotor(DcMotor dcMotor){
        super(dcMotor);
    }

    public void driveInches(double inches, double power) {
        driveCounts((int)(distancePerCount/inches), power);
    }
}
