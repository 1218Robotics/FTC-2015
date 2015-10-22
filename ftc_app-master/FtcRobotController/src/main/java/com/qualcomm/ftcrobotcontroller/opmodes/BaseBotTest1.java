package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by jliu on 10/20/15.
 */
public class BaseBotTest1 extends BaseBot2Hardware {
    public void runOpMode() throws InterruptedException{
        leftDriveMotor.setPower(1);
        rightDriveMotor.setPower(1);
        while (true){
            waitOneFullHardwareCycle();
        }
    }
}
