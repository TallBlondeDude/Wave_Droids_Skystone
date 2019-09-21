package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot_Techniques;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;


public class Blue_Skystone_Side_Autonomous extends OpMode {
    @Override

    public void init() {
        // initialize variables
        Wheels Wheels = null;
        Webcam Camera = null;
        Claw Claw = null;
        Color_Sensor Color_Sensor = null;
        Robot_Techniques Techniques = null;
        double[] skystones = Camera.LocateSkystones();
        // find the angle to go to the skystone
        Wheels.DriveDistance(Techniques.FindDirection(skystones[0]), .8, Techniques.FindDistance(skystones[0]));
        ///ENCODER FUN :)
        //
        Wheels.Stop();
        // reach out and grab brick, then pull it back
        Techniques.GrabBlock();

        /// drive to the building side based on where you came from
        Wheels.Drive(0, 0, 1);
        ///ENCODER FUN :)
        //
        Wheels.Stop();
        /// drop brick
        Techniques.DropGrabedBlock();
        /// head back to the other brick, as found in Webcam.Skystone2
        Wheels.Drive(3.1415, 0, 1);
        ///ENCODER FUN :)
        Wheels.Stop();
        /// grab the brick
        Techniques.GrabBlock();
        /// head back over to building side
        Wheels.Drive(0, 0, 1);
        ///ENCODER FUN :)
        Wheels.Stop();
        Techniques.DropGrabedBlock();
        while (Color_Sensor.Color() != "Blue") {
            Wheels.Drive(3.1415, 0, 1);

        }
        Wheels.Stop();


    }

    private Moters AllMoters = null;
    private ElapsedTime TimePassed = new ElapsedTime();

    @Override
    public void loop() {
        if (TimePassed.time() > 28) {
            AllMoters.Halt();
        }

    }

}
