package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;
import org.firstinspires.ftc.teamcode.Robot_Parts.Wheels;

@Autonomous(name = "Move Foward", group = "Iterative Opmode")
public class PID_TEST extends LinearOpMode {
    // Declare OpMode members.
    public Moters Moters;
    public Wheels Wheels;

    @Override
    public void runOpMode() throws InterruptedException {
        Moters = new Moters(hardwareMap.get(DcMotor.class, "frontLeftDrive"),
                hardwareMap.get(DcMotor.class, "frontRightDrive"), hardwareMap.get(DcMotor.class,
                "backLeftDrive"), hardwareMap.get(DcMotor.class, "backRightDrive"),
                hardwareMap.get(DcMotor.class, "upperArmMotor"), hardwareMap.get(DcMotor.class, "lowerArmMotor"),
                hardwareMap.get(DcMotor.class, "leftIntake"),
                hardwareMap.get(DcMotor.class, "rightIntake"));
        Moters.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Moters.backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        Moters.backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        Moters.frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
       // Moters.frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
     //   Moters.backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      //  Moters.backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      //  Moters.frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        double fowardStrafeMod = 1;
        double backStrafeMod = .66;
        double leftMod = .785;
        double rightMod = 1;
        double backLeftPower = leftMod * backStrafeMod * .9;
        double backRightPower = rightMod * fowardStrafeMod;
        double frontLeftPower =  leftMod * fowardStrafeMod;
        double frontRightPower = rightMod * backStrafeMod * .9;
        Wheels = new Wheels(Moters, telemetry);
        waitForStart();
        Moters.backLeftDrive.setPower(-backLeftPower);
      //  Moters.frontRightDrive.setPower(-frontRightPower);
      //  Moters.backRightDrive.setPower(backRightPower);
      //  Moters.frontLeftDrive.setPower(frontLeftPower);

        sleep(2000);

        Moters.backLeftDrive.setPower(backLeftPower);
      //  Moters.frontRightDrive.setPower(frontRightPower);
     //   Moters.backRightDrive.setPower(backRightPower);
     //   Moters.frontLeftDrive.setPower(frontLeftPower);

        sleep(1500);
        Moters.Halt();

    }


}

