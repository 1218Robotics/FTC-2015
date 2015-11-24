package com.qualcomm.ftcrobotcontroller.opmodes.Varmint.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by jliu on 11/18/15.
 */
public class Arm {
    protected final int upperLimit = 50000;
    protected final int lowerLimit = 0;
    protected DcMotor armMotor;
    public Servo baseServo1;
    public Servo baseServo2;
    public boolean limitHit;
    limit armMotorLimit;

    //Thread armLimits = new Thread(new limit(),"ArmLimitThread");

    public Arm(DcMotor armMotor,Servo baseServo1,Servo baseServo2){
        this.armMotor = armMotor;
        this.baseServo1 = baseServo1;
        this.baseServo2 = baseServo2;
        this.armMotorLimit = new limit();
        this.armMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        this.armMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        //this.armMotorLimit.run();
    }
    public void rotateArmRaw(double position){
        baseServo1.setPosition(position);
        baseServo2.setPosition(1.0-position);
    }

    private boolean inLimitHigh(){
        return armMotor.getCurrentPosition() <= upperLimit;
    }

    private boolean inLimitLow(){
        return armMotor.getCurrentPosition() >= lowerLimit;
    }

    class limit implements Runnable{
        private boolean runing = true;
        public void run(){
            while(runing){
                if(inLimitHigh()&& armMotor.getPower()>0){
                    armMotor.setPower(0);
                    limitHit = true;
                }else if(inLimitLow()&& armMotor.getPower()<0){
                    armMotor.setPower(0);
                    limitHit = true;
                }else{
                    limitHit = false;
                }
            }
        }
        private boolean inLimitHigh(){
            return armMotor.getCurrentPosition() <= upperLimit;
        }

        private boolean inLimitLow(){
            return armMotor.getCurrentPosition() >= lowerLimit;
        }
    }

}
