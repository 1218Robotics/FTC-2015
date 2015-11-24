package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.ftcrobotcontroller.hardwareinterface.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class VarmintHardwareConfig extends LinearOpMode  {
    protected static final double robotDiagonal = 21.45669;
    protected static final double turnCircumference = robotDiagonal*Math.PI;

    protected enum FlipperDirection {left,center,right}

    protected static final String driveMotorControllerName = "Motor Controller 1";
    protected static final String leftMotorName = "Motor 41";
    protected static final String rightMotorName = "Motor 42";
    protected static final String interfaceIOName = "Device Interface Module 2";
    protected static final String intakeMotorName = "Motor 12";
    protected static final String armMotorName = "Motor 11";

    protected static final String armServo1Name = "Servo 31";
    protected static final String armServo2Name = "Servo 32";

    protected static final DcMotor.Direction leftDirection = DcMotor.Direction.FORWARD;
    protected static final DcMotor.Direction rightDirection = DcMotor.Direction.REVERSE;

    //Telemetry config
    protected static final boolean showDcMotorPower = false;
    protected static final boolean showServoPosition = true;

}
