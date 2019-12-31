package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.internal.camera.libuvc.nativeobject.LibUsbDevice;
@TeleOp(name = "Back R test", group = "Linear Opmode")
public class backRightMotor extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor backRight =  hardwareMap.get(DcMotor.class, "backRightDrive");
        backRight.setPower(1);
    }
}