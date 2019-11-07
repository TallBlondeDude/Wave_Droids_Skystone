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
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"), hardwareMap.get(Servo.class, "rightPlateServo"),
                hardwareMap.get(Servo.class, "grabberServo"),
                hardwareMap.get(Servo.class, "rotationHorizontal"),
                hardwareMap.get(Servo.class, "rotationVertical"));
        Moters.setAutoMode();

        //distance in inches to wall
        servoRotationTime = 1000;
        distanceWallTooPlate = 20;
        double distaceStrafeAtStart = 8;
        double distanceToLine = 20;
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Wheels.driveDistanceCrabwalk(distaceStrafeAtStart, .8);
        telemetry.addData("Task", "Strafing");
        telemetry.update();
        Wheels.driveDistanceFoward(-distanceWallTooPlate, .2);
        telemetry.addData("Task", "Going to plate");
        telemetry.update();
        sleep(5000);

        telemetry.addData("Task", "Closing Servos");
        telemetry.update();
        Servos.setPlateServoPos(0);
        sleep(servoRotationTime);
        Servos.setPlateServoPos(.5);

        Wheels.driveDistanceFoward(distanceWallTooPlate, .3);
        telemetry.addData("Task", "Back to wall");
        telemetry.update();

        Servos.setPlateServoPos(0);
        sleep(servoRotationTime);
        Servos.setPlateServoPos(.5);

        telemetry.addData("Task", "Opening Servos");
        telemetry.update();

        Wheels.driveDistanceCrabwalk(-distanceToLine, .2);
        telemetry.addData("Task", "Going to line");
        telemetry.update();

        telemetry.addData("Task", "Stopping");
        telemetry.update();
        Moters.Halt();
    }
}
