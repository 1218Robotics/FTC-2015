package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.ftcrobotcontroller.hardwareinterface.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class BaseBot2HardwareConfig extends LinearOpMode  {
    final String leftDriveControllerName = "Motor Controller 1";
    final String rightDriveControllerName = "Motor Controller 2";
    final String leftFrontMotorName = "Motor 11";
    final String leftRearMotorName = "Motor 12";
    final String rightFrontMotorName = "Motor 21";
    final String rightRearMotorName = "Motor 22";
    final String intakeSortingServoName = "Servo 11";

    final DcMotor.Direction leftDirection = DcMotor.Direction.FORWARD;
    final DcMotor.Direction rightDirection = DcMotor.Direction.REVERSE;
}
