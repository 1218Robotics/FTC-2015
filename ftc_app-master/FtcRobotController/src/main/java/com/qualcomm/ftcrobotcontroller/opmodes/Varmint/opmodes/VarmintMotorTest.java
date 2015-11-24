package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

/**
 * Created by jliu on 11/19/15.
 */
public class VarmintMotorTest extends VarmintAuton {
    public void auton() throws InterruptedException {
        telemetry.addData("begin","OPMODE START");
        leftDriveMotor.driveInches(203.4, 1);
        while (opModeIsActive()) {
            telemetry.addData("is busy",leftDriveMotor.isBusy());
            waitOneFullHardwareCycle();
        }
        telemetry.addData("begin","END");
    }
}
