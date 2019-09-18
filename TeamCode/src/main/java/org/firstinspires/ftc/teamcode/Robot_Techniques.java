package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot_Parts.*;

public class Robot_Techniques extends OpMode {
    private Claw Claw = null;
    private Webcam Camera;
    private Arm Arm = null;
    private int extendedArmPosition = 100;
    private int halfArmPosition = 50;
    private int closedArmPosition = 0;
    private double openClawPosition = 1;
    private double closedClawPosition = 0;
    private double armExtendOrRetractTime = 4;
    private double encoderTickPerInch = 4;
    Robot_Techniques Technique;


    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

    public void DropGrabedBlock() {
        Arm.SetPosition(Technique.halfArmPosition);
        Technique.Pause(armExtendOrRetractTime / 2);
        //Claw.SetPosition(Technique.openClawPosition);
        Arm.SetPosition(Technique.closedArmPosition);
        Technique.Pause(armExtendOrRetractTime / 2);

    }

    public void GrabBlock() {
        //Claw.SetPosition(Technique.openClawPosition);
        Arm.SetPosition(Technique.extendedArmPosition);
        Technique.Pause(armExtendOrRetractTime);
        //Claw.SetPosition(Technique.closedClawPosition);
        Arm.SetPosition(Technique.closedArmPosition);
        Technique.Pause(armExtendOrRetractTime);

    }

    public void Pause(double Time) {
        ElapsedTime Timer = new ElapsedTime();
        while (Timer.time() < Time) ;
        {
            ///wait function placeholder as I don't get them
        }

    }
    public double FindDistance(){
        if (Camera.Skystone2 < Camera.Skystone1) {
            Camera.Skystone1 = Camera.Skystone2;
        }
        return encoderTickPerInch * (3.5 - Camera.Skystone1);

    }

    public double FindDirection(){
        if (Camera.Skystone2 < Camera.Skystone1) {
            Camera.Skystone1 = Camera.Skystone2;
        }
        if (Camera.Skystone1 > 3.5){
            return 3.1415;
        }
        else{
            return 0.0;
        }

    }

    /* public double FindAngle(int firstSkystone, int secondSkystone) {
        if (secondSkystone > firstSkystone) {
            firstSkystone = secondSkystone;
        }
        // RIGHT NOW THIS ISNT WORKING, BUT IT WOULD BE FASTER AND SOLVED IF WE FIGRURED OUT A WAY TO GET ENCODERS TO WORK REEE
        //VERY IMPORTANT, ROBOT MUST BE PUT IN THE EXACT MIDDLE OR THIS WONT WORK, MAKE A TAPE MARKER TO LINE UP WITH TILE!!!!!
        ///Robot starts in 3.5 position (3.5 blocks over from wall)

        Technique.blocksToMove = 3.5 - firstSkystone;

        // 8 is skystone size in inches
        return Math.atan2(8.0 * Technique.blocksToMove, distanceToBlocksXCordinateInInches);
    }

     */

    /*public double FindMagnitdudeOfEncoders() {
        double blocksSquared = Technique.blocksToMove * Technique.blocksToMove;
        return Technique.encoderTickPerInch *  Math.sqrt(blocksSquared + distanceToBlocksXCordinateInInches);
    }

     */
}
