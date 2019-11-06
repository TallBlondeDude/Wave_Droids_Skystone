package org.firstinspires.ftc.teamcode.Robot_Parts;


import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

public class Webcam {
    private WebcamName Webcam;
    private static final String VUFORIA_KEY =

            "AboXNav/////AAABmeGOS7NozU5qnTs51UZZ17g1BcHElTpLG7nsEbYufdDfWLm+ZbdqBWX7hOXxoHiu9tzNUQI4PIsRb96x9UHLizYXL8ZzqsCRKqmHx6iiGL81vuTLUyZ3yTybJ5AENkTY8h7YrKSJZnvS7W3V4EoZFxXRe4mEhxxWYsYSlBx6MEX7m9RAet8LGIf35OjCd5wzC/tSGMs+RGx+4tU+aCQkytnoaPcnEGzzt9nLu/0DypuJFc2pI+FuwGw0Y52PbDBrnb/cw+SLSRYGbYavN77to3eguAn7rG8vN0W0RrYYvkWxiRh1HY0WWtew91WaN4+hmkwWRoEFmC6CAt3kAzg1NSQWpRGXNreOlMqOf8Dr+H8j";


    // Since ImageTarget trackables use mm to specifiy their dimensions, we must use mm for all the physical dimension.

    // We will define some constants and conversions here

    private static float mmPerInch;

    private static float mmTargetHeight;          // the height of the center of the target image above the floor


    // Constant for Stone Target

    private static float stoneZ;

    private int what;
    // Constants for the center support targets
    OpenGLMatrix robotFromCamera;
    private static float bridgeZ;

    private static float bridgeY;

    private static float bridgeX;

    private static float bridgeRotY;                                 // Units are degrees

    private static float bridgeRotZ;


    // Constants for perimeter targets

    private static float halfField;

    private static float quadField;

    List<VuforiaTrackable> allTrackables;
    // Class Members

    private OpenGLMatrix lastLocation;

    private VuforiaLocalizer vuforia;

    private boolean targetVisible;

    private float phoneXRotate;
    VuforiaTrackables targetsSkyStone;
    private float phoneYRotate;
    private float phoneZRotate;
    private int cameraMonitorViewId;
    private VuforiaLocalizer.Parameters parameters;
    Telemetry telemetry;
    private static VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;

    private static boolean PHONE_IS_PORTRAIT = false;

    public Webcam(WebcamName a, Telemetry b, int c) {
        final String VUFORIA_KEY =

                "AboXNav/////AAABmeGOS7NozU5qnTs51UZZ17g1BcHElTpLG7nsEbYufdDfWLm+ZbdqBWX7hOXxoHiu9tzNUQI4PIsRb96x9UHLizYXL8ZzqsCRKqmHx6iiGL81vuTLUyZ3yTybJ5AENkTY8h7YrKSJZnvS7W3V4EoZFxXRe4mEhxxWYsYSlBx6MEX7m9RAet8LGIf35OjCd5wzC/tSGMs+RGx+4tU+aCQkytnoaPcnEGzzt9nLu/0DypuJFc2pI+FuwGw0Y52PbDBrnb/cw+SLSRYGbYavN77to3eguAn7rG8vN0W0RrYYvkWxiRh1HY0WWtew91WaN4+hmkwWRoEFmC6CAt3kAzg1NSQWpRGXNreOlMqOf8Dr+H8j";


        // Since ImageTarget trackables use mm to specifiy their dimensions, we must use mm for all the physical dimension.

        // We will define some constants and conversions here

        mmPerInch = 25.4f;

        mmTargetHeight = (6) * mmPerInch;          // the height of the center of the target image above the floor


        // Constant for Stone Target

        stoneZ = 2.00f * mmPerInch;


        // Constants for the center support targets

        bridgeZ = 6.42f * mmPerInch;

        bridgeY = 23 * mmPerInch;

        bridgeX = 5.18f * mmPerInch;

        bridgeRotY = 59;                                 // Units are degrees

        bridgeRotZ = 180;

        what = c;
        // Constants for perimeter targets

        halfField = 72 * mmPerInch;

        quadField = 36 * mmPerInch;


        // Class Members

        OpenGLMatrix lastLocation = null;

        VuforiaLocalizer vuforia = null;

        targetVisible = false;

        phoneXRotate = 0;

        phoneYRotate = 0;

        phoneZRotate = 0;

        Webcam = a;
        telemetry = b;
        cameraMonitorViewId = what;

        parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.cameraName = Webcam;

        parameters.vuforiaLicenseKey = VUFORIA_KEY;

        parameters.cameraDirection = CAMERA_CHOICE;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        targetsSkyStone = vuforia.loadTrackablesFromAsset("Skystone");


        //  Instantiate the Vuforia engine


        // Load the data sets for the trackable objects. These particular data

        // sets are stored in the 'assets' part of our application.


        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);

        stoneTarget.setName("Stone Target");

        VuforiaTrackable blueRearBridge = targetsSkyStone.get(1);

        blueRearBridge.setName("Blue Rear Bridge");

        VuforiaTrackable redRearBridge = targetsSkyStone.get(2);

        redRearBridge.setName("Red Rear Bridge");

        VuforiaTrackable redFrontBridge = targetsSkyStone.get(3);

        redFrontBridge.setName("Red Front Bridge");

        VuforiaTrackable blueFrontBridge = targetsSkyStone.get(4);

        blueFrontBridge.setName("Blue Front Bridge");

        VuforiaTrackable red1 = targetsSkyStone.get(5);

        red1.setName("Red Perimeter 1");

        VuforiaTrackable red2 = targetsSkyStone.get(6);

        red2.setName("Red Perimeter 2");

        VuforiaTrackable front1 = targetsSkyStone.get(7);

        front1.setName("Front Perimeter 1");

        VuforiaTrackable front2 = targetsSkyStone.get(8);

        front2.setName("Front Perimeter 2");

        VuforiaTrackable blue1 = targetsSkyStone.get(9);

        blue1.setName("Blue Perimeter 1");

        VuforiaTrackable blue2 = targetsSkyStone.get(10);

        blue2.setName("Blue Perimeter 2");

        VuforiaTrackable rear1 = targetsSkyStone.get(11);

        rear1.setName("Rear Perimeter 1");

        VuforiaTrackable rear2 = targetsSkyStone.get(12);

        rear2.setName("Rear Perimeter 2");


        // For convenience, gather together all the trackable objects in one easily-iterable collection */

        allTrackables = new ArrayList<VuforiaTrackable>();

        allTrackables.addAll(targetsSkyStone);


        /**
         * In order for localization to work, we need to tell the system where each target is on the field, and
         * where the phone resides on the robot.  These specifications are in the form of <em>transformation matrices.</em>
         * Transformation matrices are a central, important concept in the math here involved in localization.
         * See <a href="https://en.wikipedia.org/wiki/Transformation_matrix">Transformation Matrix</a>
         * for detailed information. Commonly, you'll encounter transformation matrices as instances
         * of the {@link OpenGLMatrix} class.
         *
         * If you are standing in the Red Alliance Station looking towards the center of the field,
         *     - The X axis runs from your left to the right. (positive from the center to the right)
         *     - The Y axis runs from the Red Alliance Station towards the other side of the field
         *       where the Blue Alliance Station is. (Positive is from the center, towards the BlueAlliance station)
         *     - The Z axis runs from the floor, upwards towards the ceiling.  (Positive is above the floor)
         *
         * Before being transformed, each target image is conceptually located at the origin of the field's
         *  coordinate system (the center of the field), facing up.

         */


        // Set the position of the Stone Target.  Since it's not fixed in position, assume it's at the field origin.

        // Rotated it to to face forward, and raised it to sit on the ground correctly.

        // This can be used for generic target-centric approach algorithms

        stoneTarget.setLocation(OpenGLMatrix

                .translation(0, 0, stoneZ)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));


        //Set the position of the bridge support targets with relation to origin (center of field)

        blueFrontBridge.setLocation(OpenGLMatrix

                .translation(-bridgeX, bridgeY, bridgeZ)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, bridgeRotZ)));


        blueRearBridge.setLocation(OpenGLMatrix

                .translation(-bridgeX, bridgeY, bridgeZ)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, bridgeRotZ)));


        redFrontBridge.setLocation(OpenGLMatrix

                .translation(-bridgeX, -bridgeY, bridgeZ)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, 0)));


        redRearBridge.setLocation(OpenGLMatrix

                .translation(bridgeX, -bridgeY, bridgeZ)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, 0)));


        //Set the position of the perimeter targets with relation to origin (center of field)

        red1.setLocation(OpenGLMatrix

                .translation(quadField, -halfField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));


        red2.setLocation(OpenGLMatrix

                .translation(-quadField, -halfField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));


        front1.setLocation(OpenGLMatrix

                .translation(-halfField, -quadField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));


        front2.setLocation(OpenGLMatrix

                .translation(-halfField, quadField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));


        blue1.setLocation(OpenGLMatrix

                .translation(-quadField, halfField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));


        blue2.setLocation(OpenGLMatrix

                .translation(quadField, halfField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));


        rear1.setLocation(OpenGLMatrix

                .translation(halfField, quadField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));


        rear2.setLocation(OpenGLMatrix

                .translation(halfField, -quadField, mmTargetHeight)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));


        //

        // Create a transformation matrix describing where the phone is on the robot.

        //

        // NOTE !!!!  It's very important that you turn OFF your phone's Auto-Screen-Rotation option.

        // Lock it into Portrait for these numbers to work.

        //

        // Info:  The coordinate frame for the robot looks the same as the field.

        // The robot's "forward" direction is facing out along X axis, with the LEFT side facing out along the Y axis.

        // Z is UP on the robot.  This equates to a bearing angle of Zero degrees.

        //

        // The phone starts out lying flat, with the screen facing Up and with the physical top of the phone

        // pointing to the LEFT side of the Robot.

        // The two examples below assume that the camera is facing forward out the front of the robot.

        if (CAMERA_CHOICE == BACK) {

            phoneYRotate = -90;

        } else {

            phoneYRotate = 90;

        }
        if (PHONE_IS_PORTRAIT) {

            phoneXRotate = 90;

        }
        allTrackables.addAll(targetsSkyStone);
        final float CAMERA_FORWARD_DISPLACEMENT = 0 * mmPerInch;   // eg: Camera is 4 Inches in front of robot center

        final float CAMERA_VERTICAL_DISPLACEMENT = 1 * mmPerInch;   // eg: Camera is 8 Inches above ground

        final float CAMERA_LEFT_DISPLACEMENT = 0;     // eg: Camera is ON the robot's center line


        robotFromCamera = OpenGLMatrix

                .translation(CAMERA_FORWARD_DISPLACEMENT, CAMERA_LEFT_DISPLACEMENT, CAMERA_VERTICAL_DISPLACEMENT)

                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, YZX, DEGREES, phoneYRotate, phoneZRotate, phoneXRotate));
        for (VuforiaTrackable trackable : allTrackables) {

            ((VuforiaTrackableDefaultListener) trackable.getListener()).setPhoneInformation(robotFromCamera, parameters.cameraDirection);
            targetsSkyStone.activate();

        }
    }

    // We need to rotate the camera around it's long axis to bring the correct camera forward.
    public int findSkystone() {


        targetVisible = false;

        for (VuforiaTrackable trackable : allTrackables) {

            if (((VuforiaTrackableDefaultListener) trackable.getListener()).isVisible()) {

                telemetry.addData("Visible Target", trackable.getName());


                if (trackable.getName().equals("Stone Target")) {

                    telemetry.addLine("Stone Target Is Visible");

                }


                targetVisible = true;


                // getUpdatedRobotLocation() will return null if no new information is available since
                // the last time that call was made, or if the trackable is not currently visible.

                OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener) trackable.getListener()).getUpdatedRobotLocation();

                if (robotLocationTransform != null) {

                    lastLocation = robotLocationTransform;

                }

                break;

            }

        }


        // Provide feedback as to where the robot is located (if we know).

        String positionSkystone = "";

        if (targetVisible) {

            // express position (translation) of robot in inches.

            VectorF translation = lastLocation.getTranslation();

            telemetry.addData("Pos (in)", "{X, Y, Z} = %.1f, %.1f, %.1f",

                    translation.get(0) / mmPerInch, translation.get(1) / mmPerInch, translation.get(2) / mmPerInch);


            double xPosition = translation.get(0);

            if (xPosition < -16) {

                positionSkystone = "left";

            } else if (xPosition >= 16) {

                positionSkystone = "center";

            } else {
                positionSkystone = "right";
            }


            // express the rotation of the robot in degrees.

            Orientation rotation = Orientation.getOrientation(lastLocation, EXTRINSIC, XYZ, DEGREES);

            telemetry.addData("Rot (deg)", "{Roll, Pitch, Heading} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);

        } else {

            positionSkystone = "Not Found";
            telemetry.addData("Visible Target", "none");

        }

        telemetry.addData("Skystone Position", positionSkystone);

        // Disable Tracking when we are done;


        if (positionSkystone == "left") {
            return -1;
        } else if (positionSkystone == "center") {
            return 0;
        } else if (positionSkystone == "right") {
            return 1;
        } else {
            return 5;
        }

    }

    public void vuforiaOff() {
        targetsSkyStone.deactivate();
    }

}
