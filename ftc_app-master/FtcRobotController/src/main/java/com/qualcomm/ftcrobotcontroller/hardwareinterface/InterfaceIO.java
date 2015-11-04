package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.util.Range;

/**
 * Note that this class is not has no built in protection against multiple thread accessing data at once
 * Created by jliu on 10/22/15.
 */
public class InterfaceIO {
    public static final boolean HIGH = true;
    public static final boolean LOW = false;
    public static final DigitalChannelController.Mode INPUT = DigitalChannelController.Mode.INPUT;
    public static final DigitalChannelController.Mode OUTPUT = DigitalChannelController.Mode.OUTPUT;
    public static final double ADCCountsToVolts = 5.0/1024;
    public static final double DACVoltsToCounts = 1024.0/4;
    public static final double WaveGenVoltsToCounts = 1024.0/8;
    public static final byte DAC = 0;
    public static final byte SINE = 1;
    public static final byte SQUARE = 2;
    public static final byte TRIANGLE = 3;


    protected DeviceInterfaceModule deviceInterfaceModule;

    protected int pwmPeriod[] = {100,100};
    protected byte analogOutputMode[] = {0,0};

    //constructor
    public InterfaceIO(DeviceInterfaceModule deviceInterfaceModule){
        this.deviceInterfaceModule = deviceInterfaceModule;
    }

    public void pinMode(int pin,DigitalChannelController.Mode mode){
        deviceInterfaceModule.setDigitalChannelMode(pin, mode);
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
        return deviceInterfaceModule.getAnalogInputValue(port)* ADCCountsToVolts;
    }

    public void setPwmFrequency(int port, int frequency){
        pwmPeriod[port] = 1000000/frequency;
        deviceInterfaceModule.setPulseWidthPeriod(port, pwmPeriod[port]);
    }
    
    public void setPwmPeriod(int port, int period){
        pwmPeriod[port] = period;
        deviceInterfaceModule.setPulseWidthPeriod(port, pwmPeriod[port]);
    }
    
    public void setPwmDutyCycle(int port, double dutyCycle){
        dutyCycle = Range.clip(dutyCycle,0,1);
        deviceInterfaceModule.setPulseWidthOutputTime(port, (int) (pwmPeriod[port] * dutyCycle));
    }

    //Digital? Every idiot can count to one
    //---Bob Widlar

    public void setAnalogOutputMode(int port,byte mode){
        if(HelperClass.inRange(mode,0,3)) {
            analogOutputMode[port] = mode;
            deviceInterfaceModule.setAnalogOutputMode(port, analogOutputMode[port]);
        }else{
            throw new IllegalArgumentException(String.format("Analog Output mode %d of port %d is not valid./n valid ranges are 0(DAC), 1(SINE), 2(SQUARE), 3(TRIANGLE)",mode,port));
        }
    }

    public void setAnalogOutputCounts(int port,int count){
        deviceInterfaceModule.setAnalogOutputVoltage(port, count);
    }

    public void setAnalogOutputVoltage(int port, double volts){
        int counts;
        switch (analogOutputMode[port]){
            case DAC:{
                counts = (int)Range.clip(volts*DACVoltsToCounts,-4.0,4.0);
                deviceInterfaceModule.setAnalogOutputVoltage(port,counts);
                break;
            }
            case SINE:
            case SQUARE:
            case TRIANGLE:{
                counts = (int)Range.clip(volts*WaveGenVoltsToCounts,0,8);
                deviceInterfaceModule.setAnalogOutputVoltage(port,counts);
            }
        }

    }

    //I only give negative feed back
    //---Random Opamp

    public void setAnalogOutputFrequency(int port, int frequency){
        frequency = (int)Range.clip(frequency,0,5000);
        deviceInterfaceModule.setAnalogOutputFrequency(port,frequency);
    }

}
