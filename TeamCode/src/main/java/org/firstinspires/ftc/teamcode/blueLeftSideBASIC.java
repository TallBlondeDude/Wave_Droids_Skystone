package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@Autonomous(name = "BASIC Left Side (Forward, then Over)", group = "Iterative Opmode")
public class blueLeftSideBASIC extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;
    @Override
    public void runOpMode() throws InterruptedException {
        // Initalize the motors and wheels
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));
        Wheels = new Wheels(Moters, telemetry);

        // sets the direction of the motors and makes the motors stop when it has no power
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
        // robot goes forward
        Wheels.Drive(1.7, 0, 60);
        sleep(600);
        // robot stops
        Moters.Halt();
        sleep(750);
        // robot turns
        Wheels.Turn(-.6);
        sleep(520);
        // robot stops
        Moters.Halt();
        sleep(2000);
        // robot goes forward
        Wheels.Drive(.5 * 3.1415, 0, -70);
        sleep(400);

        // robot stops
        Moters.Halt();

    }


}

