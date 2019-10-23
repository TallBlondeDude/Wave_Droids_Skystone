package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@Autonomous(name = "Blue Grab Plate", group = "Iterative Opmode")
public class blueClampPlate extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    private double distanceWallTooPlate;
    @Override
    public void runOpMode() throws InterruptedException {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Servos = new Servos(hardwareMap.get(Servo.class, ""), hardwareMap.get(Servo.class, ""));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //distance in inches to wall

        distanceWallTooPlate = 40;
        double distanceToLine = 40;
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Wheels.driveDistanceFoward(distanceWallTooPlate, .6);
        sleep(5000);
        Servos.setPlateServoPos(0);
        sleep(1000);
        Wheels.driveDistanceFoward(-distanceWallTooPlate, .8);
        sleep(2000);
        Servos.setPlateServoPos(0);
        sleep(1000);
        Wheels.driveDistanceCrabwalk(distanceToLine, .6)
        //pray that we end up over the line <3 mabey get an encoder function set up if we have time
        sleep(2500);
        Moters.Halt();

    }


}

