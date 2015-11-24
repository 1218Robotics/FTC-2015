package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

/**
 * Created by jliu on 10/25/15.
 */

import com.qualcomm.robotcore.util.Range;

public class VarmintManualDemo extends VarmintManual {
    @Override
    protected void mainLoop() {

        double leftDrivePower = gamepad1.left_stick_y;
        double rightDrivePower = gamepad1.right_stick_y;
        leftDriveMotor.setPower(leftDrivePower);
        rightDriveMotor.setPower(rightDrivePower);
        intakeMotor.setPower(gamepad1.left_trigger);
        arm.rotateArmRaw(Range.scale(gamepad2.left_stick_y,-1,1,0,1));
        updateTelemetry();
        telemetry.addData("leftMotorCounts",leftDriveMotor.getCurrentPosition());
        telemetry.addData("leftMotorPower",leftDriveMotor.getPower());
    }
}
