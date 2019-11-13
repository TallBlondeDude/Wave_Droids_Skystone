package org.firstinspires.ftc.teamcode.Robot_Parts;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Gyroscope implements SensorEventListener {
    public float x, y, z;
    public SensorManager sensorManager;
    public Sensor sensor;

    public Gyroscope(Object a) {
        x = 0;
        y = 0;
        z = 0;
        sensorManager = (SensorManager) a; //a is getSystemService(Context.SENSOR_SERVICE); but you need to have access to the context to begin with
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        sensorManager.registerListener(this, sensor, sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];

        }
    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
