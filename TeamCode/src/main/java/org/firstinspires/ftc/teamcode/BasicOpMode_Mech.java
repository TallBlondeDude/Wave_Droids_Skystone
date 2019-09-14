package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

@TeleOp(name = "Mechanum Two Joysick", group = "Iterative Opmode")
public class BasicOpMode_Mech extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
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
        //Readout of the joysticks
        telemetry.addData("Left Joystick (x, y)", "(" + gamepad1.left_stick_x + "," + gamepad1.left_stick_y + ")");
        telemetry.addData("Right Joystick (x, y)", "(" + gamepad1.right_stick_x + "," + gamepad1.right_stick_y + ")");
        //varible for the joystick location for easy access
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        double turningXcord = gamepad1.right_stick_x;
        //square values
        double squareX = xcord * xcord;
        double squareY = ycord * ycord;
        //distance formula to find Magnitude
        double magnitude = Math.sqrt(squareY + squareX);
        //find theta using inverse tangent
        double theta = Math.atan2(xcord, ycord);
        Wheels.Drive(theta, turningXcord, 1);
        }


        // Send calculated power to wheels, inversion is due to battery power flow & wheel location
        frontRightDrive.setPower(-1 * wheelsSetB);
        backRightDrive.setPower(-1 * wheelsSetA);
        backLeftDrive.setPower(wheelsSetB);
        frontLeftDrive.setPower(wheelsSetA);

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}

