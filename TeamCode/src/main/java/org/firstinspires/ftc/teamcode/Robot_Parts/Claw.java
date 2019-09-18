package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.teamcode.Robot_Parts.Servos;
public class Claw {
    Servos Servos = null;

    public void SetClawPosition(double clawPostion) {
        Servos.backClawServo.setPosition(clawPostion);
        Servos.frontClawServo.setPosition(clawPostion);

    }
}
