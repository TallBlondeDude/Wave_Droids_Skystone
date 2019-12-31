package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;
import org.firstinspires.ftc.teamcode.Robot_Parts.Servos;
import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

@Autonomous(name = "Blue Plate basic Encoders", group = "Linear Opmode")
public class blueClampPlateRawEncoders extends LinearOpMode {
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

        Moters.setAutoMode();
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"),
                hardwareMap.get(Servo.class, "rightPlateServo"), hardwareMap.get(Servo.class, "grabberServo"),
                hardwareMap.get(Servo.class, "inOutServo"), hardwareMap.get(Servo.class, "modeArmServo"));
        servoRotationTime = 1000;
        distanceWallTooPlate = 13;
        int open = 0;
        double distanceToLine = 27;
        int closed = 1;
        Wheels = new Wheels(Moters, telemetry);
        Moters.setAutoMode();
        waitForStart();
        Moters.setWheelPower(.8);
        Servos.setPlateServoPos(open);
        Moters.setWheelPowerCrabwalk(.8);
        Moters.setTargetPositionWheelsCrabwalk((int) (org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch * 16));
        telemetry.addData("Task", "Crabwalking");
        telemetry.update();
        sleep(2000);

        Moters.setWheelPower(.3);
        Moters.setTargetPositionWheels((int) (2 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch * -distanceWallTooPlate));
        telemetry.addData("Task", "Going to plate");
        telemetry.update();
        sleep(3500);

        Moters.setWheelPower(.1);
        Moters.setTargetPositionWheels((int) (2 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch * -3));
        sleep(1500);

        Moters.setWheelPower(1);
        Servos.setPlateServoPos(closed);
        telemetry.addData("Task", "Closing Servos");
        telemetry.update();
        sleep(servoRotationTime);

        Moters.setWheelPower(.6);
        Moters.setTargetPositionWheels((int) (3.5 * distanceWallTooPlate * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Back to wall");
        telemetry.update();
        sleep(4000);

        Servos.setPlateServoPos(open);
        telemetry.addData("Task", "Opening Servos");
        telemetry.update();
        sleep(servoRotationTime);

        Moters.setWheelPower(1);
        // start according to line pattern
        Moters.setTargetPositionWheels((int) (4 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Correcting for Error");
        sleep(1000);

        Moters.setWheelPowerCrabwalk(.5);
        Moters.setTargetPositionWheelsCrabwalk((int) (-24.5 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        sleep(2000);

        Moters.setTargetPositionWheels((int) (-10 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Back to wall");
        telemetry.update();
        sleep(3500);

        Moters.setWheelPowerCrabwalk(.8);
        Moters.setTargetPositionWheelsCrabwalk((int) (20 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Pushing it over");
        telemetry.update();
        sleep(2000);

        Moters.setTargetPositionWheels((int) (-19 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Back to wall");
        telemetry.update();
        sleep(3500);

        Moters.setWheelPowerCrabwalk(.5);
        Moters.setTargetPositionWheelsCrabwalk((int) (-31 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "moving to line");
        telemetry.update();
        sleep(3000);

        //pray that we end up over the line
        telemetry.addData("Task", "Stopping");
        telemetry.update();
        Moters.Halt();
    }
}

