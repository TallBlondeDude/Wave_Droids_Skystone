package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.Arm;
import org.firstinspires.ftc.teamcode.Robot_Parts.Controllers;
import org.firstinspires.ftc.teamcode.Robot_Parts.Intake;
import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;
import org.firstinspires.ftc.teamcode.Robot_Parts.Servos;
import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

@TeleOp(name = "outreach", group = "Iterative Opmode")
public class outreach extends OpMode {
    // Declare OpMode members.
    public Controllers Gamepad;
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    public Intake Intake;
    Arm Arm;

    //  Servo rightPlateServo;
    //  Servo leftPlateServo;
    //  Webcam Camera;
    public void init() {
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


        Moters.setTeleMode();
    }

    @Override
    public void loop() {

        //   telemetry.addData("Skystone", Camera.findSkystone());
        double polarAngle = Gamepad.polarAngle();
        double polarMagnitude = Gamepad.polarMagnitude();
        telemetry.addData("Direction in Radians", "Angle: " + polarAngle);
        telemetry.addData("Speed in Percentage", polarMagnitude);
        Gamepad.UpdateMovement();
        if(gamepad1.a){
            Servos.setPlateServoPos(1);
        }
        else if(gamepad1.b){
            Servos.setPlateServoPos(0);
        }
        Wheels.Drive(polarAngle, gamepad1.right_stick_x, (float) (polarMagnitude * .4));
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        telemetry.addData("Task", "Halting");
        Moters.Halt();
        Servos.Halt();
    }

}

