package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

/**
 * Created by jliu on 10/22/15.
 */
public abstract class VarmintAuton extends VarmintHardware {
    public void runOpMode() throws InterruptedException{
        initRobot();
        waitForStart();
        auton();
        stopRobot();
    }

    abstract void auton() throws InterruptedException;
}
