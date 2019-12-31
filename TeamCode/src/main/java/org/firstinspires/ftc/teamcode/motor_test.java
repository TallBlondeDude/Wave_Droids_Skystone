package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Wiring Helper", group = "Iterative Opmode")
public class motor_test extends LinearOpMode {
    // Declare OpMode members.
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor armMotor;

    public void runOpMode() throws InterruptedException {
        Moters Moters;
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));

        telemetry.addData("Motor","Front Left");
        Moters.frontLeftDrive.setPower(1);
        telemetry.update();
        sleep(1500);

        telemetry.addData("Motor","Back Left");
        telemetry.update();
        Moters.backLeftDrive.setPower(1);
        Moters.frontLeftDrive.setPower(0);
        sleep(1500);

        telemetry.addData("Motor","Front Right");
        Moters.backLeftDrive.setPower(0);
        Moters.frontRightDrive.setPower(1);
        telemetry.update();
        sleep(1500);

        telemetry.addData("Motor","Back Right");
        telemetry.update();
        Moters.frontRightDrive.setPower(0);
        Moters.backRightDrive.setPower(1);
        sleep(5000);
    }


}

