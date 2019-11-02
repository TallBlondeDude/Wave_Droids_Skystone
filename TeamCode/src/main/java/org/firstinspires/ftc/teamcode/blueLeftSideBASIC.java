package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@Autonomous(name = "BASIC Left Side (Forward, then Over)", group = "Iterative Opmode")
public class blueLeftSideBASIC extends LinearOpMode {
    // Declare OpMode members.
    public Controllers Gamepad;
    public Moters Moters;
    public Wheels Wheels;

    @Override
    public void runOpMode() throws InterruptedException {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Wheels.Drive(1.7, 0, 60);
        sleep(700);
        Moters.Halt();
        sleep(750);
        Wheels.Turn(-.6);
        sleep(350);
        Moters.Halt();
        sleep(2000);
        Wheels.Drive(0
                , 0, 100);
        sleep(1200);

        Moters.Halt();



    }


}

