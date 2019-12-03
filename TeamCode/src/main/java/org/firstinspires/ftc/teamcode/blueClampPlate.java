package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@Autonomous(name = "Blue Grab Plate with telementary", group = "Linear Opmode")
@Disabled
public class blueClampPlate extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    private long servoRotationTime;
    private double distanceWallTooPlate;
    @Override
    public void runOpMode() throws InterruptedException {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));


        Moters.backLeftDrive.setTargetPosition(Moters.backLeftDrive.getCurrentPosition());
        Moters.frontLeftDrive.setTargetPosition(Moters.frontLeftDrive.getCurrentPosition());
        Moters.backRightDrive.setTargetPosition(Moters.backRightDrive.getCurrentPosition());
        Moters.frontRightDrive.setTargetPosition(Moters.frontRightDrive.getCurrentPosition());

        Moters.setAutoMode();
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"),
                hardwareMap.get(Servo.class, "rightPlateServo"), hardwareMap.get(Servo.class, "grabberServo"),
                hardwareMap.get(Servo.class, "inOutServo"), hardwareMap.get(Servo.class, "modeArmServo"));
        //distance in inches to wall

        servoRotationTime = 1000;
        distanceWallTooPlate = 20;
        double distanceToLine = 20;
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();

        Wheels.driveDistanceCrabwalk(9, .8);
        telemetry.addData("Task", "Going to plate");
        telemetry.update();
        sleep(4000);
        Wheels.driveDistanceFoward(distanceWallTooPlate, .8);
        sleep(4000);

        telemetry.addData("Task", "Closing Servos");
        telemetry.update();
        Servos.setPlateServoPos(0);
        sleep(servoRotationTime);

        Servos.setPlateServoPos(1);
        sleep(servoRotationTime);

        Wheels.driveDistanceFoward(-distanceWallTooPlate, 1);
        telemetry.addData("Task", "Back to wall");
        telemetry.update();
        sleep(4000);

        Servos.setPlateServoPos(0);
        sleep(servoRotationTime);
        Servos.setPlateServoPos(1);

        telemetry.addData("Task", "Opening Servos");
        telemetry.update();

        sleep(3000);
        Wheels.driveDistanceCrabwalk(distanceToLine, .6);
        telemetry.addData("Task", "Going to line");
        telemetry.update();
        sleep(4000);
        //pray that we end up over the line
        telemetry.addData("Task", "Stopping");
        telemetry.update();
        Moters.Halt();
    }
}

