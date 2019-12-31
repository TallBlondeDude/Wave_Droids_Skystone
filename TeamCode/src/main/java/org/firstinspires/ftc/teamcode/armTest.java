package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Arm Test", group = "Linear Opmode")
public class armTest extends LinearOpMode {
    org.firstinspires.ftc.teamcode.Robot_Parts.Moters Moters;
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Started", "True");
        telemetry.update();
        DcMotor upperArmMotor = hardwareMap.get(DcMotor.class, "upperArmMotor");
        DcMotor lowerArmMotor = hardwareMap.get(DcMotor.class, "lowerArmMotor");
        lowerArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lowerArmMotor.setTargetPosition(100);
        lowerArmMotor.setPower(.4);
        lowerArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(lowerArmMotor.getCurrentPosition() != lowerArmMotor.getTargetPosition()){
            telemetry.addData("position", lowerArmMotor.getCurrentPosition());
            telemetry.update();
        }
        lowerArmMotor.setTargetPosition(0);
        while(lowerArmMotor.getCurrentPosition() != lowerArmMotor.getTargetPosition()){
            telemetry.addData("position", lowerArmMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}
