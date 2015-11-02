package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DigitalChannelController;

/**
 * Created by jliu on 10/22/15.
 */
public class InterfaceIO {
    public static final boolean HIGH = true;
    public static final boolean LOW = false;
    public static final DigitalChannelController.Mode INPUT = DigitalChannelController.Mode.INPUT;
    public static final DigitalChannelController.Mode OUTPUT = DigitalChannelController.Mode.OUTPUT;
    public static final double countsToVolts = 5.0/1024;

    protected DeviceInterfaceModule deviceInterfaceModule;

    protected int pwmPeriod[] = {100,100};

    public InterfaceIO(DeviceInterfaceModule deviceInterfaceModule){
        this.deviceInterfaceModule = deviceInterfaceModule;
    }

    public void pinMode(int pin,DigitalChannelController.Mode mode){
        deviceInterfaceModule.setDigitalChannelMode(pin,mode);
    }

    public void digitalWrite(int pin, boolean state){
        deviceInterfaceModule.setDigitalChannelState(pin, state);
    }

    public boolean digitalRead(int pin){
        return(deviceInterfaceModule.getDigitalChannelState(pin));
    }

    public int analogRead(int port){
        return deviceInterfaceModule.getAnalogInputValue(port);
    }

    public double analogReadVolts(int port){
        return deviceInterfaceModule.getAnalogInputValue(port)*countsToVolts;
    }

    public void setPwmFrequency(int port, int frequency){
        pwmPeriod[port] = 1000000/frequency;
        deviceInterfaceModule.setPulseWidthPeriod(port,pwmPeriod[port]);
    }
    
    public void setPwmPeriod(int port, int period){
        pwmPeriod[port] = period;
        deviceInterfaceModule.setPulseWidthPeriod(port,pwmPeriod[port]);
    }
    
    public void setPwmDutyCycle(int port, double dutyCycle){
        deviceInterfaceModule.setPulseWidthOutputTime(port,(int)(pwmPeriod[port]*dutyCycle));
    }

}
