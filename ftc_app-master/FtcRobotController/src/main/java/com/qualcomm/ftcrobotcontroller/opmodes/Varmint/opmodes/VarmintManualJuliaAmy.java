package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.opmodes;

import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by jliu on 12/3/15.
 */
public class VarmintManualJuliaAmy extends VarmintManual{
    protected static final double triggerThreshold = 0.5;
    protected static final double intakePower = 1;
    protected static final double beltPower = -1;
    protected static final double leftRampStartPos = 0;
    protected static final double leftRampIdlePos = .67;
    protected static final double leftRampReleasePos = 1;
    protected static final double rightRampStartPos = 0.22;
    protected static final double rightRampIdlePos = .67;
    protected static final double rightRampReleasePos = 1;
    protected void setup() throws InterruptedException{
        driveTrain.leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveTrain.rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        waitOneFullHardwareCycle();
        driveTrain.rightMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        driveTrain.leftMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        leftRampServo.setPosition(leftRampStartPos);
        rightRampServo.setPosition(rightRampStartPos);
    }
    protected  void mainLoop(){
        driveTrain.setDrivePower(-gamepad1.right_stick_y, -gamepad1.left_stick_y);
        if(triggered(gamepad2.left_trigger)){
            intakeMotor.setPower(intakePower);
        }else if(triggered(gamepad2.right_trigger)) {
            intakeMotor.setPower(-intakePower);
        }else{
            intakeMotor.setPower(0);
        };
        if(gamepad2.right_bumper){
            beltMotor.setPower(beltPower);
            leftRampServo.setPosition(leftRampReleasePos);
        }else if(gamepad2.left_bumper){
            beltMotor.setPower(-beltPower);
            rightRampServo.setPosition(rightRampReleasePos);
        }else{
            beltMotor.setPower(0);
            leftRampServo.setPosition(leftRampIdlePos);
            rightRampServo.setPosition(rightRampIdlePos);
        }
        updateTelemetry();
        telemetry.addData("Intake Power:",intakeMotor.getPower());
        telemetry.addData("Belt Power:",beltMotor.getPower());
    }

    protected boolean triggered(double input){
        return input > triggerThreshold;
    }
}
