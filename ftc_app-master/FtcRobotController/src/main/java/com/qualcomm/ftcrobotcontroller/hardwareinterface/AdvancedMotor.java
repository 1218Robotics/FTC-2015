package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by jliu on 11/12/15.
 */
public class AdvancedMotor{
    protected DcMotor dcMotor;

    public AdvancedMotor(DcMotor dcMotor,DcMotor.Direction direction){
        this.dcMotor = dcMotor;
        dcMotor.setDirection(direction);
    }

    public void setPower(double power){
        dcMotor.setPower(power);
    }

    public void setDirection(DcMotor.Direction direction) {
        dcMotor.setDirection(direction);
    }

    public void setTargetPosition(int targetPosition) {
        dcMotor.setTargetPosition(targetPosition);
    }

    public void setMode(DcMotorController.RunMode runMode) {
        dcMotor.setMode(runMode);
    }

    public void driveCounts(int counts, double power) {
        setMode(DcMotorController.RunMode.RESET_ENCODERS);
        setTargetPosition(counts);
        setPower(power);
    }




}
