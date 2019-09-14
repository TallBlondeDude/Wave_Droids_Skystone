package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Moters extends LinearOpMode {

    public DcMotor frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
    public DcMotor frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
    public DcMotor backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
    public DcMotor backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
