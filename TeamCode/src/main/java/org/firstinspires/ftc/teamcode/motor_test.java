package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;

@TeleOp(name = "Mechanum Two Joysick", group = "Iterative Opmode")
public class motor_test extends OpMode {
    DcMotor backLeftDrive;
    DcMotor frontLeftDrive;
    DcMotor frontRightDrive;
    DcMotor backRightDrive;

    @Override
    public void init() {
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        frontLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        frontLeftDrive.setPower(.5);
        frontRightDrive.setPower(.5);
        backRightDrive.setPower(.5);
        backLeftDrive.setPower(.5);

    }
}
