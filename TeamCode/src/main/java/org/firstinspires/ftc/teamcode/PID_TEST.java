package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;
import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

@Autonomous(name = "PID_TEST", group = "Iterative Opmode")
public class PID_TEST extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;

    @Override
    public void runOpMode() throws InterruptedException {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "armMotor"), hardwareMap.get(DcMotor.class, "leftIntake"), hardwareMap.get(DcMotor.class, "rightIntake"));

        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        float backLeftPower = 1;
        float backRightPower = 1;
        float frontLeftPower = 1;
        float frontRightPower = 1;
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Moters.backLeftDrive.setPower(backLeftPower);
        Moters.frontRightDrive.setPower(frontRightPower);
        Moters.backRightDrive.setPower(-backRightPower);
        Moters.frontLeftDrive.setPower(-frontLeftPower);

        sleep(600);

        Moters.backLeftDrive.setPower(backLeftPower);
        Moters.frontRightDrive.setPower(frontRightPower);
        Moters.backRightDrive.setPower(backRightPower);
        Moters.frontLeftDrive.setPower(frontLeftPower);

        sleep(750);
        Moters.Halt();

    }


}

