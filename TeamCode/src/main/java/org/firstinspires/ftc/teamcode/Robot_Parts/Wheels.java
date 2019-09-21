package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Wheels {
    private Moters Moters = new Moters();

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
        double encoderPerSecond = powerInPercentage * 4;
        // Send calculated power to wheels, inversion is due to battery power flow & wheel location

        Drive(wheelsSetA, wheelsSetB, encoderPerSecond);
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


    public void DriveDistance(double directionInRadians, double powerInPercentage, double distanceInEncoderTicks){
        // plotted out points and this fit them, xcord gives turning factor

        // reset encoder count
        Moters.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Moters.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Moters.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Moters.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set left motor to run to target encoder position and stop with brakes on.
        Moters.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Moters.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Moters.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Moters.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        double wheelsSetA = Math.sin(directionInRadians - .7957) * powerInPercentage;
        double wheelsSetB = Math.sin(directionInRadians + .7957) * powerInPercentage;
        //checks if one of the wheel sets is > 100% power, if so reduce it to one, and reduce the other by the same factor
        if (wheelsSetA > 1) {
            wheelsSetB = wheelsSetB / wheelsSetA;
            wheelsSetA = 1;
        }

        if (wheelsSetB > 1) {
            wheelsSetA = wheelsSetA / wheelsSetB;
            wheelsSetB = 1;
        }
        double efficiancy = wheelsSetA + wheelsSetB;
        efficiancy = Math.abs(efficiancy);

        // convert power into encoder distance
        Moters.frontLeftDrive.getCurrentPosition();

        // Send calculated power to wheels, inversion is due to battery power flow & wheel location

        Moters.frontRightDrive.setPower(-1 * wheelsSetB);
        Moters.backRightDrive.setPower(-1 * wheelsSetA);
        Moters.backLeftDrive.setPower(wheelsSetB);
        Moters.frontLeftDrive.setPower(wheelsSetA);

    }

    public void findEfficiency() {

    }
    
    public void Turn(double turnInRadians, double turnPower) {
        double percentTurn = turnInRadians / 6.283;
        double direction = turnInRadians / turnInRadians;

        // reset encoder count
        Moters.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Moters.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Moters.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Moters.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set left motor to run to target encoder position and stop with brakes on.
        Moters.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Moters.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Moters.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Moters.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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
