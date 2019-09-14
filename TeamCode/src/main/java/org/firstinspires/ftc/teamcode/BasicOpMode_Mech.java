package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Mechanum Two Joysick", group = "Iterative Opmode")
public class BasicOpMode_Mech extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private Controllers Gamepad = null;
    private Wheels Wheels = null;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        double polarAngle = Gamepad.polarAngle();
        double polarMagnitude = Gamepad.polarMagnitude();
        telemetry.addData("Direction in Radians", "Angle: " + polarAngle);
        telemetry.addData("Speed in Percentage", polarMagnitude);
        Wheels.Drive(polarAngle, gamepad1.right_stick_x, polarMagnitude);
        }



    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}

