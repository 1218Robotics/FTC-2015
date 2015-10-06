package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.util.Range;

/**
 * Created by jliu on 10/1/15.
 */
public class BaseBotManual extends BaseBotTelemetry{
        //--------------------------------------------------------------------------
        //
        // PushBotManual
        //
        /**
         * Construct the class.
         *
         * The system calls this member when the class is instantiated.
         */
        public BaseBotManual (){

        }



        @Override
        public void start(){
            //displayMotorPowers = true;
            displayServoPosition = true;
        }
        @Override
        public void loop ()

        {
            float leftDrivePower;
            leftDrivePower = scaleMotorPower(gamepad1.left_stick_y);
            float rightDrivePower = scaleMotorPower(gamepad1.right_stick_y);

            setLeftDrivePower(leftDrivePower);
            setRightDrivePower(rightDrivePower);

            servo1.setPosition(Range.scale(gamepad2.left_stick_y,-1,1,0,1));

            updateTelemetry();

        }
        public void stop(){

        }
}
