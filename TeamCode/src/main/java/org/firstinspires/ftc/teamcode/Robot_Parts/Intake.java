package org.firstinspires.ftc.teamcode.Robot_Parts;

import android.graphics.Path;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    private Telemetry telemetry;
    private Moters Motors;

    public Intake(Moters m, Telemetry t){
        telemetry = t;
        Motors = m;
    }

    public void IntakeGo(){
        Motors.leftIntake.setPower(1);
        Motors.rightIntake.setPower(-1);
        telemetry.addData("intake", "On");
    }
    public void IntakeStop(){
        Motors.leftIntake.setPower(0);
        Motors.rightIntake.setPower(0);
        telemetry.addData(" intake", "Stopped");
    }

}
