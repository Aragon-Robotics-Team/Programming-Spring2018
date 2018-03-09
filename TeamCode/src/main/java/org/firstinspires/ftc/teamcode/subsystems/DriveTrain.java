package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by chloelee on 3/8/18.
 */

public class DriveTrain {
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor topRight;
    DcMotor topLeft;

    public DriveTrain(DcMotor backLeft, DcMotor backRight, DcMotor topLeft, DcMotor topRight){
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.topLeft = topLeft;
        this.topRight = topRight;

        backLeft.setDirection(DcMotor.Direction.FORWARD);
        topLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        topRight.setDirection(DcMotor.Direction.REVERSE);

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        resetEncoders();
        stop();

    }

    public void arcadeDrive(double power, double turn){
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power - turn, -1, 1);

        topRight.setPower(rightPower);
        backRight.setPower(rightPower);
        backLeft.setPower(leftPower);
        topLeft.setPower(leftPower);


    }

    public void gamepadControls(Gamepad gamepad) {
        arcadeDrive(gamepad.left_stick_y, gamepad.right_stick_x);
    }

    public void resetEncoders(){
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void stop(){
        backLeft.setPower(0.0);
        backRight.setPower(0.0);
        topLeft.setPower(0.0);
        topRight.setPower(0.0);

    }
}
