package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by jliu on 9/30/15.
 */
public class BaseBotHardware extends OpMode {
    final boolean HIGH = true;
    final boolean LOW = false;

    protected DcMotorController leftDriveMotorController;
    protected DcMotorController rightDriveMotorController;
    protected DeviceInterfaceModule deviceInterfaceModule;
    protected ServoController servoController;

    protected DcMotor frontLeftDriveMotor;
    protected DcMotor rearLeftDriveMotor;
    protected DcMotor frontRightDriveMotor;
    protected DcMotor rearRightDriveMotor;

    protected Servo servo1;

    @Override
    public void init() {
        telemetry.addData("Init:","Running");
        leftDriveMotorController = hardwareMap.dcMotorController.get("Left Drive Motor Controller");
        rightDriveMotorController = hardwareMap.dcMotorController.get("Right Drive Motor Controller");
        deviceInterfaceModule = hardwareMap.deviceInterfaceModule.get("Core Interface Module");
        servoController = hardwareMap.servoController.get("Servo Controller");

        frontLeftDriveMotor = hardwareMap.dcMotor.get("Front Left Drive Motor");
        rearLeftDriveMotor = hardwareMap.dcMotor.get("Rear Left Drive Motor");
        frontRightDriveMotor = hardwareMap.dcMotor.get("Front Right Drive Motor");
        rearRightDriveMotor = hardwareMap.dcMotor.get("Rear Right Drive Motor");

        frontLeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        rearLeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);

        servo1 = hardwareMap.servo.get("Servo 1");

        telemetry.addData("Init:","finished");


    }

    @Override
    public void loop() {

    }

    protected void setLeftDrivePower(double drivePower){
        frontLeftDriveMotor.setPower(drivePower);
        rearLeftDriveMotor.setPower(drivePower);
    }

    protected void setRightDrivePower(double drivePower){
        frontRightDriveMotor.setPower(drivePower);
        rearRightDriveMotor.setPower(drivePower);
    }

    float scaleMotorPower (float p_power)
    {
        //
        // Assume no scaling.
        //
        float lScale = 0.0f;

        //
        // Ensure the values are legal.
        //
        float lPower = Range.clip(p_power, -1, 1);

        float[] lArray =
                { 0.00f, 0.05f, 0.09f, 0.10f, 0.12f
                        , 0.15f, 0.18f, 0.24f, 0.30f, 0.36f
                        , 0.43f, 0.50f, 0.60f, 0.72f, 0.85f
                        , 1.00f, 1.00f
                };

        //
        // Get the corresponding index for the specified argument/parameter.
        //
        int lIndex = (int)(lPower * 16.0);
        if (lIndex < 0)
        {
            lIndex = -lIndex;
        }
        else if (lIndex > 16)
        {
            lIndex = 16;
        }

        if (lPower < 0)
        {
            lScale = -lArray[lIndex];
        }
        else
        {
            lScale = lArray[lIndex];
        }

        return lScale;

    }

    //this function sets IO mode of a digital pin
    protected void pinMode(int port, DigitalChannelController.Mode mode){
        deviceInterfaceModule.setDigitalChannelMode(port,mode);
    }

    protected boolean digitalRead(int port){
        return(deviceInterfaceModule.getDigitalChannelState(port));
    }

    protected void digitalWrite(int port,boolean state){
        deviceInterfaceModule.setDigitalChannelState(port,state);
    }

    protected int analogRead(int port){
        return(deviceInterfaceModule.getAnalogInputValue(port));
    }

    protected void setPwmFrequency(int port,int frequency){
        int period = 10 ^6/frequency;
        deviceInterfaceModule.setPulseWidthPeriod(port,period);
    }


    //vaule is a float from 0 to 1 as the percentage of time output high
    protected void pwmWrite(int port, float vaule){
        int onTime = (int)(deviceInterfaceModule.getPulseWidthPeriod(port)*vaule);
        deviceInterfaceModule.setPulseWidthOutputTime(port,onTime);
    }

}