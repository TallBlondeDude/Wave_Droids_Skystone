package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {
    private Servo rightPlateServo;
    private Servo leftPlateServo;

    public Servos(Servo rightPlateServo, Servo leftPlateServo) {
        this.leftPlateServo = leftPlateServo;
        this.rightPlateServo = rightPlateServo;
    }

    public void setPlateServoPos(double position) {
        rightPlateServo.setPosition(position);
        leftPlateServo.setPosition(position);
    }

    public void Halt() {
        rightPlateServo.setPosition(.5);
        leftPlateServo.setPosition(.5);
    }
}
