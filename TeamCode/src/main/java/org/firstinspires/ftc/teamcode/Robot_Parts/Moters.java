package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


public class Moters {
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor lowerArmMotor;
    public DcMotor upperArmMotor;
    public DcMotor leftIntake;
    public DcMotor rightIntake;
    private int backLeftTarget;
    private int frontLeftTarget;
    private int backRightTarget;
    private int frontRightTarget;
    private int autoCorrectNumber;
    private double weakBackLeftPower;
    private double weakBackRightPower;
    private double weakFrontLeftPower;
    private double weakFrontRightPower;
    private double strongBackLeftPower;
    private double strongBackRightPower;
    private double strongFrontLeftPower;
    private double strongFrontRightPower;

    // public DcMotor armMotor;
    public Moters(DcMotor frontLeftDrive, DcMotor frontRightDrive, DcMotor backLeftDrive, DcMotor backRightDrive, DcMotor lowerArmMotor,
                  DcMotor upperArmMotor,
                  DcMotor leftIntake, DcMotor rightIntake) {
        this.frontLeftDrive = frontLeftDrive;
        this.frontRightDrive = frontRightDrive;
        this.backLeftDrive = backLeftDrive;
        this.backRightDrive = backRightDrive;
        this.upperArmMotor = upperArmMotor;
        this.lowerArmMotor = lowerArmMotor;
        this.leftIntake = leftIntake;
        this.rightIntake = rightIntake;
        autoCorrectNumber = 25;
    }
    public void setTargetPositionWheels(int target) {
        backLeftTarget = (target) + backLeftDrive.getCurrentPosition();
        frontRightTarget = (target) + frontRightDrive.getCurrentPosition();
        frontLeftTarget = (target) + frontLeftDrive.getCurrentPosition();
        backRightTarget = (target) + backLeftDrive.getCurrentPosition();
        backLeftDrive.setTargetPosition(backLeftTarget);
        frontLeftDrive.setTargetPosition(frontLeftTarget);
        backRightDrive.setTargetPosition(backRightTarget);
        frontRightDrive.setTargetPosition(frontRightTarget);
        while (backLeftDrive.getCurrentPosition() != backLeftTarget && backRightDrive.getCurrentPosition() != backRightTarget &&
                frontLeftDrive.getCurrentPosition() != frontLeftTarget && frontRightDrive.getCurrentPosition() != frontRightTarget) {
            backLeftDrive.setPower(strongBackLeftPower);
            frontRightDrive.setPower(strongFrontRightPower);
            frontLeftDrive.setPower(strongFrontLeftPower);
            backRightDrive.setPower(strongBackRightPower);
            if (Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                backLeftDrive.setPower(backLeftDrive.getPower() * .9);
            } else if (Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition())) {
                frontLeftDrive.setPower(frontLeftDrive.getPower() * .9);
            }

            if (Math.abs(backRightTarget - backRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition())) {
                backRightDrive.setPower(weakBackRightPower);

            } else if (Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(backRightTarget - backRightDrive.getCurrentPosition())) {
                frontRightDrive.setPower(weakFrontRightPower);
            }
            if (Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                frontLeftDrive.setPower(weakFrontLeftPower);
            } else if (Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition() - autoCorrectNumber) > Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                frontRightDrive.setPower(weakFrontRightPower);
            }
            if (Math.abs(backRightTarget - backRightDrive.getCurrentPosition()) + autoCorrectNumber < Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition())) {
                backLeftDrive.setPower(weakBackLeftPower);
            } else if (Math.abs(backRightTarget - backRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition())) {
                backRightDrive.setPower(weakFrontRightPower);
            }
        }
    }

    public void setTargetPositionWheelsCrabwalk(int target) {
        backLeftTarget = -(target) - backLeftDrive.getCurrentPosition();
        frontRightTarget = (target) + frontRightDrive.getCurrentPosition();
        frontLeftTarget = (target) + frontLeftDrive.getCurrentPosition();
        backRightTarget = -(target) - backLeftDrive.getCurrentPosition();
        backLeftDrive.setTargetPosition(backLeftTarget);
        frontLeftDrive.setTargetPosition(frontLeftTarget);
        backRightDrive.setTargetPosition(backRightTarget);
        frontRightDrive.setTargetPosition(frontRightTarget);
        while (backLeftDrive.getCurrentPosition() != backLeftTarget && backRightDrive.getCurrentPosition() != backRightTarget &&
                frontLeftDrive.getCurrentPosition() != frontLeftTarget && frontRightDrive.getCurrentPosition() != frontRightTarget) {
            backLeftDrive.setPower(strongBackLeftPower);
            frontRightDrive.setPower(strongFrontRightPower);
            frontLeftDrive.setPower(strongFrontLeftPower);
            backRightDrive.setPower(strongBackRightPower);
            if (Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                backLeftDrive.setPower(backLeftDrive.getPower() * .9);
            } else if (Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition())) {
                frontLeftDrive.setPower(frontLeftDrive.getPower() * .9);
            }

            if (Math.abs(backRightTarget - backRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition())) {
                backRightDrive.setPower(weakBackRightPower);

            } else if (Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(backRightTarget - backRightDrive.getCurrentPosition())) {
                frontRightDrive.setPower(weakFrontRightPower);
            }
            if (Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                frontLeftDrive.setPower(weakFrontLeftPower);
            } else if (Math.abs(frontRightTarget - frontRightDrive.getCurrentPosition() - autoCorrectNumber) > Math.abs(frontLeftTarget - frontLeftDrive.getCurrentPosition())) {
                frontRightDrive.setPower(weakFrontRightPower);
            }
            if (Math.abs(backRightTarget - backRightDrive.getCurrentPosition()) + autoCorrectNumber < Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition())) {
                backLeftDrive.setPower(weakBackLeftPower);
            } else if (Math.abs(backRightTarget - backRightDrive.getCurrentPosition()) - autoCorrectNumber > Math.abs(backLeftTarget - backLeftDrive.getCurrentPosition())) {
                backRightDrive.setPower(weakFrontRightPower);
            }
        }
    }

    public void setWheelPower(double power) {
        weakBackLeftPower = .8 * (power);
        weakBackRightPower = .8 * (power);
        weakFrontLeftPower = .8 * (power);
        weakFrontRightPower = .8 * (power);
        strongBackLeftPower = power;
        strongBackRightPower = power * 9;
        strongFrontLeftPower = power;
        strongFrontRightPower = power * .9;
        backLeftDrive.setPower(strongBackLeftPower);
        frontRightDrive.setPower(strongFrontRightPower);
        frontLeftDrive.setPower(strongFrontLeftPower);
        backRightDrive.setPower(strongBackRightPower);
    }

    public void setWheelPowerCrabwalk(double power) {
        weakBackLeftPower = 1 * (power);
        weakBackRightPower = 1 * (power);
        weakFrontLeftPower = 1 * (power);
        weakFrontRightPower = 1 * (power);
        strongBackLeftPower = power;
        strongBackRightPower = power * 9;
        strongFrontLeftPower = power;
        strongFrontRightPower = power * .9;
        backLeftDrive.setPower(strongBackLeftPower);
        frontRightDrive.setPower(strongFrontRightPower);
        frontLeftDrive.setPower(strongFrontLeftPower);
        backRightDrive.setPower(strongBackRightPower);
    }

    public void stopAndResetEncoders() {
        backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setTargetPositionArm(int position) {
    }
    public void setTeleMode() {
        upperArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        upperArmMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lowerArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        lowerArmMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
        upperArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        upperArmMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lowerArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        lowerArmMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
