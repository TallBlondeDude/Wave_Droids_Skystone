package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Controllers{
    private Controllers controller;
    private int armRaiseSpeed;
    private Gamepad gamepad1;
    private Wheels wheels;
    private Servos Servos;
    private Gamepad gamepad2;
    private Arm Arm;

    public Controllers(Controllers a, Gamepad b, Wheels c, Servos d, Gamepad f, Arm g) {
        armRaiseSpeed = 5;
        controller = a;
        gamepad1 = b;
        gamepad2 = f;
        wheels = c;
        Arm = g;
        Servos = d;
    }

    public void UpdateMovement() {
        if (gamepad1.a) {
            AButton();
        }
        if (gamepad1.b) {
            BButton();
        }

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

    public void armSpeedDetector() {
        Arm.changeVerticalArmPos(gamepad2.left_stick_x);
    }

    //finds angle with true right being 0 degrees
    public double polarAngle() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        // inverse tangent
        double theta = Math.atan2(xcord, ycord);
        return (theta - 1.57079);

    }

    public void BackBumper() {
    }

    public void AButton() {
        Servos.setPlateServoPos(1);
    }

    public void BButton() {
        Servos.setPlateServoPos(0);
    }
}
