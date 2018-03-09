package teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import subsystems.Drivetrain;
import subsystems.Intake;

/**
 * Created by maxyeh and vasilis on 3/8/18.
 */

@TeleOp(name="Teleop")
public class Teleop extends OpMode {
    private Drivetrain drivetrain;
    private Intake intake;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("frontLeft"), hardwareMap.dcMotor.get("frontRight"), hardwareMap.dcMotor.get("backLeft"), hardwareMap.dcMotor.get("backRight"));
        intake = new Intake(hardwareMap.dcMotor.get("lift"), hardwareMap.dcMotor.get("motor"), hardwareMap.servo.get("claw"));
    }

    @Override
    public void start() {
        drivetrain.stop();
        intake.stop();
    }

    @Override
    public void loop() {
        drivetrain.gamepadControls(gamepad1);
        intake.gamepadControls(gamepad1);
    }

    @Override
    public void stop() {
        drivetrain.stop();
        intake.stop();
    }
}
