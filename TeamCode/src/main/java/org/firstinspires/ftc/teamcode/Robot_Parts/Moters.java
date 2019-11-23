package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.hardware.DcMotor;


public class Moters {
    public DcMotor frontLeftDrive;
    public DcMotor frontRightDrive;
    public DcMotor backLeftDrive;
    public DcMotor backRightDrive;
    public DcMotor armMotor;
    public DcMotor leftIntake;
    public DcMotor rightIntake;
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
        backLeftDrive.setTargetPosition((int) (.7 * target) + backLeftDrive.getCurrentPosition());
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
    public void setTeleMode() {

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
