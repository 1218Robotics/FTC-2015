package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.robocol.Telemetry;

/**
 * Created by jliu on 10/1/15.
 */
@Deprecated
public class BaseBotTelemetry extends BaseBotHardware {
    protected boolean displayMotorPowers = false;
    protected boolean displayServoPosition = false;

    protected void updateTelemetry(){
        if(displayMotorPowers) {
            telemetry.addData("Front Left Power:", frontLeftDriveMotor.getPower());
            telemetry.addData("Rear Left Power", rearLeftDriveMotor.getPower());
            telemetry.addData("Front Right Power:", frontRightDriveMotor.getPower());
            telemetry.addData("Rear Right Power:", rearRightDriveMotor.getPower());
        }
        else if(displayServoPosition){
            telemetry.addData("Servo 1:",servo1.getPosition());
        }
    }

}
