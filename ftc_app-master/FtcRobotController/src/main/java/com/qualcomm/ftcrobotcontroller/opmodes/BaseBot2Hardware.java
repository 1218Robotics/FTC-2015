package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.DriveMotor;
import com.qualcomm.ftcrobotcontroller.hardwareinterface.InterfaceIO;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class BaseBot2Hardware extends BaseBot2HardwareConfig {
    protected static DcMotorController DriveMotorController;
    protected static DriveMotor leftDriveMotor;
    protected static DriveMotor rightDriveMotor;
    protected static DcMotor intakeMotor;
    protected static InterfaceIO interfaceIO;

    ColorSensor colorSensor;
    DeviceInterfaceModule deviceInterfaceModule;

    public void initRobot(){
        DriveMotorController = hardwareMap.dcMotorController.get(driveMotorControllerName);
        leftDriveMotor = new DriveMotor(hardwareMap.dcMotor.get(leftMotorName), leftDirection);
        rightDriveMotor= new DriveMotor(hardwareMap.dcMotor.get(rightMotorName), rightDirection);
        colorSensor = hardwareMap.colorSensor.get(colorSensorName);
        intakeMotor = hardwareMap.dcMotor.get(intakeMotorName);

        interfaceIO = new InterfaceIO(hardwareMap.deviceInterfaceModule.get(interfaceIOName));

    }

    public void stopRobot(){
        leftDriveMotor.setPower(0);
        rightDriveMotor.setPower(0);
        leftDriveMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightDriveMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    protected void turn(int degree, double power){
        double driveDistance = (degree/360.0)*turnCircumference;
        leftDriveMotor.driveInches(driveDistance, power);
        rightDriveMotor.driveInches(driveDistance, power);
    }

    public boolean isRed(int limit){
        return colorSensor.red() > limit;
    }

    public void updateTelemetry(){
        if(showDcMotorPower){
        }
        if(showServoPosition){
            telemetry.addData("LB",gamepad1.left_bumper);
            telemetry.addData("RB",gamepad1.right_bumper);
        }
    }
}
