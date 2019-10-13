package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Wheels extends Basic_Test_Drive {
    public Wheels() {
    }

    public void Drive(double directionInRadians, double turnInRadians, float powerInPercentage) {

        double wheelsSetA = Math.sin(directionInRadians - .7957) * powerInPercentage + turnInRadians;
        double wheelsSetB = Math.sin(directionInRadians + .7957) * powerInPercentage + turnInRadians;
        //checks if one of the wheel sets is > 100% power, if so reduce it to one, and reduce the other by the same factor
        if (wheelsSetA > 1) {
            wheelsSetB = wheelsSetB / wheelsSetA;
            wheelsSetA = 1;
        }

        if (wheelsSetB > 1) {
            wheelsSetA = wheelsSetA / wheelsSetB;
            wheelsSetB = 1;
        }
        // convert power into encoder distance
        double encoderAmount = powerInPercentage * 3;
        // Send calculated power to wheels, inversion is due to battery power flow & wheel location

        Drive(wheelsSetA, wheelsSetB, encoderAmount);

    }

    private void Drive(double wheelsSetA, double wheelsSetB, double Power) {
        int constant = (int) Math.round(Power * 10);
        int newWheelSetA = (int) (constant * wheelsSetA);
        int newWheelSetB = (int) (constant * wheelsSetA);
        Moters.frontLeftDrive.setTargetPosition(Moters.frontLeftDrive.getCurrentPosition() + (-1 * newWheelSetA));
        Moters.frontLeftDrive.setTargetPosition(Moters.backRightDrive.getCurrentPosition() + (newWheelSetA));
        Moters.frontLeftDrive.setTargetPosition(Moters.frontRightDrive.getCurrentPosition() + (newWheelSetB));
        Moters.frontLeftDrive.setTargetPosition(Moters.backLeftDrive.getCurrentPosition() + (-1 * newWheelSetB));

    }
    public void Stop() {
        Moters.backLeftDrive.setPower(0);
        Moters.frontLeftDrive.setPower(0);
        Moters.frontRightDrive.setPower(0);
        Moters.backRightDrive.setPower(0);


    }


    /*public void Turn(double turnXCord, double turnPower) {
        if (turnXCord > 0){

        }
        Moters.backLeftDrive.setPower(leftPower);
        Moters.frontLeftDrive.setPower(leftPower);
        Moters.frontRightDrive.setPower(rightPower);
        Moters.backRightDrive.setPower(rightPower);

    }

     */

}
