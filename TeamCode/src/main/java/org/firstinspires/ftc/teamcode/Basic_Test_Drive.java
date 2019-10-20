package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Mechanum Two Joysick", group = "Iterative Opmode")
public class Basic_Test_Drive extends OpMode {
    // Declare OpMode members.
    public Controllers Gamepad;
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    public void init() {
        // get Moters, pass them, and set the direction so that they can run
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        // init stuff and pass it to their respective classes
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo")
                , hardwareMap.get(Servo.class, "rightPlateServo"));
        Gamepad = new Controllers(Gamepad, gamepad1);
        Wheels = new Wheels(Moters, telemetry);
    }

    @Override
    public void loop() {
        //tests for buttons pressed
        Gamepad.UpdateMovement();
        //get direction and power
        double polarAngle = Gamepad.polarAngle();
        double polarMagnitude = Gamepad.polarMagnitude();
        // debugging readout
        telemetry.addData("Direction in Radians", "Angle: " + polarAngle);
        telemetry.addData("Speed in Percentage", polarMagnitude);
        //drive, right stick x is used for the raw turning value.
        Wheels.Drive(polarAngle, gamepad1.right_stick_x, (float) polarMagnitude);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}

