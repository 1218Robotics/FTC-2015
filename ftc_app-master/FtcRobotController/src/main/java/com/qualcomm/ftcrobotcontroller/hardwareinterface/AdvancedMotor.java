package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by jliu on 11/12/15.
 */
public class AdvancedMotor extends DcMotor{
    public AdvancedMotor(DcMotorController controller, int portNumber){
        super(controller, portNumber);
    }

    public AdvancedMotor(DcMotor dcMotor){
        super(dcMotor.getController(),dcMotor.getPortNumber());
    }

    public void driveCounts(int counts, double power) {
        this.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        this.setPower(1.0);
        this.setTargetPosition(counts);
        this.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
    }
}
