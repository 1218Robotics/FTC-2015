package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by rgoudy on 10/13/15.
 */
public class DriveLine extends BaseBotHardware2 {
    @Override
    public void runOpMode() throws InterruptedException {
        leftDrive.driveInches(12,1);
        leftDrive.driveInches(12,1);
    }
}
