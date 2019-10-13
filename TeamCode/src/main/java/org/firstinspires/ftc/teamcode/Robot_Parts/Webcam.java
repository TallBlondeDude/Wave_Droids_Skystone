package org.firstinspires.ftc.teamcode.Robot_Parts;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;


public class Webcam extends OpMode {
    private static final String Key = "AWHL4D//////AAABmWCQl0lTakgVn37yjk+YMboLmnp2uU+3Vd4Nbp1L6KpGZSNaUfDDkVoPJA6aDcpi8WfIUtOoTwuXphoZpMBE8me7qLd25s8zkINgXmsZw1kNtgd4CW8DwJhvLDnUGeUMvJ0I2kvRclXNhiPHTV8qcu3Uxs/X/kKC9RIajdwHFFzFfSNp+f02pKqSkfYNbSlrS+FF0ttmsoqBLkBJc6GUpQWT4jAgNFXzg3Zep7rQxd022iJ4FJoOqgXi/szG49iX5lvanwqGYiuBOwrJWMlTGfW9hLbgrgxNZj198glUryJPIoEE6E4zC8C80FoeszA8TUUjqD77wwTOiHm0QR2NREuLyzC5tiEPMz8V9Vly9k1A ";
    private static final String TFOD_MODEL_ASSET = "Skystone.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Stone";
    private static final String LABEL_SECOND_ELEMENT = "Skystone";
    private VuforiaLocalizer vuforia;
    public Webcam vuforiaStorage = null;
    private TFObjectDetector tfod;
    private double minimumConfidence = .8;

    @Override
    public void init() {
    }

    @Override
    public void loop() {
    }

    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = Key;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Start the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

    }

    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minimumConfidence = vuforiaStorage.minimumConfidence;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }


    public double[] LocateSkystones() {

        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.
        double[] skystones = new double[0];
        skystones[1] = 0;
        skystones[2] = 0;
        skystones[3] = 0;
        skystones[4] = 0;
        initVuforia();
        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        /**
         * Activate TensorFlow Object Detection before we wait for the start command.
         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
         **/
        if (tfod != null) {
            tfod.activate();
        }

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();

        if (tfod != null) {
            // getUpdatedRecognitions() will return null if no new information is available since
            // the last time that call was made.
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) {
                telemetry.addData("# Object Detected", updatedRecognitions.size());
                // step through the list of recognitions and display boundary info.
                int i = 0;
                for (Recognition recognition : updatedRecognitions) {
                    telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                    telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                            recognition.getLeft(), recognition.getTop());
                    telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                            recognition.getRight(), recognition.getBottom());
                    if (recognition.getLabel() == "Skystone") {
                        // how thic each block is
                        float Constant = 100;
                        // figure out how thic is thic
                        int Position = (int) (Math.floor((recognition.getLeft() + Constant) / Constant));
                        if (recognition.getConfidence() > skystones[3] || recognition.getConfidence() > skystones[1]) {
                            if (skystones[1] > skystones[3]) {
                                skystones[3] = recognition.getConfidence();
                                skystones[2] = recognition.getLeft();
                            } else {
                                skystones[1] = recognition.getConfidence();
                                skystones[0] = recognition.getLeft();
                            }
                        }
                    }
                }
            }

            telemetry.update();
        }

        if (tfod != null) {
            tfod.shutdown();
        }
        if(skystones[0] < skystones[3]){
            double placeholder1 = skystones[0];
            double placeholder2 = skystones[1];
            skystones[0] = skystones[2];
            skystones[1] = skystones[3];
            skystones[2] = placeholder1;
            skystones[3] = placeholder2;
        }
        return skystones;

    }
}
