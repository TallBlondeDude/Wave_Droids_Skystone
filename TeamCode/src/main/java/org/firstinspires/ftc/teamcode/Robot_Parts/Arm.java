package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.teamcode.Robot_Parts.Moters;

public class Arm {
    // Stores the location of the arm for reference
    public int armPositionStorage;
    Moters Moters = null;

    // sets the arm position
    public void SetPosition(int armPosition) {
        Moters.ArmScrew.setTargetPosition(armPosition);
    }

}
