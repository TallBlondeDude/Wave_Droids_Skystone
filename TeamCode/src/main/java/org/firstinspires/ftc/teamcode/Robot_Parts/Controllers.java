package org.firstinspires.ftc.teamcode.Robot_Parts;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Controllers extends LinearOpMode {
    // Initialize variables
    Controllers controller;
    int armRaiseSpeed = 5;
    Arm arm;
    Claw claw;
    Wheel_Intake Wheel_Intake;

    public Controllers() {
    }

    //useless
    @Override
    public void runOpMode() throws InterruptedException {
    }

    public void UpdateMovement() {
        BackBumpers();
        BackTriggers();
        AButton();
    }

    //Finds distance between 0, 0 and the joysticks location
    public double polarMagnitude() {
        //grab coordinates of joystick
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        //square them
        double squareX = xcord * xcord;
        double squareY = ycord * ycord;
        //Find the sqrt
        double magnitude = Math.sqrt(squareY + squareX);
        return magnitude;
    }

    //finds angle with true right being 0 degrees
    public double polarAngle() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        // inverse tangent
        double theta = Math.atan2(xcord, ycord);
        return theta;
    }

    public void BackBumpers() {
        if (gamepad1.dpad_down) {
            claw.SetClawPosition(100);
        } else if (gamepad1.dpad_up) {
            claw.SetClawPosition(0);
        }
    }

    public void AButton() {
        if (gamepad1.a) {
            if (Wheel_Intake.currentState == "On" || gamepad1.timestamp > (Wheel_Intake.lastChange)) {
                Wheel_Intake.currentState = "False";
                Wheel_Intake.wheelSetPower(0);
                Wheel_Intake.lastChange = gamepad1.timestamp;
            } else {
                Wheel_Intake.currentState = "On";
                Wheel_Intake.wheelSetPower(1);
                Wheel_Intake.lastChange = gamepad1.timestamp;
            }
        }

    }

    public void BackTriggers() {
        if (gamepad2.left_bumper) {
            arm.SetPosition(arm.armPositionStorage + controller.armRaiseSpeed);
        } else if (gamepad2.right_bumper) {
            arm.SetPosition(controller.armRaiseSpeed * -1 + arm.armPositionStorage);
        }
    }
}
