package org.firstinspires.ftc.teamcode.Robot_Parts;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Controllers extends Basic_Test_Drive {
    Controllers controller;
    int armRaiseSpeed;



    public Controllers() {
        armRaiseSpeed = 5;
    }

    public void UpdateMovement() {
        BackBumpers();
        BackTriggers();
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
        return magnitude;
    }

    //finds angle with true right being 0 degrees
    public double polarAngle() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        // inverse tangent
        double theta = Math.atan2(xcord, ycord);
        return theta;
    }

    public void BackBumpers() {
    }

    public void AButton() {

    }

    public void BackTriggers() {

    }
}
