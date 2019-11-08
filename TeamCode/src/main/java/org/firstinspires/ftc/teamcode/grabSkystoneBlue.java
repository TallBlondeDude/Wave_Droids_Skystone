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
    int distanceFromWallToScanArea = 48;
    int distanceToPlate = 78;
    int distanceToLineFromPlate = 9;
    int distanceToWallFromPlate = 25;
    int distanceToStoneFoward = 25;
    double distanceToLeftStoneStrafe = 3.75;
    double distanceToCenterStoneStrafe = 3.75;
    double distanceToRightStoneStrafe = 12;
    double distanceToSecondStone = 64;

    @Override
    public void runOpMode() throws InterruptedException {
        Moters Moters;
        Webcam Camera;
        Wheels Wheels;
        Servos Servos;
        Camera = new Webcam(hardwareMap.get(WebcamName.class, "Webcam 1"), telemetry,
                hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName()));
        Servos = new Servos(hardwareMap.get(Servo.class, "leftPlateServo"), hardwareMap.get(Servo.class, "rightPlateServo"),
                hardwareMap.get(Servo.class, "grabberServo"),
                hardwareMap.get(Servo.class, "rotationHorizontal"),
                hardwareMap.get(Servo.class, "rotationVertical"));
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"));
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Wheels = new Wheels(Moters, telemetry);
        Moters.setAutoMode();
        int iterations = 20;
        int skystoneLocation;
        int sumOfLocations = 0;
        Wheels.driveDistanceFoward(distanceFromWallToScanArea, .9);
    //    sleep(2500);
        for (int x = 0; x < iterations; ) {
            skystoneLocation = Camera.findSkystone();
            telemetry.addData("Skystone Location", skystoneLocation);
            telemetry.update();
            sumOfLocations = round(Camera.findSkystone() + sumOfLocations);
            x++;
        }
        int locationOfSkystone = Math.round(sumOfLocations / iterations);
        // if it is LEFT
        if (locationOfSkystone == -1) {
            Wheels.driveDistanceFoward(distanceToStoneFoward, 1);
     //       sleep(1500);
            Wheels.driveDistanceCrabwalk(distanceToLeftStoneStrafe, 1);
     //       sleep(1500);
            //Arm.grabSkystone();
            Wheels.driveDistanceFoward(-distanceToLeftStoneStrafe, -1);
       //     sleep(1500);
            distanceToPlate = distanceToPlate + 8;

        }
        if (locationOfSkystone == 0) {
            Wheels.driveDistanceFoward(distanceToStoneFoward, 1);
    //        sleep(1500);
            Wheels.driveDistanceCrabwalk(distanceToCenterStoneStrafe, 1);
      //      sleep(1500);
            //Arm.grabSkystone();
            Wheels.driveDistanceFoward(-distanceToCenterStoneStrafe, -1);
      //      sleep(1500);
            distanceToPlate = distanceToPlate + 4;
        }
        if (locationOfSkystone == -1) {
            Wheels.driveDistanceFoward(distanceToStoneFoward, 1);
      //      sleep(1500);
            Wheels.driveDistanceCrabwalk(distanceToRightStoneStrafe, 1);
     //       sleep(1500);
            //Arm.grabSkystone();
            Wheels.driveDistanceFoward(-distanceToRightStoneStrafe, 1);
      //      sleep(1500);
        }
        distanceToSecondStone = distanceToSecondStone + (7 * (locationOfSkystone + 1)) + 3.5;
        Wheels.driveDistanceCrabwalk(-distanceToPlate, .8);
     //   sleep(3000);
        //Arm.Drop;
     //   sleep(1500);
        Wheels.driveDistanceCrabwalk(distanceToSecondStone, 1);
    //    sleep(3000);
        Wheels.driveDistanceFoward(distanceToStoneFoward, 1);
    //    sleep(1500);
        //Arm.Grab
   //     sleep(1500);
        Wheels.driveDistanceFoward(-distanceToStoneFoward, 1);
   //     sleep(1500);
        Wheels.driveDistanceCrabwalk(-distanceToSecondStone, 1);
   //     sleep(3000);
        //Arm.Drop
        Wheels.driveDistanceFoward(-distanceToWallFromPlate, 1);
  //      sleep(3000);
        Wheels.driveDistanceCrabwalk(distanceToLineFromPlate, 1);

        Moters.Halt();
        Servos.Halt();


    }

}
