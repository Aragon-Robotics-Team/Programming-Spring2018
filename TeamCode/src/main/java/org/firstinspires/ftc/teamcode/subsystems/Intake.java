package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by chloelee on 3/8/18.
 */

public class Intake {
    DcMotor lift;
    DcMotor spin;
    Servo claw;

    public Intake(DcMotor lift, DcMotor spin, Servo claw){
        this.lift = lift;
        this.spin = spin;
        this.claw = claw;
    }

    public void intakePower(double servoPosition, double powerLift, double powerSpin) {
        powerLift = Range.clip(powerLift, -1, 1);
        powerSpin = Range.clip(powerSpin, -1, 1);
        //add servo?

        lift.setPower(powerLift);
        spin.setPower(powerSpin);
        claw.setPosition(servoPosition);

        resetEncoders();
        stop();

    }

    public void resetEncoders() {
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void stop(){
        claw.setPosition(0.0);
        lift.setPower(0.0);
        spin.setPower(0.0);
    }

    public void gamepadControls(Gamepad gamepad){

        if(gamepad.x) {
            intakePower(0, 1, 1);
        }

    }
}
