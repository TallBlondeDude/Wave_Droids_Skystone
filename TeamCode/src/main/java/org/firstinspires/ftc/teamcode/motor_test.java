package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Servo Test", group = "Iterative Opmode")
public class motor_test extends LinearOpMode {
    // Declare OpMode members.
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor armMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Motor", "Foward");
        backLeftDrive.setPower(1);
        frontLeftDrive.setPower(1);
        frontRightDrive.setPower(1);
        backRightDrive.setPower(1);
        telemetry.addData("Motor", "Back");
        telemetry.update();
        sleep(5000);
        backLeftDrive.setPower(-1);
        frontLeftDrive.setPower(-1);
        frontRightDrive.setPower(-1);
        backRightDrive.setPower(-1);
        sleep(5000);
        telemetry.addData("Motor", "Off");
        telemetry.update();
        backLeftDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
        armMotor.setPower(1);
        sleep(2000);
        armMotor.setPower(0);
        sleep(2000);
    }


}

