package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.hardware.bosch.BNO055IMU;

import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import com.qualcomm.hardware.bosch.BNO055IMU;


public class Gyroscope {
    public BNO055IMU imu;
    public Orientation Orientation;
    float angle;
    Telemetry telemetry;

    public Gyroscope(BNO055IMU imu, double xcord, double ycord, Telemetry telemetry) {
        // provide positional information.
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitIMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        this.telemetry = telemetry;
        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        this.imu = imu;
        imu.initialize(parameters);
        telemetry.addData("IMU STATE", "Initalized");
        telemetry.update();
        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

    }

    public float getDirection() {
        return 8;
    }
    public void gyroTelementary() {
        telemetry.addData("Velocity", getVelocity());
        telemetry.addData("Orientation", getOrientation());
    }

    public float getOrientation() {
        return imu.getAngularOrientation().firstAngle;
    }

    public float getVelocity() {

        //pytha for magnitude
        return (float) Math.sqrt((float) ((imu.getVelocity().xVeloc * imu.getVelocity().xVeloc) +
                (imu.getVelocity().yVeloc * imu.getVelocity().yVeloc)));
    }



}
