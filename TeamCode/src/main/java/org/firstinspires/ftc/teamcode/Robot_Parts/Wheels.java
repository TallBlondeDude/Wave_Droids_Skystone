package org.firstinspires.ftc.teamcode.Robot_Parts;

import java.lang.Math;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Wheels{
    Moters Moters;
    Telemetry telemetry;
    final double orignalMaxSpeed;
    double maxSpeed;
    final double encodersPerInch;

    public Wheels(Moters A, Telemetry t) {
        Moters = A;
        telemetry = t;
        orignalMaxSpeed = .6;
        maxSpeed = orignalMaxSpeed;
        encodersPerInch = 3;
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
        Moters.backLeftDrive.setPower(.51 * powers[0]);
        Moters.frontRightDrive.setPower(-powers[1]);
        Moters.frontLeftDrive.setPower(.51 * powers[2]);
        Moters.backRightDrive.setPower(powers[3]);

        telemetry.addData("back left:", powers[0]);
        telemetry.addData("front right:", powers[1]);
        telemetry.addData("front left:", powers[2]);
        telemetry.addData("back right:", powers[3]);
    }

    public void driveDistanceFoward(double inches, double power) {
        //find how many encoder ticks we need to move
        int encoderDistance = (int) (-1 * inches * encodersPerInch);
        //set the power for this operation
        Moters.backLeftDrive.setPower(.8 * -power);
        Moters.backRightDrive.setPower(-power);
        Moters.frontLeftDrive.setPower(.8 * -power);
        Moters.frontRightDrive.setPower(.9 * -power);

        //set encoders target location
        Moters.backLeftDrive.setTargetPosition(Moters.backLeftDrive.getCurrentPosition() + encoderDistance);
        Moters.backRightDrive.setTargetPosition(Moters.backRightDrive.getCurrentPosition() + encoderDistance);
        Moters.frontLeftDrive.setTargetPosition(Moters.frontLeftDrive.getCurrentPosition() + encoderDistance);
        Moters.frontRightDrive.setTargetPosition(Moters.frontRightDrive.getCurrentPosition() + encoderDistance);

    }

    public void driveDistanceCrabwalk(double inchesToTheRight, double power) {
        //find how many encoder ticks we need to move
        double friction = 1.05;
        int encoderDistance = (int) (inchesToTheRight * encodersPerInch * 2 * friction);
        //set the power for this operation
        Moters.backLeftDrive.setPower(.5 * -power);
        Moters.backRightDrive.setPower(power);
        Moters.frontLeftDrive.setPower(.5 * power);
        Moters.frontRightDrive.setPower(power);

        //set encoders target location
        Moters.backLeftDrive.setTargetPosition(Moters.backLeftDrive.getCurrentPosition() + encoderDistance);
        Moters.backRightDrive.setTargetPosition(Moters.backRightDrive.getCurrentPosition() + encoderDistance);
        Moters.frontLeftDrive.setTargetPosition(Moters.frontLeftDrive.getCurrentPosition() + encoderDistance);
        Moters.frontRightDrive.setTargetPosition(Moters.frontRightDrive.getCurrentPosition() - encoderDistance);

    }

    public void Turn(double turnPower) {

        Moters.backLeftDrive.setPower(-turnPower);
        Moters.frontLeftDrive.setPower(-turnPower);
        Moters.frontRightDrive.setPower(turnPower);
        Moters.backRightDrive.setPower(turnPower);

    }


    }

