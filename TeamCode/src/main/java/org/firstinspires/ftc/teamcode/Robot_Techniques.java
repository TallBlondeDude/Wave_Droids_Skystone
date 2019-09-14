package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;

public class Robot_Techniques extends OpMode {
    Claw Claw = null;
    Arm Arm = null;
    int extendedArmPosition = 100;
    int halfArmPosition = 50;
    int closedArmPosition = 0;
    double openClawPosition = 1;
    double closedClawPosition = 0;
    double waitTime =  4;
    Robot_Techniques Technique;

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

    public void DropGrabedBlock(){
        Arm.SetPosition(Technique.halfArmPosition);
        Claw.SetPosition(Technique.openClawPosition);
        Arm.SetPosition(Technique.closedArmPosition);

    }
    public void GrabBlock(){
        ElapsedTime Timer = new ElapsedTime();
        Claw.SetPosition(Technique.openClawPosition);
        Arm.SetPosition(Technique.extendedArmPosition);
        Timer.reset();
        while (Timer.time() < Technique.waitTime);{
        ///wait function placeholder as I don't get them
        }
        Claw.SetPosition(Technique.closedClawPosition);
        Arm.SetPosition(Technique.closedArmPosition);

    }
}
