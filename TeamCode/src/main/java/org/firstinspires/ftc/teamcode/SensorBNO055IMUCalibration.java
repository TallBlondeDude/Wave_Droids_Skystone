package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ReadWriteFile;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

import java.io.File;
import java.util.Locale;

@TeleOp(name = "Sensor: BNO055 IMU Calibration", group = "Sensor")
public class SensorBNO055IMUCalibration extends LinearOpMode {
    //----------------------------------------------------------------------------------------------
    // State
    //----------------------------------------------------------------------------------------------

    // Our sensors, motors, and other devices go here, along with other long term state
    BNO055IMU imu;

    // State used for updating telemetry

    Orientation angles;

    //----------------------------------------------------------------------------------------------
    // Main logic
    //----------------------------------------------------------------------------------------------

    @Override
    public void runOpMode() {

        telemetry.log().setCapacity(12);
        telemetry.log().add("");
        telemetry.log().add("Please refer to the calibration instructions");
        telemetry.log().add("contained in the Adafruit IMU calibration");
        telemetry.log().add("sample opmode.");
        telemetry.log().add("");
        telemetry.log().add("When sufficient calibration has been reached,");
        telemetry.log().add("press the 'A' button to write the current");
        telemetry.log().add("calibration data to a file.");
        telemetry.log().add("");

        // We are expecting the IMU to be attached to an I2C port on a Core Device Interface Module and named "imu".
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        telemetry.log().add("Waiting for start...");

        // Wait until we're told to go
        while (!isStarted()) {
            telemetry.update();
            idle();
        }

        telemetry.log().add("...started...");

        while (opModeIsActive()) {

            if (gamepad1.a) {

                // Get the calibration data
                BNO055IMU.CalibrationData calibrationData = imu.readCalibrationData();

                // Save the calibration data to a file. You can choose whatever file
                // name you wish here, but you'll want to indicate the same file name
                // when you initialize the IMU in an opmode in which it is used. If you
                // have more than one IMU on your robot, you'll of course want to use
                // different configuration file names for each.
                String filename = "AdafruitIMUCalibration.json";
                File file = AppUtil.getInstance().getSettingsFile(filename);
                ReadWriteFile.writeFile(file, calibrationData.serialize());
                telemetry.log().add("saved to '%s'", filename);

                // Wait for the button to be released
                while (gamepad1.a) {
                    telemetry.update();
                    idle();
                }
            }

            telemetry.update();
        }
    }

}
