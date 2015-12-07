package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

/**
 * Created by jliu on 10/25/15.
 */

import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;

public class VarmintManualDemo extends VarmintManual {

    protected void setup(){
        driveTrain.leftMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        driveTrain.rightMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
    }
    @Override
    protected void mainLoop() {

        double leftDrivePower = gamepad1.left_stick_y;
        double rightDrivePower = gamepad1.right_stick_y;
        driveTrain.setDrivePower(leftDrivePower, rightDrivePower);
        if(gamepad1.right_bumper){
            intakeMotor.setPower(1);
        }
        leftRampServo.setPosition(Range.scale(gamepad2.left_stick_y,-1,1,0,1));
        telemetry.addData("left pos:",leftRampServo.getPosition());
        rightRampServo.setPosition(Range.scale(gamepad2.right_stick_y,-1,1,0,1));
        telemetry.addData("right pos:",rightRampServo.getPosition());
        updateTelemetry();
    }
}
