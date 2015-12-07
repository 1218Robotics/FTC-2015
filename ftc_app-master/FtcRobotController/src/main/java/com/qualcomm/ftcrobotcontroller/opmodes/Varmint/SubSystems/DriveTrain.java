package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.SubSystems;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.DriveMotor;
import com.qualcomm.ftcrobotcontroller.hardwareinterface.SubSystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by jliu on 11/17/15.
 */
public class DriveTrain implements SubSystem{
    public enum Reversed{left,right};

    public DriveMotor leftMotor;
    public DriveMotor rightMotor;
    protected static final Reversed defaultDirection = Reversed.left;

    public DriveTrain(DcMotor leftMotor, DcMotor rightMotor){
        this.leftMotor = new DriveMotor(leftMotor);
        this.rightMotor = new DriveMotor(rightMotor);
        updateDirection(defaultDirection);
    }

    public void setDrivePower(double leftPower, double rightPower){
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }


    public void updateDirection(Reversed reversed){
        if(reversed == Reversed.left){
            leftMotor.setDirection(DcMotor.Direction.REVERSE);
            rightMotor.setDirection(DcMotor.Direction.FORWARD);
        }else{
            leftMotor.setDirection(DcMotor.Direction.FORWARD);
            rightMotor.setDirection(DcMotor.Direction.REVERSE);
        }
    }

    public void stop(){
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

}
