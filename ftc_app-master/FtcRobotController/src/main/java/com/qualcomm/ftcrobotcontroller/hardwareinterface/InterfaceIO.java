package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DigitalChannelController;

/**
 * Created by jliu on 10/22/15.
 */
public class InterfaceIO {
    final boolean HIGH = true;
    final boolean LOW = false;
    final DigitalChannelController.Mode INPUT = DigitalChannelController.Mode.INPUT;
    final DigitalChannelController.Mode OUTPUT = DigitalChannelController.Mode.OUTPUT;

    protected DeviceInterfaceModule deviceInterfaceModule;

    public InterfaceIO(DeviceInterfaceModule deviceInterfaceModule){
        this.deviceInterfaceModule = deviceInterfaceModule;
    }

    public void pinMode(int pin,DigitalChannelController.Mode mode){
        deviceInterfaceModule.setDigitalChannelMode(pin,mode);
    }

    public void digitalWrite(int pin, boolean state){
        deviceInterfaceModule.setDigitalChannelState(pin,state);
    }

    public boolean digitalRead(int pin){
        return(deviceInterfaceModule.getDigitalChannelState(pin));
    }

}
