package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.*;
import com.qualcomm.ftcrobotcontroller.opmodes.Varmint.SubSystems.Arm;
import com.qualcomm.ftcrobotcontroller.opmodes.Varmint.SubSystems.DriveTrain;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class VarmintHardware extends VarmintHardwareConfig {
    protected static DcMotorController DriveMotorController;
    protected static DriveTrain driveTrain;
    protected static DcMotor intakeMotor;
    protected static DcMotor beltMotor;
    protected static InterfaceIO interfaceIO;
    protected static Servo leftRampServo;
    protected static Servo rightRampServo;

    ColorSensor colorSensor;
    DeviceInterfaceModule deviceInterfaceModule;

    public void initRobot(){
        DriveMotorController = hardwareMap.dcMotorController.get(driveMotorControllerName);
        driveTrain = new DriveTrain(hardwareMap.dcMotor.get(leftMotorName),hardwareMap.dcMotor.get(rightMotorName));
        intakeMotor = hardwareMap.dcMotor.get(intakeMotorName);
        beltMotor = hardwareMap.dcMotor.get(beltMotorName);
        interfaceIO = new InterfaceIO(hardwareMap.deviceInterfaceModule.get(interfaceIOName));
        leftRampServo = hardwareMap.servo.get(leftRampServoName);
        rightRampServo = hardwareMap.servo.get(rightRampServoName);

    }

    public void stopRobot(){
        driveTrain.stop();
    }

    /*protected void turn(int degree, double power){
        double driveDistance = (degree/360.0)*turnCircumference;
        leftDriveMotor.driveInches(driveDistance, power);
        rightDriveMotor.driveInches(driveDistance, power);
    }*/

    public void updateTelemetry(){
        telemetry.addData("Left Power:",driveTrain.leftMotor.getPower());
        telemetry.addData("Left Encoder:",driveTrain.leftMotor.getCurrentPosition());
        telemetry.addData("Right Power:",driveTrain.rightMotor.getPower());
        telemetry.addData("Right Encoder:",driveTrain.rightMotor.getCurrentPosition());
    }
}
