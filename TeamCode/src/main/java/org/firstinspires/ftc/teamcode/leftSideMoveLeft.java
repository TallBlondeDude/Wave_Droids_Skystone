package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@Autonomous(name = "Backwards on Left Side, Fowards on Right", group = "Iterative Opmode")
public class leftSideMoveLeft extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initalizes the motors and the wheels
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));

        // sets the motors in autonomnous mode for encoders and the direction
        Moters.setAutoMode();
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        // robot goes forwards if on the right side, backwards on the left side
        Wheels.Drive(0 / 2, 0, 60);
        sleep(500);
        // robot stops
        Moters.Halt();


    }


}

