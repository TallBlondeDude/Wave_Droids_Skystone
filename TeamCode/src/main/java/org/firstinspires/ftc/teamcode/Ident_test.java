package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot_Parts.Webcam;

public class Ident_test extends OpMode {
    Webcam Camera = null;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        telemetry.addData("Locations", Camera.LocateSkystones());
    }
}
