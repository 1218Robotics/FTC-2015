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
        public BaseBotManual ()

        {
            //
            // Initialize base classes.
            //
            // All via self-construction.

            //
            // Initialize class members.
            //
            // All via self-construction.

        } // PushBotManual

        //--------------------------------------------------------------------------
        //
        // loop
        //
        /**
         * Implement a state machine that controls the robot during
         * manual-operation.  The state machine uses gamepad input to transition
         * between states.
         *
         * The system calls this member repeatedly while the OpMode is running.
         */
        @Override public void loop ()

        {
            //
            float leftDrivePower;
            leftDrivePower = scaleMotorPower(-gamepad1.right_stick_y);
            float rightDrivePower = scaleMotorPower(-gamepad1.right_stick_y);

            setLeftDrivePower(leftDrivePower);
            setRightDrivePower(rightDrivePower);

        }
        public void stop(){

        }
}
