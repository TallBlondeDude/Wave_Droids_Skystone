package org.firstinspires.ftc.teamcode.Robot_Parts;

public class Servo_Latch {
    Servos servos = null;

    public void unlatchBackServos() {
        servos.rightLatchServo.setPosition(1);
        servos.leftLatchServo.setPosition(1);

    }

    public void latchBackServos() {
        servos.leftLatchServo.setPosition(0);
        servos.rightLatchServo.setPosition(0);
    }
}
