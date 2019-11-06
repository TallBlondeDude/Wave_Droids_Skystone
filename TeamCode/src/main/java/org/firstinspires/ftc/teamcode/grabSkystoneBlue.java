package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;
import org.firstinspires.ftc.teamcode.Robot_Parts.Servos;
import org.firstinspires.ftc.teamcode.Robot_Parts.Webcam;
import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

import static java.lang.Math.round;

@Autonomous(name = "Right Side Move Left", group = "Iterative Opmode")
public class grabSkystoneBlue extends LinearOpMode {
    int skystonePosition = 1;
    int distanceFromWallToScanArea = 48;
    int distanceToPlate = 78;
    int distanceToStoneFromScanAreaStrafe;
    int distanceToStoneFromScanAreaFoward;
    int distanceToLineFromPlate;
    int distanceToWallFromPlate;
    int distanceToLeftStoneFoward;
    int distanceToLeftStoneStrafe;
    int distanceToCenterStoneFoward;
    int distanceToCenterStoneStrafe;
    int distanceToRightStoneFoward;
    int distanceToRightStoneStrafe;

    @Override
    public void runOpMode() throws InterruptedException {
        Moters Moters;
        Servos Servos;
        Webcam Camera;
        Wheels Wheels;
        Camera = new Webcam(hardwareMap.get(WebcamName.class, "Webcam 1"), telemetry, hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName()));

        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"), hardwareMap.get(Servo.class, "rightPlateServo"));
        Wheels = new Wheels(Moters, telemetry);
        int iterations = 20;
        int skystoneLocation = 0;
        int locationTested;
        int sumOfLocations = 0;

        for (int x = 0; x < iterations; ) {
            skystoneLocation = Camera.findSkystone();
            telemetry.addData("Skystone Location", skystoneLocation);
            telemetry.update();
            if (skystoneLocation != 5) {
                locationTested = round(Camera.findSkystone() + sumOfLocations);
                x++;
            }

        }
        int locationOfSkystone = Math.round(sumOfLocations / iterations);
        // if it is LEFT
        if (locationOfSkystone == -1) {
            Wheels.driveDistanceFoward(distanceToLeftStoneFoward, .5);
            sleep(3500);
            Wheels.driveDistanceCrabwalk(distanceToLeftStoneStrafe, .8);
            sleep(3500);
            //Arm.grabSkystone();
            Wheels.driveDistanceFoward(-distanceToLeftStoneStrafe, -.6);
            sleep(3000);

        }

    }

}
