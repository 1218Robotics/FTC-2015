package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by jliu on 10/25/15.
 */

import com.qualcomm.robotcore.util.*;

public class BaseBot2BaseManual extends BaseBot2Manual {
    @Override
    protected void mainLoop() {
        double leftDrivePower = gamepad1.left_stick_y;
        double rightDrivePower = gamepad1.right_stick_y;
        leftDriveMotor.setPower(leftDrivePower);
        rightDriveMotor.setPower(rightDrivePower);
    }
}
