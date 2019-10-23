package org.firstinspires.ftc.teamcode.Robot_Parts;

import java.lang.Math;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Wheels{
    Moters Moters;
    Telemetry telemetry;
    double orignalMaxSpeed;
    double maxSpeed;

    public Wheels(Moters A, Telemetry t) {
     Moters = A;
        telemetry = t;
        orignalMaxSpeed = .6;
        maxSpeed = orignalMaxSpeed;
    }


    public void Drive(double directionInRadians, float turnInRadians, float powerInPercentage) {

        double wheelsSetA = Math.sin(directionInRadians - .7957) * powerInPercentage;
        double wheelsSetB = Math.sin(directionInRadians + .7957) * powerInPercentage;
        double motorCheck;
        //checks if one of the wheel sets is > 100% power, if so reduce it to one, and reduce the other by the same factor
        double[] powers = {wheelsSetA + turnInRadians, wheelsSetA - turnInRadians, wheelsSetB + turnInRadians, wheelsSetB - turnInRadians};
        double largestSpeedSoFar = powers[0];

        for (int i = 1; i < 4; i++) {
            if (Math.abs(powers[i]) > largestSpeedSoFar) {
                largestSpeedSoFar = Math.abs(powers[i]);
            }
        }
        motorCheck = maxSpeed / largestSpeedSoFar;
        for (int h = 0; h < 4; h++) {
            powers[h] = powers[h] * motorCheck;

        }
        Moters.backLeftDrive.setPower(powers[0]);
        Moters.frontRightDrive.setPower(-powers[1]);
        Moters.frontLeftDrive.setPower(powers[2]);
        Moters.backRightDrive.setPower(powers[3]);

        telemetry.addData("back left:", powers[0]);
        telemetry.addData("front right:", powers[1]);
        telemetry.addData("front left:", powers[2]);
        telemetry.addData("back right:", powers[3]);
    }

    public void driveDistance(double inches, double directionInRadians) {


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
