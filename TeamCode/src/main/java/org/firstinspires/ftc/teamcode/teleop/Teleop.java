package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

/**
 * Created by chloelee on 3/8/18.
 */

public class Teleop extends OpMode {
    DriveTrain driveTrain;

    @Override
    public void init() {
        driveTrain = new DriveTrain(hardwareMap.dcMotor.get("backLeft"), hardwareMap.dcMotor.get("backRight"), hardwareMap.dcMotor.get("topLeft"), hardwareMap.dcMotor.get("topRight"));
    }

    @Override
    public void start() {
        driveTrain.stop();
    }

    @Override
    public void loop() {
        driveTrain.gamepadControls(gamepad1);
    }

    @Override
    public void stop() {
        driveTrain.stop();
    }
}
