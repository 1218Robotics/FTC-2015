package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by jliu on 11/19/15.
 */
public class VarmintMotorTest extends VarmintAuton {
    public void auton() throws InterruptedException {
        driveTrain.rightMotor.driveCounts(1140, 1);
        while (driveTrain.rightMotor.isBusy()) {
            waitOneFullHardwareCycle();
            telemetry();
        }
        driveTrain.leftMotor.driveCounts(1140, 1);
        while (driveTrain.leftMotor.isBusy()) {
            waitOneFullHardwareCycle();
            telemetry();
        }
        driveTrain.rightMotor.driveCounts(1140, 1);
        while (driveTrain.rightMotor.isBusy()) {
            waitOneFullHardwareCycle();
            telemetry();
        }
        driveTrain.leftMotor.driveCounts(1140, 1);
        while (driveTrain.leftMotor.isBusy()) {
            waitOneFullHardwareCycle();
            telemetry();
        }
    }

    public void telemetry(){
        telemetry.addData("Current Counts:",driveTrain.rightMotor.getCurrentPosition());
        telemetry.addData("Target Counts:",driveTrain.rightMotor.getTargetPosition());
        telemetry.addData("isBusy",driveTrain.leftMotor.isBusy());
    }
}
