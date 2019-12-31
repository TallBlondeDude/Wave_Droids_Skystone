package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@Autonomous(name = "Crabwalk Right", group = "Iterative Opmode")
public class rightsideBasic extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;
    public void runOpMode() throws InterruptedException {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));

        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Moters.setAutoMode();
        Moters.setTargetPositionWheels(2000);
        Moters.setWheelPower(1);
        sleep(1000);
        while(Moters.backLeftDrive.getCurrentPosition() != Moters.backLeftDrive.getTargetPosition()) {
            telemetry.addData("Front Left Encoder", Moters.frontLeftDrive.getCurrentPosition());
            telemetry.addData("Back Left Encoder", Moters.backLeftDrive.getCurrentPosition());
            telemetry.addData("Front Right Encoder", Moters.frontRightDrive.getCurrentPosition());
            telemetry.addData("Back Right Encoder", -Moters.backRightDrive.getCurrentPosition());
            telemetry.update();
        }

        Moters.Halt();
    }


}

