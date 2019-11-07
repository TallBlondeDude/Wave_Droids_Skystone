package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    Moters Moters;
    Telemetry telemetry;
    double gravity = .1;
    public Arm(Moters A, Telemetry t) {
        Moters = A;
        telemetry = t;
    }
    public void changeArmPos(power){
        Moters.armMotor.setPower(power+gravity);
        telemetry.addData("Arm Power (will go over 1)", power);
        telemetry.update();
    }
}
