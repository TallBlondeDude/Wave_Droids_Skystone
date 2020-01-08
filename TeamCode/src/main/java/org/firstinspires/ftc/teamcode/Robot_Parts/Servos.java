package org.firstinspires.ftc.teamcode.Robot_Parts;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {
    // servo variables
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

    // sets the position of the plate servos
    public void setPlateServoPos(double position) {

        if (position == 1) {
            rightPlateServo.setPosition(1);
            leftPlateServo.setPosition(0);
        }
        else{
                rightPlateServo.setPosition(0);
                leftPlateServo.setPosition(1);
        }
    }

    // sets the position and direction of the grabber servo
    public void setGrabberServo(double power) {
        if (Math.abs(power) != power) {
            grabberServo.setDirection(Servo.Direction.REVERSE);
        } else {
            grabberServo.setDirection(Servo.Direction.FORWARD);
        }
        grabberServo.setPosition(Math.abs(power));
    }

    // sets the position of the inOut mode servo
    public void setInOutServo(double position) {
        inOutServo.setPosition(position);
    }

    // sets the position of the modeArm servo
    public void setModeArmServo(double position) {
        modeArmServo.setPosition(position);
    }

    // sets the plate servos at their starting positions
    public void Halt() {
        rightPlateServo.setPosition(.5);
        leftPlateServo.setPosition(.5);
    }
}
