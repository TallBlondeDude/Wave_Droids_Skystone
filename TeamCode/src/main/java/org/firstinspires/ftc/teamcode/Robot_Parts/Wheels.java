package org.firstinspires.ftc.teamcode.Robot_Parts;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Basic_Test_Drive;

public class Wheels{
    Moters Moters;
    Telemetry telemetry;

    public Wheels(Moters A, Telemetry t) {
     Moters = A;
        telemetry = t;
    }


    public void Drive(double directionInRadians, float turnInRadians, float powerInPercentage) {

        double wheelsSetA = Math.sin(directionInRadians - .7957) * powerInPercentage;
        double wheelsSetB = Math.sin(directionInRadians + .7957) * powerInPercentage;
        double turnInPercentage = turnInRadians;
        double motorCheck;
        double maxSpeed = .6;
        //checks if one of the wheel sets is > 100% power, if so reduce it to one, and reduce the other by the same factor
        double[] powers = {wheelsSetA + turnInPercentage, wheelsSetA - turnInPercentage, wheelsSetB + turnInPercentage, wheelsSetB - turnInPercentage};
        for (int i = 0; i < powers.length; i++) {
            if (powers[i] > maxSpeed) {
                motorCheck = maxSpeed / powers[i];
                for (int h = 0; h < powers.length; h++) {
                    powers[h] = powers[h] * motorCheck;
                }
            }
        }

        Moters.backLeftDrive.setPower(powers[0]);
        Moters.frontRightDrive.setPower(-powers[1]);
        Moters.frontLeftDrive.setPower(powers[2]);
        Moters.backRightDrive.setPower(powers[3]);
        telemetry.addData("back left:", powers[0]);
        telemetry.addData("front right:", powers[1]);
        telemetry.addData("front left:", powers[2]);
        telemetry.addData("back right:", powers[3]);

        // convert power into encoder distance
        double encoderAmount = powerInPercentage * 3;
        // Send calculated power to wheels, inversion is due to battery power flow & wheel location


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
