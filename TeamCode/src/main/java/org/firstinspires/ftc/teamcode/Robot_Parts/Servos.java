package org.firstinspires.ftc.teamcode.Robot_Parts;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {
    private Servo rightPlateServo;
    private Servo leftPlateServo;
    private Servo grabberServo;
    private Servo inOutServo;
    private Servo modeArmServo;


    public Servos(Servo rightPlateServo, Servo leftPlateServo, Servo grabberServo, Servo inOutServo, Servo modeArmServo) {
        this.leftPlateServo = leftPlateServo;
        this.rightPlateServo = rightPlateServo;
        this.grabberServo = grabberServo;
        this.inOutServo = inOutServo;
        this.modeArmServo = modeArmServo;
    }

    public void setPlateServoPos(double position) {
        rightPlateServo.setPosition(position);
        leftPlateServo.setPosition(position);
    }

    public void setGrabberServo(double power) {
        if (Math.abs(power) != power) {
            grabberServo.setDirection(Servo.Direction.REVERSE);
        } else {
            grabberServo.setDirection(Servo.Direction.FORWARD);
        }
        grabberServo.setPosition(Math.abs(power));
    }

    public void setInOutServo(double position) {
        inOutServo.setPosition(position);
    }

    public void setModeArmServo(double position) {
        modeArmServo.setPosition(position);
    }
    public void Halt() {
        rightPlateServo.setPosition(.5);
        leftPlateServo.setPosition(.5);
    }
}
