package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Moters extends LinearOpMode {
    Moters Moters;

    public DcMotor frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
    public DcMotor frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
    public DcMotor backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
    public DcMotor backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
    //public DcMotor ArmScrew = hardwareMap.get(DcMotor.class, "ArmScrew");
    //public DcMotor leftWheel = hardwareMap.get(DcMotor.class, "leftWheel");
    //public DcMotor rightWheel = hardwareMap.get(DcMotor.class, "rightWheel");


    public void Halt() {
        Moters.backLeftDrive.setPower(0);
        Moters.frontLeftDrive.setPower(0);
        Moters.frontRightDrive.setPower(0);
        Moters.backRightDrive.setPower(0);
        //   Moters.ArmScrew.setPower(0);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
