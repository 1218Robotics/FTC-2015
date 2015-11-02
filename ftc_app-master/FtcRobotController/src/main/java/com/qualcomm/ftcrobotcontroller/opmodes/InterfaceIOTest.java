package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by jliu on 11/2/15.
 */
public class InterfaceIOTest extends BaseBot2Manual {
    @Override
    protected void setup() {
        interfaceIO.pinMode(0, DigitalChannelController.Mode.INPUT);
        interfaceIO.pinMode(1, DigitalChannelController.Mode.OUTPUT);
        interfaceIO.setPwmFrequency(0, 1000);
        interfaceIO.setPwmDutyCycle(0,0.5);
    }

    @Override
    protected void mainLoop() {
        interfaceIO.digitalWrite(1,interfaceIO.digitalRead(0));
        interfaceIO.setPwmDutyCycle(0,interfaceIO.analogReadVolts(0)/5);
        if(interfaceIO.digitalRead(0)){
            leftDriveMotor.setPower(0.5);
        }else{
            leftDriveMotor.setPower(0);
        }
        telemetry.addData("A0 Counts:",interfaceIO.analogRead(0));
        telemetry.addData("A0 Volts:", interfaceIO.analogReadVolts(0));
    }
}
