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
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"), hardwareMap.get(DcMotor.class, "armMotor"));

        Moters.setAutoMode();

        Servo rightServo = hardwareMap.get(Servo.class, "rightPlateServo");
        Servo leftServo = hardwareMap.get(Servo.class, "leftPlateServo");

        servoRotationTime = 1000;
        distanceWallTooPlate = 17;
        double distanceToLine = 27;
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Moters.setWheelPower(.8);

        Moters.setTargetPositionWheelsCrabwalk((int) (Wheels.encodersPerInch * 16));
        telemetry.addData("Task", "Going to plate");
        telemetry.update();
        sleep(2000);
        Moters.setWheelPower(.3);
        Moters.setTargetPositionWheels((int) (2 * Wheels.encodersPerInch * -distanceWallTooPlate));
        sleep(4500);
        Moters.setWheelPower(.1);
        Moters.setTargetPositionWheels((int) (2 * Wheels.encodersPerInch * -3));
        telemetry.addData("Task", "Closing Servos");
        telemetry.update();
        sleep(1500);
        Moters.setWheelPower(1);
        rightServo.setPosition(1);
        leftServo.setPosition(0);

        sleep(servoRotationTime);
        Moters.setTargetPositionWheels((int) (4 * distanceWallTooPlate * Wheels.encodersPerInch));
        telemetry.addData("Task", "Back to wall");
        telemetry.update();
        sleep(4000);

        rightServo.setPosition(0);
        leftServo.setPosition(1);
        telemetry.addData("Task", "Opening Servos");
        telemetry.update();
        sleep(servoRotationTime);
        Moters.setWheelPower(1);
        Moters.setTargetPositionWheels((int) (-16 * Wheels.encodersPerInch));
        telemetry.addData("Task", "Going to line");
        telemetry.update();
        sleep(3000);
        rightServo.setPosition(0);
        leftServo.setPosition(1);
        sleep(servoRotationTime);
        Moters.setTargetPositionWheels((int) (-32 * Wheels.encodersPerInch));
        //pray that we end up over the line
        telemetry.addData("Task", "Stopping");
        telemetry.update();
        Moters.Halt();
    }
}

