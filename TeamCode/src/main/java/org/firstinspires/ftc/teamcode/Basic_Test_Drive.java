package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Mechanum Two Joysick", group = "Iterative Opmode")
public class Basic_Test_Drive extends OpMode {
    // Declare OpMode members.
    public Controllers Gamepad;
    public Moters Moters;
    public Wheels Wheels;
    public void init() {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Gamepad = new Controllers(Gamepad, gamepad1);
        Wheels = new Wheels(Moters, telemetry);
    }

    @Override
    public void loop() {
        Gamepad.UpdateMovement();
        double polarAngle = Gamepad.polarAngle();
        double polarMagnitude = Gamepad.polarMagnitude();
        telemetry.addData("Direction in Radians", "Angle: " + polarAngle);
        telemetry.addData("Speed in Percentage", polarMagnitude);
        Wheels.Drive(polarAngle, gamepad1.right_stick_x, (float) polarMagnitude);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}

