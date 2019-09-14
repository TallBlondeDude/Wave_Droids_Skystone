package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;


public class Blue_Skystone_Side_Autonomous extends OpMode {
    @Override
    public void init() {
        Wheels Wheels = null;
        Webcam Camera = null;
        Claw Claw = null;
        Color_Sensor Color_Sensor = null;

        Webcam.FindSkystones();
        angle = "x degrees + ay"
        Wheels.Drive(angle, 0, 1);
        wait(time based on distance to stone);
        Wheels.Stop();
        // reach out and grab brick, then pull it back
        Arm.SetPostion(Extended);
        Claw.SetPostion(Closed);
        Arm.SetPosition(Retracted);

        /// drive to the building side based on where you came from
        Wheels.Drive(0, 0, 1);
        wait(time based on stone #);
        Wheels.Stop;
        /// drop brick
        Arm.SetPosition(Half Extended);
        Claw.SetPosition(Open);
        Arm.SetPosition(Closed);
        /// head back to the other brick, as found in Webcam.Skystone2
        Wheels.Drive(3.1415, 0, 1);
        wait(time based on distance to stone # 2);
        Wheels.Stop();
        /// grab the brick
        Arm.SetPostion(Extended);
        Claw.SetPostion(Closed);
        Arm.SetPosition(Retracted);
        /// head back over to building side
        Wheels.Drive(0, 0, 1);
        wait(time based on stone #);
        Wheels.Stop();
        Arm.SetPosition(Half Extended);
        Claw.SetPosition(Open);
        Arm.SetPosition(Closed);
        while (Color_Sensor.Color() != "Blue"){
            Wheels.Drive(3.1415, 0, 1);

        Wheels.Stop;

        }







    }

    @Override
    public void loop() {

    }

}
