package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot_Parts.*;

@TeleOp(name = "Servo Test", group = "Iterative Opmode")
public class servo_test extends LinearOpMode {
    // Declare OpMode members.

    public Servo servo1;
    public Servo servo2;
    public Servo servo3;
    @Override
    public void runOpMode() throws InterruptedException {
       // servo1 = hardwareMap.get(Servo.class, "leftPlateServo");
       // servo2 = hardwareMap.get(Servo.class, "rightPlateServo");

        servo1 = hardwareMap.get(Servo.class, "inOutServo");
        servo2 = hardwareMap.get(Servo.class, "grabberServo");
        servo3 = hardwareMap.get(Servo.class, "modeArmServo");
        servo3.setPosition(.5);
        servo2.setPosition(.4);
    //   servo1.setPosition(0);

        telemetry.addData("Servo", "0");
        telemetry.update();
        sleep(5000);
        servo3.setPosition(.0);
        servo2.setPosition(.0);
       //servo1.setPosition(.0);

        telemetry.addData("Servo", "0");
        telemetry.update();
       sleep(5000);
        servo3.setPosition(1);
        servo2.setPosition(0);
      //  servo1.setPosition(.5);

        telemetry.addData("Servo", "1~");
        telemetry.update();
        sleep(3000);

    }


}

