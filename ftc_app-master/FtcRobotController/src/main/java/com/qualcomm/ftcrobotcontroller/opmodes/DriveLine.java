package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.HalfDrive;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by rgoudy on 10/13/15.
 */
public class DriveLine extends BaseBotHardware2{
    //HalfDrive leftDrive = new HalfDrive( hardwareMap.dcMotor.get("Front Left Drive Motor"), hardwareMap.dcMotor.get("Rear Right Drive Motor"), DcMotor.Direction.REVERSE);
    //HalfDrive rightDrive = new HalfDrive( hardwareMap.dcMotor.get("Front Right Drive Motor"), hardwareMap.dcMotor.get("Rear Right Drive Motor"), DcMotor.Direction.FORWARD);

    public DriveLine(){
        super();
    }
    @Override
    public void runOpMode() throws InterruptedException {
        leftDrive.driveInches(12,1);
        rightDrive.driveInches(12,1);
        while(leftDrive.front.isBusy()){
            waitOneFullHardwareCycle();
        }

    }
}
