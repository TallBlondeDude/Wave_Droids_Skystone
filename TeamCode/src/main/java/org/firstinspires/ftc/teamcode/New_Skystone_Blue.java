package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;

import static java.lang.Math.round;

@Autonomous(name = "Skystone Blue", group = "Linear Opmode")

public class New_Skystone_Blue extends LinearOpMode {
    Moters Moters;
    Servos Servos;
    Webcam Camera;
    Intake Intake;
    @Override
    public void internalPreInit() {
        super.internalPreInit();
        Camera = new Webcam(hardwareMap.get(WebcamName.class, "Webcam 1"), telemetry,
                (hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId",
                        "id", hardwareMap.appContext.getPackageName())));
    }
    @Override
    public void runOpMode() throws InterruptedException {
        Servo stoneServo = hardwareMap.get(Servo.class, "stoneServo");

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
        Intake = new Intake(Moters, telemetry);
        Moters.setAutoMode();
        waitForStart();
        Moters.setWheelPower(.6);
        Moters.setTargetPositionWheelsS(-890);
        sleep(1250);
        //var decleration block
        double encodersPerInch = (2.1 * 69) / 1.65;
        int distanceToStones = (int) (6.8 * encodersPerInch);
        int crabwalkDistanceIntoStones = (int)( 2 * 9 * encodersPerInch);
        int backtrackToStoneDistance = (int) (52 * encodersPerInch);
        int pickUpStoneDistance = (int) (encodersPerInch * 8);
        int distanceAcrossLineFirst = (int) (encodersPerInch * 20);
        int distanceAcrossLineSecond = (int) (encodersPerInch * 35);
        int backToLineFinal = (int) (-9 * encodersPerInch);
        int iterations = 10;
        int skystoneLocation;
        int sumOfLocations = 0;
        for (int x = 0; x < iterations;) {
            skystoneLocation = Camera.findSkystone();
            telemetry.addData("Skystone Location", skystoneLocation);
            telemetry.update();
            sumOfLocations = round(Camera.findSkystone() + sumOfLocations);
            x++;
        }

        int locationOfSkystone = Math.round(sumOfLocations / iterations);
        telemetry.addData("Stone", locationOfSkystone);
        telemetry.update();
        //crabwalk over to position we found :)
        int crabwalkDistance;

        if (locationOfSkystone == -1){
            crabwalkDistance = 5;

        }
        else if (locationOfSkystone == 1){
            crabwalkDistance = (int) (-.9 * encodersPerInch);
            backtrackToStoneDistance = backtrackToStoneDistance + ((int) (5 * encodersPerInch));
            distanceAcrossLineFirst = distanceAcrossLineFirst + ((int) (5 * encodersPerInch));
            distanceAcrossLineSecond = distanceAcrossLineSecond + ((int) (5 * encodersPerInch));
        }
        else{
            crabwalkDistance = -5;
            backtrackToStoneDistance = backtrackToStoneDistance + ((int) (9.5 * encodersPerInch));
            distanceAcrossLineFirst = distanceAcrossLineFirst + ((int) (9.5 * encodersPerInch));
            distanceAcrossLineSecond = distanceAcrossLineSecond + ((int) (9.5 * encodersPerInch));
        }
        Moters.setTargetPositionWheelsCrabwalk(crabwalkDistance);
        telemetry.addData("Step", "Crabwalking to Block");
        telemetry.update();
        sleep(1500);
        Moters.setTargetPositionWheelsS(-distanceToStones);
        Moters.setWheelPower(.25);
        telemetry.addData("Step", "Driving to Block");
        telemetry.update();
        sleep(700);
        Moters.setWheelPower(0);
        stoneServo.setPosition(1);
        telemetry.addData("Step", "Grabbing stone");
        telemetry.update();

        sleep(250);
        telemetry.addData("Step", "backtracking");
        telemetry.update();
        Moters.setTargetPositionWheelsS((int) (-4 * encodersPerInch));

        sleep(750);
        Moters.setWheelPower(.8);
        telemetry.addData("Step", "Turning to Line");
        telemetry.update();
        Moters.turn(1);
        sleep(750);
        telemetry.addData("Step", "Going Across Line");
        telemetry.update();
        Moters.setTargetPositionWheelsS(distanceAcrossLineFirst);


        Moters.Halt();
        Servos.Halt();




    }
}
