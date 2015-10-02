package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by jliu on 9/30/15.
 */
public class BaseBotHardware extends OpMode {
    protected DcMotorController leftDriveMotorController;
    protected DcMotorController rightDriveMotorController;
    protected DeviceInterfaceModule deviceInterfaceModule;
    protected ServoController servoController;

    protected DcMotor frontLeftDriveMotor;
    protected DcMotor rearLeftDriveMotor;
    protected DcMotor frontRightDriveMotor;
    protected DcMotor rearRightDriveMotor;

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

        frontRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
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

    } // scale_motor_power
}
