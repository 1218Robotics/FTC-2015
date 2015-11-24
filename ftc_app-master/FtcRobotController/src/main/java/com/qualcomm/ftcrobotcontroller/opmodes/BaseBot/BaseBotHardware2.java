package com.qualcomm.ftcrobotcontroller.opmodes.BaseBot;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by rgoudy on 10/13/15.
 */
@Deprecated
public class BaseBotHardware2 extends LinearOpMode {
    HalfDrive leftDrive = new HalfDrive(hardwareMap.dcMotor.get("Front Left Drive Motor"),
            hardwareMap.dcMotor.get("Rear Left Drive Motor"),
            DcMotor.Direction.FORWARD);
    HalfDrive rightDrive = new HalfDrive(hardwareMap.dcMotor.get("Front Right Drive Motor"),
            hardwareMap.dcMotor.get("Rear Right Drive Motor"),
            DcMotor.Direction.FORWARD);


    @Override
    public void runOpMode() throws InterruptedException {

    }

    protected void initRobot(){

    }
}