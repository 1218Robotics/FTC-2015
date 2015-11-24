package com.qualcomm.ftcrobotcontroller.opmodes.FTCDemo;

import com.qualcomm.ftcrobotcontroller.hardwareinterface.InterfaceIO;
import com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes.VarmintManual;
import com.qualcomm.robotcore.hardware.DigitalChannelController;

/**
 * Created by jliu on 11/2/15.
 */
public class InterfaceIOTest extends VarmintManual {
    @Override
    protected void setup() {
        interfaceIO.pinMode(0, DigitalChannelController.Mode.INPUT);
        interfaceIO.pinMode(1, DigitalChannelController.Mode.OUTPUT);
        interfaceIO.setPwmFrequency(0, 1000);
        interfaceIO.setPwmDutyCycle(0, 0.5);
        interfaceIO.setAnalogOutputMode(0, InterfaceIO.TRIANGLE);
        interfaceIO.setAnalogOutputFrequency(0,1000);
    }

    @Override
    protected void mainLoop() {
        interfaceIO.digitalWrite(1,interfaceIO.digitalRead(0));
        interfaceIO.setPwmDutyCycle(0,interfaceIO.analogReadVolts(0)/5);
        interfaceIO.setAnalogOutputCounts(0,1000);
        if(interfaceIO.digitalRead(0)){
            leftDriveMotor.setPower(0.5);
        }else{
            leftDriveMotor.setPower(0);
        }
        telemetry.addData("A0 Counts:",interfaceIO.analogRead(0));
        telemetry.addData("A0 Volts:", interfaceIO.analogReadVolts(0));
    }
}
