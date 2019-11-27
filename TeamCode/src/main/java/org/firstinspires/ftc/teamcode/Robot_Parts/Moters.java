package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class Moters {
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor armMotor;
    public DcMotor leftIntake;
    public DcMotor rightIntake;
    private int backLeftTarget;
    private int frontLeftTarget;
    private int backRightTarget;
    private int frontRightTarget;
    // public DcMotor armMotor;
    public Moters(DcMotor frontLeftDrive, DcMotor frontRightDrive, DcMotor backLeftDrive, DcMotor backRightDrive, DcMotor armMotor,
                  DcMotor leftIntake, DcMotor rightIntake) {
        this.frontLeftDrive = frontLeftDrive;
        this.frontRightDrive = frontRightDrive;
        this.backLeftDrive = backLeftDrive;
        this.backRightDrive = backRightDrive;
        this.armMotor = armMotor;
        this.leftIntake = leftIntake;
        this.rightIntake = rightIntake;
    }

    public void setTargetPositionWheels(int target) {
        backLeftDrive.setTargetPosition(target + backLeftDrive.getCurrentPosition());
        frontRightDrive.setTargetPosition(target + frontRightDrive.getCurrentPosition());
        backRightDrive.setTargetPosition(target + backRightDrive.getCurrentPosition());
        frontLeftDrive.setTargetPosition(target + frontLeftDrive.getCurrentPosition());
    }

    public void setTargetPositionWheelsCrabwalk(int target) {
        backLeftTarget = (target) + backLeftDrive.getCurrentPosition();
        frontRightTarget = (target) + backLeftDrive.getCurrentPosition();
        frontLeftTarget = (target) + backLeftDrive.getCurrentPosition();
        backRightTarget = (target) + backLeftDrive.getCurrentPosition();
        backLeftDrive.setTargetPosition(backLeftTarget);
        frontLeftDrive.setTargetPosition(frontLeftTarget);
        backRightDrive.setTargetPosition(backRightTarget);
        frontRightDrive.setTargetPosition(frontRightTarget);
        while (backLeftDrive.getCurrentPosition() != backLeftTarget && backRightDrive.getCurrentPosition() != backRightTarget &&
                frontLeftDrive.getCurrentPosition() != frontLeftTarget && frontRightDrive.getCurrentPosition() != frontRightTarget) {
            if (Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition()) > Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                backLeftDrive.setPower(backLeftDrive.getPower() * .9);
            } else if (backLeftTarget - backLeftDrive.getCurrentPosition() < Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                frontLeftDrive.setPower(frontLeftDrive.getPower() * .9);
            }
            if (frontRightTarget - frontRightDrive.getCurrentPosition() > backRightTarget - backRightDrive.getCurrentPosition()) {
                frontRightDrive.setPower(frontRightDrive.getPower() * .9);

            } else if (frontRightTarget - frontRightDrive.getCurrentPosition() < backRightTarget - backRightDrive.getCurrentPosition()) {
                backRightDrive.setPower(backRightDrive.getPower() * .9);

            }
            if (frontRightTarget - frontRightDrive.getCurrentPosition() < frontLeftTarget - frontLeftDrive.getCurrentPosition()) {
                frontLeftDrive.setPower(frontLeftDrive.getPower() * .9);
            } else if (frontRightTarget - frontRightDrive.getCurrentPosition() > frontLeftTarget - frontLeftDrive.getCurrentPosition()) {
                frontRightDrive.setPower(frontRightDrive.getPower() * .9);
            }
            if (backRightTarget - backRightDrive.getCurrentPosition() < backLeftTarget - backLeftDrive.getCurrentPosition()) {
                backLeftDrive.setPower(backLeftDrive.getPower() * .9);
            } else if (backRightTarget - backRightDrive.getCurrentPosition() > backLeftTarget - backLeftDrive.getCurrentPosition()) {
                backRightDrive.setPower(backRightDrive.getPower() * .9);
            }
        }
        backLeftDrive.setTargetPosition(backLeftTarget);
        frontRightDrive.setTargetPosition((int) (.7 * -target) + frontRightDrive.getCurrentPosition());
        backRightDrive.setTargetPosition(target + backRightDrive.getCurrentPosition());
        frontLeftDrive.setTargetPosition(-target + frontLeftDrive.getCurrentPosition());
    }

    public void setWheelPower(double power) {
        backLeftDrive.setPower(power);
        frontRightDrive.setPower(.9 * power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(.9 * power);
    }

    public void setWheelPowerCrabwalk(double power) {
        backLeftDrive.setPower(.7 * power);
        frontRightDrive.setPower(.7 * power);
        frontLeftDrive.setPower(power);
        backRightDrive.setPower(power);
    }

    public void stopAndResetEncoders() {
        backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setTargetPositionArm(int position) {
        armMotor.setTargetPosition(position);

    }
    public void setTeleMode() {
        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setAutoMode() {
        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setTargetPosition(backRightDrive.getCurrentPosition());
        frontRightDrive.setTargetPosition(frontRightDrive.getCurrentPosition());
        backLeftDrive.setTargetPosition(backLeftDrive.getCurrentPosition());
        frontLeftDrive.setTargetPosition(frontLeftDrive.getCurrentPosition());
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        stopAndResetEncoders();
        backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void Halt() {
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backRightDrive.setPower(0);
        backLeftDrive.setPower(0);
    }



}
