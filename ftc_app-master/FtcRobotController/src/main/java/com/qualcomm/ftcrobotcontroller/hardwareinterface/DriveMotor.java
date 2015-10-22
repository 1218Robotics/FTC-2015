package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by jliu on 10/20/15.
 */
public class DriveMotor {
    DcMotor frontMotor;
    DcMotor rearMotor;
    public DriveMotor(DcMotor frontMotor, DcMotor backMotor , DcMotor.Direction direction){
        this.frontMotor = frontMotor;
        this.rearMotor = backMotor;
        this.frontMotor.setDirection(direction);
        this.rearMotor.setDirection(direction);
    }
    public void setPower(double power){
        frontMotor.setPower(power);
        rearMotor.setPower(power);
    }
}
