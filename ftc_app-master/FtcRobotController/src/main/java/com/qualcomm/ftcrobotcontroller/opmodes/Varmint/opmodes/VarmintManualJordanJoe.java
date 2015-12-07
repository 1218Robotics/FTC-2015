package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by jliu on 12/2/15.
 */
public class VarmintManualJordanJoe extends VarmintManual{
    protected static final double triggerThreshold = 0.5;
    protected static final double intakePower = 1;
    protected void setup() throws InterruptedException{
        driveTrain.leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveTrain.rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        waitOneFullHardwareCycle();
        driveTrain.rightMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        driveTrain.leftMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
    }
    protected  void mainLoop(){
        arcadeDrive();
        if(triggered(gamepad2.left_trigger)){
            intakeMotor.setPower(intakePower);
        }else if(triggered(gamepad2.right_trigger)) {
            intakeMotor.setPower(-intakePower);
        }else{
            intakeMotor.setPower(0);
            intakeMotor.setPower(0);
        }
        updateTelemetry();
    }

    protected void arcadeDrive(){
        double drivePower = gamepad1.left_stick_y;
        double drivePowerBiasIndex = gamepad1.right_stick_x;
        double leftPower;
        double rightPower;
        if(drivePowerBiasIndex >= 0){
            leftPower = drivePower;
            rightPower = drivePower * (-2*drivePowerBiasIndex+1);
        }else{
            rightPower = drivePower;
            leftPower = drivePower - (2*drivePowerBiasIndex+1);
        }
        driveTrain.setDrivePower(leftPower,rightPower);
    }

    protected boolean triggered(double input){
        return input > triggerThreshold;
    }
}
