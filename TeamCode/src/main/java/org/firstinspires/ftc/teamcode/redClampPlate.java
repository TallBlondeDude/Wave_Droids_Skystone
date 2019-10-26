package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;
import org.firstinspires.ftc.teamcode.Robot_Parts.Servos;
import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

@Autonomous(name = "Red Grab Plate with telementary", group = "Linear Opmode")
public class redClampPlate extends LinearOpMode {
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
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"), hardwareMap.get(Servo.class, "rightPlateServo"));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Moters.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //distance in inches to wall
        servoRotationTime = 1000;
        distanceWallTooPlate = 20;
        double distanceToLine = 20;
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();

        Wheels.driveDistanceFoward(-distanceWallTooPlate, .2);
        telemetry.addData("Task", "Going to plate");
        telemetry.update();
        sleep(5000);

        telemetry.addData("Task", "Closing Servos");
        telemetry.update();
        Servos.setPlateServoPos(0);
        sleep(servoRotationTime);
        Servos.setPlateServoPos(.5);
        sleep(100);
        Wheels.driveDistanceFoward(distanceWallTooPlate, .3);
        telemetry.addData("Task", "Back to wall");
        telemetry.update();

        sleep(5000);
        Servos.setPlateServoPos(0);
        sleep(servoRotationTime);
        Servos.setPlateServoPos(.5);

        telemetry.addData("Task", "Opening Servos");
        telemetry.update();

        sleep(3000);
        Wheels.driveDistanceCrabwalk(-distanceToLine, .2);
        telemetry.addData("Task", "Going to line");
        telemetry.update();

        //pray that we end up over the line
        sleep(3500);
        telemetry.addData("Task", "Stopping");
        telemetry.update();
        Moters.Halt();
    }
}
