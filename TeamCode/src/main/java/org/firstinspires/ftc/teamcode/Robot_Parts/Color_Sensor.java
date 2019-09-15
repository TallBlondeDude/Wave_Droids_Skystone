package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

public class Color_Sensor extends OpMode {
    ColorSensor color_sensor = null;

    @Override
    public void init() {
        color_sensor = hardwareMap.colorSensor.get("color");

    }

    @Override
    public void loop() {

    }


    public String Color() {

        String color = "None";
        if (color_sensor.blue() * color_sensor.green() - 100 < color_sensor.red()) {
            color = "Red";
        } else if (color_sensor.red() * color_sensor.green() - 100 < color_sensor.blue()) {
            color = "Blue";
        }
        return color;
    }
}
