package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class Color_Sensor extends OpMode {
    ColorSensor color_sensor;

    // pointless stuff that is needed
    @Override
    public void init() {
        color_sensor = hardwareMap.colorSensor.get("color");

    }

    @Override
    public void loop() {

    }

    public String Color() {
        String color = "None";
        // If blue * green is greater then the red GRB Value, return red
        if (color_sensor.blue() * color_sensor.green() < color_sensor.red()) {
            color = "Red";
        }
        // same, but its red * green <
        else if (color_sensor.red() * color_sensor.green() < color_sensor.blue()) {
            color = "Blue";
        }
        return color;
    }
}
