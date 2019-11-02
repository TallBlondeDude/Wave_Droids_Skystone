package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Controllers{
    Controllers controller;
    int armRaiseSpeed;
    Gamepad gamepad1;
    Wheels wheels;
    Servos Servos;

    public Controllers(Controllers a, Gamepad b, Wheels c, Servos d) {
        armRaiseSpeed = 5;
        controller = a;
        gamepad1 = b;
        wheels = c;
        Servos = d;
    }

    public void UpdateMovement() {

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
        Servos.setPlateServoPos(1);
    }

    public void BButton() {
        Servos.setPlateServoPos(0);

    }
}
