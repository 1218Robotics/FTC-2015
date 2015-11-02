package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.HalfDrive;
import com.qualcomm.ftcrobotcontroller.hardwareinterface.InterfaceIO;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by jliu on 10/20/15.
 */
public abstract class BaseBot2Hardware extends BaseBot2HardwareConfig {
    protected static DcMotorController leftDriveController;
    protected static DcMotorController rightDriveController;
    protected static HalfDrive leftDriveMotor;
    protected static HalfDrive rightDriveMotor;
    protected static Servo flipper;
    protected static DcMotor intakeMotor;
    protected static InterfaceIO interfaceIO;

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
        colorSensor = hardwareMap.colorSensor.get(colorSensorName);
        flipper = hardwareMap.servo.get(flipperName);
        intakeMotor = hardwareMap.dcMotor.get(intakeMotorName);

        interfaceIO = new InterfaceIO(hardwareMap.deviceInterfaceModule.get(interfaceIOName));

    }

    public void stopRobot(){
        leftDriveMotor.setPower(0);
        rightDriveMotor.setPower(0);
        leftDriveMotor.channelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightDriveMotor.channelMode(DcMotorController.RunMode.RESET_ENCODERS);
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
            telemetry.addData("Flipper:", flipper.getPosition());
            telemetry.addData("LB",gamepad1.left_bumper);
            telemetry.addData("RB",gamepad1.right_bumper);
        }
    }
}
