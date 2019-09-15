package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;

public class Arm {
    public int armPositionStorge;
    Moters Moters = null;
    public void SetPosition(int armPosition) {
        armPositionStorge = armPosition;
        int adjustment = armPosition - Moters.ArmScrew.getCurrentPosition();
        Moters.ArmScrew.setTargetPosition(Moters.ArmScrew.getCurrentPosition() + adjustment);
    }

}
