package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private int ticksPerInch = 2000;
    private Moters Moters;
    private Telemetry telemetry;
    private double gravity = 0;
    private Servos Servos;
    public double targetPositionArm;

    public Arm(Moters A, Telemetry t, Servos s) {
        Moters = A;
        Servos = s;
        telemetry = t;
        targetPositionArm = 0;
    }

    public void changeVerticalArmPos(double power) {
        Moters.armMotor.setPower(power + gravity);
        telemetry.addData("Arm Power", power);
        telemetry.update();
    }

    public void changeVerticalArmPos(double power, double inchesUp) {
        Moters.armMotor.setPower(power + gravity);
        this.targetPositionArm = Moters.armMotor.getCurrentPosition() + (int) (inchesUp * ticksPerInch);
        Moters.armMotor.setTargetPosition(Moters.armMotor.getCurrentPosition() + (int) (inchesUp * ticksPerInch));
        telemetry.addData("Arm Power", power);
        telemetry.addData("Target Position", (Moters.armMotor.getCurrentPosition() + (int) (inchesUp * ticksPerInch)) / ticksPerInch);
        telemetry.update();
    }

    public void extendArm() {
        changeVerticalArmPos(1, 3);
        while (Moters.armMotor.getCurrentPosition() != targetPositionArm) {
        }
        Servos.setInOutServo(1);
        Servos.setModeArmServo(1);
    }

    public void grab() {
        Servos.setGrabberServo(1);
    }

    public void tighten() {
        Servos.setGrabberServo(0);
    }

    public void hold() {
        Servos.setGrabberServo(.5);
    }
}
