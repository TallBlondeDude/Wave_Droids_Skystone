package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {
    public Servo rightPlateServo;
    public Servo leftPlateServo;
    public Servo grabberServo;
    public Servo rotationHorizontal;
    public Servo rotationVertical;

    public Servos(Servo rightPlateServo, Servo leftPlateServo, Servo grabberServo,  Servo rotationHorizontal,  Servo rotationVertical ) {
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
        rotationHorizontalServo.setPostion(.5);
        rotationVerticalServo.setPostion(.5);
        grabberServo.setPostion(.5);
    }
}
