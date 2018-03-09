package subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by maxyeh on 3/8/18.
 */

public class Intake {
    private DcMotor lift;
    private DcMotor motor;
    private Servo claw;

    private final double clawOpen = 1.0;
    private final double clawClose = 0;
    private final double LIFT_POWER_UP = 1.0;
    private final double LIFT_POWER_DOWN = -0.2;

    public Intake(DcMotor lift, DcMotor motor, Servo claw) {
        this.lift = lift;
        this.motor = motor;
        this.claw = claw;

        motor.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.FORWARD);
        stop();
    }

    public void gamepadControls(Gamepad gamepad) {
        if(gamepad.left_trigger > 0) {
            lift.setPower(LIFT_POWER_UP);
        } else if (gamepad.right_trigger > 0) {
            lift.setPower(LIFT_POWER_DOWN);
        } else {
            lift.setPower(0.0);
        }

        if(gamepad.left_bumper) {
            motor.setPower(1.0);
        } else if (gamepad.right_bumper) {
            motor.setPower(-1.0);
        } else {
            motor.setPower(0.0);
        }

        if(gamepad.x) {
            claw.setPosition(clawOpen);
        } else if (gamepad.a) {
            claw.setPosition(clawClose);
        }
    }

    public void stop() {
        lift.setPower(0.0);
        motor.setPower(0.0);
    }
}
