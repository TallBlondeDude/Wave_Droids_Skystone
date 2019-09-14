package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Controllers extends LinearOpMode {
    double xcord = gamepad1.left_stick_x;
    double ycord = gamepad1.left_stick_y;

    @Override
    public void runOpMode() throws InterruptedException {
    }

    public double polarMagnitude() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        double squareX = xcord * xcord;
        double squareY = ycord * ycord;
        double magnitude = Math.sqrt(squareY + squareX);
        return magnitude;
    }

    public double polarAngle() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        double theta = Math.atan2(xcord, ycord);
        return theta;
    }

}
