package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Controllers{
    private Controllers controller;
    private int armRaiseSpeed;
    private Gamepad gamepad1;
    private Wheels wheels;
    private Servos Servos;
    private Gamepad gamepad2;
    Moters Moters;
    private Arm Arm;
    Telemetry telemetry;

    public Controllers(Controllers a, Gamepad b, Wheels c, Servos d, Gamepad f, Arm g, Telemetry telemetry, Moters Moters) {
        armRaiseSpeed = 5;
        controller = a;
        gamepad1 = b;
        gamepad2 = f;
        wheels = c;
        Arm = g;
        Servos = d;
        this.telemetry = telemetry;
        this.Moters = Moters;
    }

    public void UpdateMovement() {
        if (gamepad1.a) {
            AButtonGamepad1();
        }
        if (gamepad1.b) {
            BButtonGamepad1();
        }
        BackBumpersGamepad2();
        armSpeedDetector();
        if (gamepad2.a) {
            Servos.setInOutServo(1);
        } else if (gamepad2.b) {
            Servos.setInOutServo(0);
        }
        if (gamepad2.x) {
            Servos.setModeArmServo(1);
        } else if (gamepad2.y) {
            Servos.setModeArmServo(0);
        }
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
        return magnitude / 1.1;
    }

    public void armSpeedDetector() {
        Arm.changeVerticalArmPos(gamepad2.left_stick_x);
    }

    //finds angle with true right being 0 degrees
    public double polarAngle() {
        double xcord = gamepad1.left_stick_x;
        double ycord = gamepad1.left_stick_y;
        // inverse tangent
        double theta = Math.atan2(xcord, ycord);
        return (theta - 1.57079);

    }

    public void BackBumpersGamepad2() {
        if (gamepad2.left_bumper) {
            Arm.tighten();
        } else if (gamepad2.right_bumper) {
            Arm.grab();
        } else {
            Arm.hold();
        }
        telemetry.addData("Back Bumper", Moters.armMotor.getPower());
    }

    public void AButtonGamepad1() {
        Servos.setPlateServoPos(1);
        telemetry.addData("A Button Pressed", "true");
    }

    public void BButtonGamepad1() {
        Servos.setPlateServoPos(0);
        telemetry.addData("B Button Pressed", "true");
    }
}
