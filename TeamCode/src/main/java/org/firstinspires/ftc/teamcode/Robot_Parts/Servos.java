package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {
    private Servo rightPlateServo;
    private Servo leftPlateServo;
    private Servo grabberServo;
    private Servo rotationHorizontalServo;
    private Servo rotationVerticalServo;

    public Servos(Servo rightPlateServo, Servo leftPlateServo, Servo grabberServo, Servo rotationHorizontalServo, Servo rotationVerticalServo) {
        this.leftPlateServo = leftPlateServo;
        this.rightPlateServo = rightPlateServo;
        this.grabberServo = grabberServo;
        this.rotationHorizontalServo = rotationHorizontalServo;
        this.rotationVerticalServo = rotationVerticalServo;

    }

    public void setPlateServoPos(double position) {
        rightPlateServo.setPosition(position);
        leftPlateServo.setPosition(position);
    }

    public void Halt() {
        rightPlateServo.setPosition(.5);
        leftPlateServo.setPosition(.5);
        rotationHorizontalServo.setPosition(.5);
        rotationVerticalServo.setPosition(.5);
        grabberServo.setPosition(.5);
    }
}
