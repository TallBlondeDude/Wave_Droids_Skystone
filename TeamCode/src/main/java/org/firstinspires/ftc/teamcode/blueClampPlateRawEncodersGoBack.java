package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;
import org.firstinspires.ftc.teamcode.Robot_Parts.Servos;
import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

@Autonomous(name = "Red Plate", group = "Linear Opmode")
public class blueClampPlateRawEncodersGoBack extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;
    public Servos Servos;
    private long servoRotationTime;
    private double distanceWallTooPlate;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initalize the motors, servos, and wheels
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"),
                hardwareMap.get(Servo.class, "rightPlateServo"), hardwareMap.get(Servo.class, "grabberServo"),
                hardwareMap.get(Servo.class, "inOutServo"), hardwareMap.get(Servo.class, "modeArmServo"));
        Wheels = new Wheels(Moters, telemetry);

        // set the motors in autonomous mode for the encoders and direction
        Moters.setAutoMode();

        // variables set to help with running autonomous
        servoRotationTime = 1000;
        distanceWallTooPlate = 12.5;
        waitForStart();
        // set the plate servos position up and crab walk power to a good power percentage
        Servos.setPlateServoPos(0);
        Moters.setWheelPowerCrabwalk(.8);
        // robot crab walks to the plate
        Moters.setTargetPositionWheelsCrabwalk((int) (org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch * 19));
       // telemetry for when the robot crab walks
        telemetry.addData("Task", "Crab walking");
       telemetry.update();
       sleep(1000);
       // set motors to telop mode to go straight
        Moters.setTeleMode();
        // robot goes straight a little bit
        Wheels.Drive((3.1415 / 2) * 3, 0, 40);
        sleep(150);
        // wheels stop, go into autonomous mode, then get a lesser power percentage
        Moters.setWheelPower(0);
        Moters.setAutoMode();
        Moters.setWheelPower(.6);
        // robot finishes going to the plate
        Moters.setTargetPositionWheels((int) (2.1 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch * -distanceWallTooPlate));
        telemetry.addData("Task", "Going to plate");
        telemetry.update();
        sleep(3500);

        Moters.setWheelPower(.3);
        Moters.setTargetPositionWheels((int) (2 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch * -3));
        sleep(1500);

        // robot goes forward and grabs the plate
        Moters.setWheelPower(1);
        Servos.setPlateServoPos(1);
        telemetry.addData("Task", "Closing Servos");
        telemetry.update();
        sleep(servoRotationTime);

        // robot goes back to the wall
        Moters.setWheelPower(.6);
        Moters.setTargetPositionWheels((int) (3.5 * distanceWallTooPlate * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Back to wall");
        telemetry.update();
        sleep(3000);

        // robot corrects for any erros
        Moters.setWheelPower(.4);
        // start according to line pattern
        Moters.setTargetPositionWheels((int) (2 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Correcting for Error");
        sleep(1500);

        // servos open up and drops the plate
        Servos.setPlateServoPos(0);
        telemetry.addData("Task", "Opening Servos");
        telemetry.update();
        sleep(servoRotationTime);

        // robot corrects for any errors again
        Moters.setWheelPower(1);
        // start according to line pattern
        Moters.setTargetPositionWheels((int) (2 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Correcting for Error");
        sleep(1500);

        // robot crab walks to the line
        Moters.setWheelPowerCrabwalk(.5);
        Moters.setTargetPositionWheelsCrabwalk(-(int) (52 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "moving to line");
        telemetry.update();
        sleep(3000);
/*
        Moters.setWheelPowerCrabwalk(.8);
        Moters.setTargetPositionWheels(-(int) (12 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "forward for pushback");
        telemetry.update();
        sleep(2000);

        Moters.setWheelPowerCrabwalk(.7);
        Moters.setTargetPositionWheelsCrabwalk((int) (-7 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "Push Right");
        telemetry.update();
        sleep(2000);

        Moters.setWheelPowerCrabwalk(.7);
        Moters.setTargetPositionWheelsCrabwalk((int) (7 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "moving to line");
        telemetry.update();
        sleep(2500);

        Moters.setWheelPowerCrabwalk(.8);
        Moters.setTargetPositionWheels((int) (7 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "moving to line");
        telemetry.update();
        sleep(2000);

        Moters.setWheelPowerCrabwalk(.7);
        Moters.setTargetPositionWheelsCrabwalk((int) (7 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "moving to line");
        telemetry.update();
        sleep(2000);

        Moters.setWheelPowerCrabwalk(1);
        Moters.setTargetPositionWheelsCrabwalk((int) (7 * org.firstinspires.ftc.teamcode.Robot_Parts.Wheels.encodersPerInch));
        telemetry.addData("Task", "moving to line");
        telemetry.update();
        sleep(500);

 */

        //pray that we end up over the line
        telemetry.addData("Task", "Stopping");
        telemetry.update();
        Moters.Halt();
    }
}

