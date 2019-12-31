package org.firstinspires.ftc.teamcode.Robot_Parts;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private int ticksPerInch = 2000;
    private Moters Moters;
    private Telemetry telemetry;
    private double gravity = 0;
    private Servos ArmServos;
    public double targetPositionArm;
    private int encoderTicksBottomShaft = 100;

    int motorPickUpper(double pos) {
        if ((pos * ticksPerInch) - encoderTicksBottomShaft > 0) {
            return (int) ((pos * ticksPerInch) - encoderTicksBottomShaft);
        } else {
            return 0;
        }
    }

    int motorPickLower(double pos) {
        if ((pos * ticksPerInch) - encoderTicksBottomShaft > 0) {
            return encoderTicksBottomShaft;
        } else {
            return (int) (encoderTicksBottomShaft * pos);
        }
    }
    public Arm(Moters A, Telemetry t, Servos s) {
        Moters = A;
        ArmServos = s;
        telemetry = t;
        targetPositionArm = 0;
    }

    public void changeVerticalArmPosL(double power) {
        Moters.lowerArmMotor.setPower(power);
       // Moters.upperArmMotor.setPower(power);
        telemetry.addData("Arm Power", power);
        telemetry.update();
    }
    public void changeVerticalArmPosU(double power) {
        //Moters.lowerArmMotor.setPower(power);
        Moters.upperArmMotor.setPower(power);
        telemetry.addData("Arm Power", power);
        telemetry.update();
    }

    public void changeVerticalArmPos(double power, double armPos) {
       // Moters.upperArmMotor.setPower(power + gravity);
        Moters.lowerArmMotor.setPower(power + gravity);
        Moters.lowerArmMotor.setTargetPosition(motorPickLower(armPos));
      //  Moters.upperArmMotor.setTargetPosition(motorPickUpper(armPos));
        telemetry.addData("Arm Power Lower", power);
        //  telemetry.addData("Target Position", (Moters.armMotor.getCurrentPosition() + (int) (inchesUp * ticksPerInch)) / ticksPerInch);
        telemetry.update();
    }
   // public void changeVerticalArmPosR(double power, double armPos) {
     //   Moters.upperArmMotor.setPower(power + gravity);
       // Moters.upperArmMotor.setTargetPosition(motorPickUpper(armPos));
        //telemetry.addData("Arm Power Lower", power);
        //  telemetry.addData("Target Position", (Moters.armMotor.getCurrentPosition() + (int) (inchesUp * ticksPerInch)) / ticksPerInch);
       // telemetry.update();
    //}

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
