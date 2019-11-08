package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private Moters Moters;
    private Telemetry telemetry;
    private double gravity = 0;
    public Arm(Moters A, Telemetry t) {
        Moters = A;
        telemetry = t;
    }

    public void changeVerticalArmPos(double power) {
        Moters.armMotor.setPower(power + gravity);
        telemetry.addData("Arm Power", power);
        telemetry.update();
    }
}
