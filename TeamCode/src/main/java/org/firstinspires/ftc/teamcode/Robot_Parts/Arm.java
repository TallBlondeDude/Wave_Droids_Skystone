package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;

public class Arm {

    public void SetPosition(int armPosition) {
        Moters Moters = null;
        int adjustment = armPosition - Moters.ArmScrew.getCurrentPosition();
        Moters.ArmScrew.setTargetPosition(Moters.ArmScrew.getCurrentPosition() + adjustment);
    }

}
