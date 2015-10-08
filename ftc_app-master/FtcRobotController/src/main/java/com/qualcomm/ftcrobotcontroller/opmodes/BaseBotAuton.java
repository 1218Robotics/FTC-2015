package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by rgoudy on 10/8/15.
 */
public class BaseBotAuton extends BaseBotLinearHardware {

    @Override
    public void runOpMode() throws InterruptedException {

        initRobot();

        waitForStart();

        rearLeftDriveMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rearLeftDriveMotor.setPower(1.0);
        rearLeftDriveMotor.setTargetPosition(1120);
        rearLeftDriveMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        while(opModeIsActive()){
            telemetry.addData("encoder:",rearLeftDriveMotor.getCurrentPosition());
            waitOneFullHardwareCycle();
        }

    }

}
