package org.firstinspires.ftc.teamcode.Robot_Parts;
import org.firstinspires.ftc.teamcode.Robot_Parts.Arm;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Controllers extends LinearOpMode {
    double xcord = gamepad1.left_stick_x;
    double ycord = gamepad1.left_stick_y;
    Controllers controller;
    int armRaiseSpeed = 5;
    Arm arm;
    Claw claw;
    @Override
    public void runOpMode() throws InterruptedException {
    }

    public double polarMagnitude() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        double squareX = xcord * xcord;
        double squareY = ycord * ycord;
        double magnitude = Math.sqrt(squareY + squareX);
        return magnitude;
    }

    public double polarAngle() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        double theta = Math.atan2(xcord, ycord);
        return theta;
    }
    public void BackBumpers(){
        if (gamepad2.dpad_down) {
            claw.SetPosition(100);
        } else if (gamepad1.dpad_up) {
            claw.SetPosition(0);
        }

    }
    public void BackTriggers() {
        if (gamepad2.left_bumper) {
            arm.SetPosition(arm.armPositionStorge + controller.armRaiseSpeed);
        } else if (gamepad2.right_bumper) {
            arm.SetPosition(controller.armRaiseSpeed * -1 + arm.armPositionStorge);
        }
    }
}
