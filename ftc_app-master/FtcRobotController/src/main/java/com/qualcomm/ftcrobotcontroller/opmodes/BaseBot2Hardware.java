package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.HalfDrive;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class BaseBot2Hardware extends BaseBot2HardwareConfig {
    DcMotorController leftDriveController;
    DcMotorController rightDriveController;
    HalfDrive leftDriveMotor;
    HalfDrive rightDriveMotor;

    ColorSensor colorSensor;
    DeviceInterfaceModule deviceInterfaceModule;

    public void initRobot(){
        leftDriveController = hardwareMap.dcMotorController.get(leftDriveControllerName);
        rightDriveController = hardwareMap.dcMotorController.get(rightDriveControllerName);
        leftDriveMotor = new HalfDrive(hardwareMap.dcMotor.get(leftFrontMotorName),
                                        hardwareMap.dcMotor.get(leftRearMotorName),
                                        leftDirection);
        rightDriveMotor= new HalfDrive(hardwareMap.dcMotor.get(rightFrontMotorName),
                                        hardwareMap.dcMotor.get(rightRearMotorName),
                                        rightDirection);
        colorSensor = hardwareMap.colorSensor.get("iic 10");
        deviceInterfaceModule = hardwareMap.deviceInterfaceModule.get("Device Interface Module 1");

    }
    public void stopRobot(){
        leftDriveMotor.setPower(0);
        rightDriveMotor.setPower(0);
        leftDriveMotor.channelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightDriveMotor.channelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    public boolean isRed(int limit){
        return colorSensor.red() > limit;
    }
}
