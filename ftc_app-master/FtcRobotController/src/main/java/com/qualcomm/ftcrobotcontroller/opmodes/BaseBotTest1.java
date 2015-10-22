package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DigitalChannelController;

/**
 * Created by jliu on 10/20/15.
 */
public class BaseBotTest1 extends BaseBot2Hardware {
    public void runOpMode() throws InterruptedException{
        initRobot();
        deviceInterfaceModule.setDigitalChannelMode(0, DigitalChannelController.Mode.OUTPUT);
        deviceInterfaceModule.setDigitalChannelState(0,false);
        //leftDriveMotor.setPower(1);
        //rightDriveMotor.setPower(1);
        while (true){
            waitOneFullHardwareCycle();
            telemetry.addData("Red:", colorSensor.red());
            telemetry.addData("Blue:", colorSensor.blue());
            telemetry.addData("Green:",colorSensor.green());
        }
    }
}
