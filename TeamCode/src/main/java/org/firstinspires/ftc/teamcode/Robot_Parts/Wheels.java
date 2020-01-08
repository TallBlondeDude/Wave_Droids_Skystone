package org.firstinspires.ftc.teamcode.Robot_Parts;

import java.lang.Math;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wheels{
    // wheel variables
    private Moters Moters;
    private Telemetry telemetry;
    private final double orignalMaxSpeed;
    private double maxSpeed;
    public static double encodersPerInch;
    private int idealPostionBackLeft;
    private int idealPostionBackRight;
    private int idealPostionFrontLeft;
    private int idealPostionFrontRight;


    public Wheels(Moters A, Telemetry t) {
        Moters = A;
        telemetry = t;
        orignalMaxSpeed = 1;
        maxSpeed = orignalMaxSpeed;
        encodersPerInch = (1.2 * 69) / 1.65;
    }

    private double findAdjustedPower(int encoderTicksRemaining, double basePower) {
        double possiblePower = Math.sqrt(basePower / Math.abs(encoderTicksRemaining));
        possiblePower = possiblePower * encoderTicksRemaining / Math.abs(encoderTicksRemaining);
        if (possiblePower > 1){
            possiblePower = 1;
        } else if (possiblePower < .4 && possiblePower > 0) {
            possiblePower = .4;
        } else if (possiblePower < 0 && possiblePower > -.4) {
            possiblePower = -.4;
        } else if (possiblePower < -1) {
            possiblePower = -1;
        }
        return possiblePower;
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
        Moters.frontRightDrive.setPower(powers[1]);
        Moters.frontLeftDrive.setPower(powers[2]);
        Moters.backRightDrive.setPower(powers[3]);

        telemetry.addData("back left:", powers[0]);
        telemetry.addData("front right:", powers[1]);
        telemetry.addData("front left:", powers[2]);
        telemetry.addData("back right:", powers[3]);
        telemetry.addData("turning", turnInRadians);
        telemetry.addData("power in percentage", powerInPercentage);
    }

    /* public void driveDistanceFoward(double inches, double power) {
        //find how many encoder ticks we need to move
        int encoderDistance = (int) (-inches * encodersPerInch);
        //find ideal encoder pos
        Moters.setTargetPositionWheels(encoderDistance);

        //change  motor power based on distance
        while (Moters.frontLeftDrive.getCurrentPosition() != idealPostionBackLeft
                && Moters.frontRightDrive.getCurrentPosition() != idealPostionFrontRight
                && Moters.backRightDrive.getCurrentPosition() != idealPostionBackRight
                && Moters.backLeftDrive.getCurrentPosition() != idealPostionBackLeft) {


            Moters.backLeftDrive.setPower(findAdjustedPower(idealPostionBackLeft
                    - Moters.frontLeftDrive.getCurrentPosition(), power));
            Moters.backRightDrive.setPower(findAdjustedPower(idealPostionBackRight
                    - Moters.backRightDrive.getCurrentPosition(), power));
            Moters.frontLeftDrive.setPower(findAdjustedPower(idealPostionFrontLeft
                    - Moters.backLeftDrive.getCurrentPosition(), power));
            Moters.frontRightDrive.setPower(findAdjustedPower(idealPostionFrontRight
                    - Moters.frontRightDrive.getCurrentPosition(), power));
        }
    }

     */
    public void driveDistanceFoward(double power, double distance) {
        Moters.setWheelPower(power);
        Moters.setTargetPositionWheels((int) (distance * encodersPerInch));
    }
    public void driveDistanceCrabwalk(double inchesToTheRight, double power) {
        //find how many encoder ticks we need to move
        double friction = 1.04;
        int encoderDistance = (int) (inchesToTheRight * encodersPerInch * 2 * friction);

        //set encoders target location
        Moters.setTargetPositionWheelsCrabwalk(encoderDistance);
        idealPostionBackLeft = Moters.backLeftDrive.getCurrentPosition() - encoderDistance;
        idealPostionBackRight = Moters.backLeftDrive.getCurrentPosition() - encoderDistance;
        idealPostionFrontLeft = Moters.backLeftDrive.getCurrentPosition() + encoderDistance;
        idealPostionFrontRight = Moters.backLeftDrive.getCurrentPosition() + encoderDistance;
        telemetry.addData("Encoders Target Pos Set", idealPostionBackLeft);
        telemetry.update();
        while (Moters.frontLeftDrive.getCurrentPosition() != idealPostionBackLeft
                && Moters.frontRightDrive.getCurrentPosition() != idealPostionFrontRight
                && Moters.backRightDrive.getCurrentPosition() != idealPostionBackRight
                && Moters.backLeftDrive.getCurrentPosition() != idealPostionBackLeft) {

            Moters.backLeftDrive.setPower(findAdjustedPower(idealPostionBackLeft
                    - Moters.frontLeftDrive.getCurrentPosition(), power));
            Moters.backRightDrive.setPower(findAdjustedPower(idealPostionBackRight
                    - Moters.backRightDrive.getCurrentPosition(), power));
            Moters.frontLeftDrive.setPower(findAdjustedPower(idealPostionFrontLeft
                    - Moters.backLeftDrive.getCurrentPosition(), power));
            Moters.frontRightDrive.setPower(findAdjustedPower(idealPostionFrontRight
                    - Moters.frontRightDrive.getCurrentPosition(), power));
            telemetry.addData("Encoders Target Pos", Moters.backLeftDrive.getCurrentPosition());
            telemetry.addData("Back Left Motor Power", Moters.backLeftDrive.getPower());
            telemetry.update();

        }
    }

    public void Turn(double turnPower) {

        Moters.backLeftDrive.setPower(turnPower);
        Moters.frontLeftDrive.setPower(turnPower);
        Moters.frontRightDrive.setPower(-turnPower);
        Moters.backRightDrive.setPower(-turnPower);

    }


}

