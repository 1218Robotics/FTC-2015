package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.ftcrobotcontroller.hardwareinterface.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class BaseBot2HardwareConfig extends LinearOpMode  {
    protected static final double robotDiagonal = 21.45669;
    protected static final double turnCircumference = robotDiagonal*Math.PI;

    protected enum FlipperDirection {left,center,right}

    protected static final double flipperCenter = 0.5;
    protected static final double flipperLeft = 0.6666667;
    protected static final double flipperRight = 0.2627451;

    protected static final String driveMotorControllerName = "Motor Controller 1";
    protected static final String leftMotorName = "Motor 11";
    protected static final String rightMotorName = "Motor 21";
    protected static final String interfaceIOName = "Device Interface Module 1";
    protected static final String colorSensorName = "iic 10";
    protected static final String intakeMotorName = "Motor 31";

    protected static final DcMotor.Direction leftDirection = DcMotor.Direction.FORWARD;
    protected static final DcMotor.Direction rightDirection = DcMotor.Direction.REVERSE;

    //Telemetry config
    protected static final boolean showDcMotorPower = false;
    protected static final boolean showServoPosition = true;

}
