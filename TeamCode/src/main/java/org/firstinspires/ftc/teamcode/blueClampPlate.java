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

        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Wheels.Drive(3.4415 / 2, 0, 60);
        sleep(500);
        Moters.Halt();
        sleep(3000);
        Servos.setPlateServoPos(0);
        sleep(1000);
        Wheels.Drive((3 / 2 * 3.1415), 0, 100);
        sleep(2000);
        Servos.setPlateServoPos(0);
        sleep(1000);
        Wheels.Drive(0, 0, 60);
        sleep(2500);
        Moters.Halt();

    }


}

