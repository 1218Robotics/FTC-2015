package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.*;
import com.qualcomm.ftcrobotcontroller.opmodes.Varmint.SubSystems.Arm;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class VarmintHardware extends VarmintHardwareConfig {
    protected static DcMotorController DriveMotorController;
    protected static DriveMotor leftDriveMotor;
    protected static DriveMotor rightDriveMotor;
    protected static DcMotor intakeMotor;
    protected static InterfaceIO interfaceIO;
    protected static Arm arm;

    ColorSensor colorSensor;
    DeviceInterfaceModule deviceInterfaceModule;

    public void initRobot(){
        DriveMotorController = hardwareMap.dcMotorController.get(driveMotorControllerName);
        leftDriveMotor = new DriveMotor(hardwareMap.dcMotor.get(leftMotorName));
        rightDriveMotor = new DriveMotor(hardwareMap.dcMotor.get(rightMotorName));
        leftDriveMotor.setDirection(leftDirection);
        rightDriveMotor.setDirection(rightDirection);
        intakeMotor = hardwareMap.dcMotor.get(intakeMotorName);
        interfaceIO = new InterfaceIO(hardwareMap.deviceInterfaceModule.get(interfaceIOName));
        arm = new Arm(hardwareMap.dcMotor.get(armMotorName),hardwareMap.servo.get(armServo1Name),hardwareMap.servo.get(armServo2Name));

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

    public void updateTelemetry(){
        if(showDcMotorPower){
        }
        if(showServoPosition){
            telemetry.addData("ArmServo1",arm.baseServo1.getPosition());
            telemetry.addData("ArmServo2",arm.baseServo2.getPosition());
        }
    }
}
