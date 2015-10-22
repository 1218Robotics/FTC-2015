package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.ftcrobotcontroller.hardwareinterface.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class BaseBot2HardwareConfig extends LinearOpMode  {
    final String leftFrontMotorName = "Motor11";
    final String leftRearMotorName = "Motor 12";
    final String rightFrontMotorName = "Motor21";
    final String rightRearMotorName = "Motor 22";

    final DcMotor.Direction leftDirction = DcMotor.Direction.FORWARD;
    final DcMotor.Direction rightDirction = DcMotor.Direction.REVERSE;
}
