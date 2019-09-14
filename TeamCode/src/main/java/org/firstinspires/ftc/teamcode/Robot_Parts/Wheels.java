package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;

public class Wheels {
    private Moters Moters = new Moters();

    public void Drive(double directionInRadians, double turnInRadians, double powerInPercentage) {

        // plotted out points and this fit them, xcord gives turning factor

        double wheelsSetA = Math.sin(directionInRadians - .7957) * powerInPercentage + turnInRadians;
        double wheelsSetB = Math.sin(directionInRadians + .7957) * powerInPercentage + turnInRadians;
        //checks if one of the wheel sets is > 100% power, if so reduce it to one, and reduce the other by the same factor
        if (wheelsSetA > 1) {
            wheelsSetB = wheelsSetB / wheelsSetA;
            wheelsSetA = 1;
        } else if (wheelsSetB > 1) {
            wheelsSetA = wheelsSetA / wheelsSetB;
            wheelsSetB = 1;
        }


        // Send calculated power to wheels, inversion is due to battery power flow & wheel location
        Moters.frontRightDrive.setPower(-1 * wheelsSetB);
        Moters.backRightDrive.setPower(-1 * wheelsSetA);
        Moters.backLeftDrive.setPower(wheelsSetB);
        Moters.frontLeftDrive.setPower(wheelsSetA);


    }

    public void Stop() {
        Moters.backLeftDrive.setPower(0);
        Moters.frontLeftDrive.setPower(0);
        Moters.frontRightDrive.setPower(0);
        Moters.backRightDrive.setPower(0);


    }

    public void Turn(double turnInRadians, double turnPower) {
        double percentTurn = turnInRadians / 6.283;
        double direction = turnInRadians / turnInRadians;
        // percentTurn / xxx =
        Moters.backLeftDrive.setPower(direction);
        Moters.frontLeftDrive.setPower(direction);
        Moters.frontRightDrive.setPower(direction);
        Moters.backRightDrive.setPower(direction);
        // wait(waitTime);

        Moters.backLeftDrive.setPower(0);
        Moters.frontLeftDrive.setPower(0);
        Moters.frontRightDrive.setPower(0);
        Moters.backRightDrive.setPower(0);

    }

}
