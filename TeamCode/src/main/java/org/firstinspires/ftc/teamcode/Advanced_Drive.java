package org.firstinspires.ftc.teamcode;

import android.graphics.drawable.GradientDrawable;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Advanced Drive", group = "Iterative Opmode")
public class Advanced_Drive extends OpMode {
    // Declare OpMode members.
    public Controllers Gamepad;
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    Arm Arm;
    float lastGyroCheck;
    Gyroscope Gyro;
    private Intake Intake;
    //  Servo rightPlateServo;
    //  Servo leftPlateServo;
    //  Webcam Camera;
    public void init() {
        // Initalize the motors, servos, arm, wheels, intake, and controller
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));


        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"),
                hardwareMap.get(Servo.class, "rightPlateServo"), hardwareMap.get(Servo.class, "grabberServo"),
                hardwareMap.get(Servo.class, "inOutServo"), hardwareMap.get(Servo.class, "modeArmServo"));
        Arm = new Arm(Moters, telemetry, Servos);

        Wheels = new Wheels(Moters, telemetry);
        Intake = new Intake(Moters, telemetry);
        Gamepad = new Controllers(Gamepad, gamepad1, Wheels, Servos, gamepad2, Arm, telemetry, Moters, Intake);
        // set the wheels to go to the position 10,000
        Moters.setTargetPositionWheels(10000);
        // Set the motors into teleop mode for encoders and direction
        Moters.setTeleMode();
    }

    @Override
    public void loop() {
        // Set the power of the motors to 1
        Moters.backRightDrive.setPower(1);
        Moters.frontRightDrive.setPower(1);
        Moters.frontLeftDrive.setPower(1);
        Moters.backLeftDrive.setPower(1);
        // telemetry to get the encoder values
        telemetry.addData("Front Left Encoder", Moters.frontLeftDrive.getCurrentPosition());
        telemetry.addData("Back Left Encoder", Moters.backLeftDrive.getCurrentPosition());
        telemetry.addData("Front Right Encoder", Moters.frontRightDrive.getCurrentPosition());
        telemetry.addData("Back Right Encoder", Moters.backRightDrive.getCurrentPosition());
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        // stop the motors and show the telemetry
        telemetry.addData("Task", "Halting");
        Moters.Halt();
        //    Servos.Halt();
    }

}