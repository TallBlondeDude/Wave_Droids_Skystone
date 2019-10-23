package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Controllers{
    Controllers controller;
    int armRaiseSpeed;
    Gamepad gamepad1;
    Wheels wheels;
    double lastAPress;


    public Controllers(Controllers a, Gamepad b, Wheels c) {
        armRaiseSpeed = 5;
        controller = a;
        gamepad1 = b;
        wheels = c;
        lastAPress = 0;
    }

    public void UpdateMovement() {
        //  BackBumpers();
        //  BackTriggers();
        AButton();
    }

    //Finds distance between 0, 0 and the joysticks location
    public double polarMagnitude() {
        //grab coordinates of joystick
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        //square them
        double squareX = xcord * xcord;
        double squareY = ycord * ycord;
        //Find the sqrt
        double magnitude = Math.sqrt(squareY + squareX);

        return magnitude / 1.1;
    }

    //finds angle with true right being 0 degrees
    public double polarAngle() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        // inverse tangent
        double theta = Math.atan2(xcord, ycord);
        return (theta - 1.57079);
    }

    public void BackBumpers() {
    }

    public void AButton() {
        double timestamp = gamepad1.timestamp;
        if (lastAPress - timestamp < 2) {
            if (wheels.maxSpeed == wheels.orignalMaxSpeed) {
                wheels.maxSpeed = wheels.maxSpeed / 2;
            } else {
                wheels.maxSpeed = wheels.maxSpeed * 2;
            }
            lastAPress = timestamp;
        }
    }

    public void BackTriggers() {

    }
}
