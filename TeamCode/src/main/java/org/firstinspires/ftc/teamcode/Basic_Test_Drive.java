package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Mechanum Two Joysick", group = "Iterative Opmode")
public class Basic_Test_Drive extends OpMode {
    // Declare OpMode members.
    public Controllers Gamepad;
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    Servo rightPlateServo;
    Servo leftPlateServo;
    Webcam Camera;
    public void init() {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"), hardwareMap.get(Servo.class, "rightPlateServo"));
        Wheels = new Wheels(Moters, telemetry);
        Gamepad = new Controllers(Gamepad, gamepad1, Wheels, Servos);
    }


    @Override
    public void loop() {
        if (gamepad1.a) {
            rightPlateServo.setPosition(0);
            leftPlateServo.setPosition(1);
        }
        if (gamepad1.b) {
            leftPlateServo.setPosition(.5);
            rightPlateServo.setPosition(.5);
        }
        telemetry.addData("Skystone", Camera.findSkystone());
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
        telemetry.addData("Task", "Halting");
        Moters.Halt();
        Servos.Halt();
    }

}

