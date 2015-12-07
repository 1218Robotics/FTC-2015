package com.qualcomm.ftcrobotcontroller.hardwareinterface;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
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
        int targetPosition = this.getCurrentPosition();
        if(power > 0){
            targetPosition+=counts;
        }else if(power < 0){
            targetPosition-=counts;
        }
        this.setTargetPosition(targetPosition);
        this.setPower(power);
        this.setTargetPosition(counts);
        this.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
    }
}
