package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {
    public Servo rightPlateServo;
    public Servo leftPlateServo;

    public Servos(Servo rightPlateServo, Servo leftPlateServo) {
        this.leftPlateServo = leftPlateServo;
        this.rightPlateServo = rightPlateServo;
    }

    public void setPlateServoPos(int position) {
        rightPlateServo.setPosition(position);
        leftPlateServo.setPosition(position);
    }
}
