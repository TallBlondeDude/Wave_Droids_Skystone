package org.firstinspires.ftc.teamcode.Robot_Parts;

public class Wheels {
    public void Drive(double directionInRadians, double turnInRadians, double powerInPercentage) {

        // plotted out points and this fit them, xcord gives turning factor
        telemetry.addData("Direction in Radians", "Angle: " + directionInRadians);
        telemetry.addData("Turning", "Percentage to turn: " + turnInRadians);

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
        frontRightDrive.setPower(-1 * wheelsSetB);
        backRightDrive.setPower(-1 * wheelsSetA);
        backLeftDrive.setPower(wheelsSetB);
        frontLeftDrive.setPower(wheelsSetA);


    }

    public void Turn(double turnInRadians, double turnPower) {
        percentTurn = turnInRadians / 6.283;
        
        wheelsSetA =
                frontRightDrive.setPower(-1 * wheelsSetB);
        backRightDrive.setPower(-1 * wheelsSetA);
        backLeftDrive.setPower(wheelsSetB);
        frontLeftDrive.setPower(wheelsSetA);

    }

}
