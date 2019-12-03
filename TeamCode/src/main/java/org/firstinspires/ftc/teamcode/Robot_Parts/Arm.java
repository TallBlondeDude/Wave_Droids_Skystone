package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private int ticksPerInch = 2000;
    private Moters Moters;
    private Telemetry telemetry;
    private double gravity = 0;
    private Servos ArmServos;
    public double targetPositionArm;

    public Arm(Moters A, Telemetry t, Servos s) {
        Moters = A;
        ArmServos = s;
        telemetry = t;
        targetPositionArm = 0;
    }

    public void changeVerticalArmPos(double power) {
        Moters.armMotorUpper.setPower(power);
        Moters.armMotorLower.setPower(power);
        Moters.setTargetPositionArm((int) (power * 10));
        telemetry.addData("Arm Power", power);
        telemetry.update();
    }

    public void changeVerticalArmPos(double power, double armPos) {
        Moters.armMotorUpper.setPower(power + gravity);
        Moters.armMotorLower.setTargetPosition();
        telemetry.addData("Arm Power", power);
        telemetry.addData("Target Position", (Moters.armMotor.getCurrentPosition() + (int) (inchesUp * ticksPerInch)) / ticksPerInch);
        telemetry.update();
    }

    public void loosen() {
        ArmServos.setGrabberServo(1);
    }

    public void tighten() {
        ArmServos.setGrabberServo(0);
    }

    public void hold() {
        ArmServos.setGrabberServo(.5);
    }
}
