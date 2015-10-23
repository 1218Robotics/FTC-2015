package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by jliu on 10/22/15.
 */
public abstract class BaseBot2Auton extends BaseBot2Hardware {
    public void runOpMode() throws InterruptedException{
        initRobot();
        waitForStart();
        auton();
        stopRobot();
    }

    abstract void auton() throws InterruptedException;
}
