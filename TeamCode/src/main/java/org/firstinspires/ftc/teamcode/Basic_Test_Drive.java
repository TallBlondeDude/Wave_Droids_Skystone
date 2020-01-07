package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Mechanum Two Joysick", group = "Iterative Opmode")
public class Basic_Test_Drive extends OpMode {
    // Declare OpMode members.
    public Controllers Gamepad;
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    public Intake Intake;
    int slowEffect;

    Arm Arm;
    //  Servo rightPlateServo;
    //  Servo leftPlateServo;
    // Webcam Camera;
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
        /*Camera = new Webcam(hardwareMap.get(WebcamName.class, "Webcam 1"), telemetry,
                (hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId",
                        "id", hardwareMap.appContext.getPackageName()))); */
        // Set the motors in teleop mode for encoders and direction
        Moters.setTeleMode();

    }

    @Override
    public void loop() {
       // telemetry.addData("Location", Camera.findSkystone());
        //   telemetry.addData("Skystone", Camera.findSkystone());
        // variables being assigned to the gamepad
        double polarAngle = Gamepad.polarAngle();
        double polarMagnitude = Gamepad.polarMagnitude();
        // telemetry showing direction, angle, speed, and polar magnitude
        telemetry.addData("Direction in Radians", "Angle: " + polarAngle);
        telemetry.addData("Speed in Percentage", polarMagnitude);
        // function with the gamepad's controls that update
        Gamepad.UpdateMovement();
        // if a button is pressed, move the plate servos downward, grabbing the plate
        if(gamepad1.a){
            Servos.setPlateServoPos(1);
        }
        // if gamepad b is pressed, move the plate servos upward, releasing the plate
        else if(gamepad1.b){
            Servos.setPlateServoPos(0);
        }
        // if left or right bumper is pressed, increase the slow effect of slowing down the motors, otherwise have a small slow effect
        if (gamepad1.left_bumper || gamepad1.right_bumper){
            slowEffect = 4;
        }
        else{
            slowEffect = 1;
        }
        // setting the slow effect to the wheels
        Wheels.Drive(polarAngle, gamepad1.right_stick_x/slowEffect, (float) polarMagnitude/slowEffect);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        // stop the motors and servos and show the telemetry
        telemetry.addData("Task", "Halting");
        Moters.Halt();
        Servos.Halt();
    }

}

