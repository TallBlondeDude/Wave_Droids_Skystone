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
    double armExtendOrRetractTime =  4;
    Robot_Techniques Technique;

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

    public void DropGrabedBlock(){
        Arm.SetPosition(Technique.halfArmPosition);
        Technique.Pause(armExtendOrRetractTime/2);
        Claw.SetPosition(Technique.openClawPosition);
        Arm.SetPosition(Technique.closedArmPosition);
        Technique.Pause(armExtendOrRetractTime/2);

    }
    public void GrabBlock(){
        Claw.SetPosition(Technique.openClawPosition);
        Arm.SetPosition(Technique.extendedArmPosition);
        Technique.Pause(armExtendOrRetractTime);
        Claw.SetPosition(Technique.closedClawPosition);
        Arm.SetPosition(Technique.closedArmPosition);
        Technique.Pause(armExtendOrRetractTime);

    }
    public void Pause(double Time){
        ElapsedTime Timer = new ElapsedTime();
        while (Timer.time() < Time);
        {
            ///wait function placeholder as I don't get them
        }

    }
}
