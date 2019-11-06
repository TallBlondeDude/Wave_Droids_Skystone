package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.math.Line;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.BasicOpMode_Iterative;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Robot_Parts.Webcam;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Math.E;
import static java.lang.Math.round;

@TeleOp(name = "Doge Test", group = "Linear Opmode")
public class Webcam_Test extends LinearOpMode {

    private int skystoneLocation;
    int iterations = 20;
    Webcam Camera;
    int locationTested;
    int sumOfLocations = 0;

    private int cameraCheck() {
        skystoneLocation = Camera.findSkystone();
        telemetry.addData("Skystone Location", skystoneLocation);
        telemetry.update();
        return skystoneLocation;
    }


    @Override
    public void runOpMode() {
        Camera = new Webcam(hardwareMap.get(WebcamName.class, "Webcam 1"), telemetry, hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName()));
        sleep(5000);
        for (int x = 0; x < iterations; x++) {
            cameraCheck();
            if (skystoneLocation != 5) {
                locationTested = round(Camera.findSkystone() + sumOfLocations);
            } else {
                x = x - 1;
            }
        }

        int locationTested = Math.round(sumOfLocations / iterations);
        Camera.vuforiaOff();
        telemetry.addData("Location Tested", locationTested);
        telemetry.update();
        sleep(20000);


    }

}
