package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by jliu on 10/25/15.
 */

import com.qualcomm.robotcore.util.*;

public class BaseBot2ManualDemo extends BaseBot2Manual {
    @Override
    protected void mainLoop() {
        double leftDrivePower = gamepad1.left_stick_y;
        double rightDrivePower = gamepad1.right_stick_y;
        leftDriveMotor.setPower(leftDrivePower);
        rightDriveMotor.setPower(rightDrivePower);
        intakeMotor.setPower(gamepad1.left_trigger);
        updateFlipper();
        updateTelemetry();
    }

    protected void updateFlipper(){
        if (gamepad1.left_bumper){
            flipper.setPosition(flipperLeft);
        }else if(gamepad1.right_bumper){
            flipper.setPosition(flipperRight);
        }else{
            flipper.setPosition(flipperCenter);
        }
    }
}
