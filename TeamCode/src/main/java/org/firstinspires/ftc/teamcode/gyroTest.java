package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot_Parts.Gyroscope;

@Autonomous(name = "gyrotest", group = "Linear Opmode")
public class gyroTest extends LinearOpMode {
    Gyroscope Gyro;

    @Override
    public void runOpMode() throws InterruptedException {
        Gyro = new Gyroscope(hardwareMap.get(BNO055IMU.class, "imu"), 1, 1, telemetry);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);
        Gyro.gyroTelementary();
        telemetry.update();
        sleep(1000);

    }

}
