package subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by maxyeh on 3/8/18.
 */

public class Drivetrain {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    public Drivetrain(DcMotor flm, DcMotor frm, DcMotor blm, DcMotor brm) {
        this.frontLeftMotor = flm;
        this.frontRightMotor = frm;
        this.backLeftMotor = blm;
        this.backRightMotor = brm;

        this.frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        this.frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        this.backRightMotor.setDirection(DcMotor.Direction.REVERSE);
        stop();
    }

    public void gamepadControls(Gamepad gamepad) {
        arcadeDrive(Math.pow(gamepad.left_stick_y, 5), Math.pow(gamepad.left_stick_x, 5));
    }

    public void arcadeDrive(double power, double turn) {
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power - turn, -1, 1);

        frontLeftMotor.setPower(leftPower);
        backLeftMotor.setPower(leftPower);
        frontRightMotor.setPower(rightPower);
        backRightMotor.setPower(rightPower);
    }

    public void stop() {
        frontLeftMotor.setPower(0.0);
        frontRightMotor.setPower(0.0);
        backLeftMotor.setPower(0.0);
        backRightMotor.setPower(0.0);
    }
}
