package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorController.*;


/**
 * Created by rgoudy on 10/13/15.
 */
public class HalfDrive {

    protected final double countsPerRotation = 1120;
    protected final double wheelDiameter = 4.75;
    protected final double wheelCircumference = wheelDiameter *3.1415;
    protected final double distancePerCount = wheelCircumference/countsPerRotation;


    public DcMotor front;
    public DcMotor back;

    public int inchesToCounts(double inches) {
        return (int)(inches/distancePerCount);
    }

    public HalfDrive(DcMotor front, DcMotor back,DcMotor.Direction direction) {
        this.front = front;
        this.back = back;

        this.front.setDirection(direction);
        this.back.setDirection(direction);
    }

    public void setPower(double power){
        front.setPower(power);
        back.setPower(power);
    }

    public void setDirection(DcMotor.Direction direction) {
        front.setDirection(direction);
        back.setDirection(direction);
    }

    public void setTargetPosition(int targetPosition) {
        front.setTargetPosition(targetPosition);
        back.setTargetPosition(targetPosition);
    }

    public void channelMode(DcMotorController.RunMode runMode) {
        front.setChannelMode(runMode);
        back.setChannelMode(runMode);
    }

    public void driveInches(double inches, double power) {
        channelMode(DcMotorController.RunMode.RESET_ENCODERS);
        setTargetPosition(inchesToCounts(inches));
        setPower(power);


    }

}
