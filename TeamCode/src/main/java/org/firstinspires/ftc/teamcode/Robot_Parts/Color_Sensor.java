package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class Color_Sensor extends OpMode {
    ColorSensor color_sensor;

    // pointless stuff that is needed
    @Override
    public void init() {
    }

    @Override
    public void loop() {

    }

    public String Color() {
        // reset the variable name
        String color = "None";
        //
        color_sensor = hardwareMap.colorSensor.get("color");
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
