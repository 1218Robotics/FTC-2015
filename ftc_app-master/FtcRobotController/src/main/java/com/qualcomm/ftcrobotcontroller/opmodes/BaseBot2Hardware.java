package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class BaseBot2Hardware extends BaseBot2HardwareConfig {
    DcMotor leftDriveMotor = hardwareMap.dcMotor.get(leftFrontMotorName);
    DcMotor rightDriveMotor = hardwareMap.dcMotor.get(rightFrontMotorName);
    /*DriveMotor leftDriveMotor = new DriveMotor(hardwareMap.dcMotor.get(leftFrontMotorName),
            hardwareMap.dcMotor.get(leftRearMotorName),leftDirction);
    DriveMotor rightDriveMotor = new DriveMotor(hardwareMap.dcMotor.get(rightFrontMotorName),
            hardwareMap.dcMotor.get(rightRearMotorName),rightDirction);*/
}
