package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by jliu on 10/23/15.
 */
public class BaseBot2IicTest extends BaseBot2Auton{
    @Override
    void auton() throws InterruptedException {
        while (opModeIsActive()) {
            deviceInterfaceModule.enableI2cReadMode(0, 0x29, 0x12, 1);
            deviceInterfaceModule.setI2cPortActionFlag(0);
            while (deviceInterfaceModule.isI2cPortActionFlagSet(0)) {
                waitOneFullHardwareCycle();
            }
            byte buffer[] = deviceInterfaceModule.getCopyOfReadBuffer(0);
            telemetry.addData("Device ID 3", buffer[3]);
            telemetry.addData("Device ID 4", buffer[4]);
            telemetry.addData("Device ID 5", buffer[5]);
            waitOneFullHardwareCycle();
        }
    }
}
