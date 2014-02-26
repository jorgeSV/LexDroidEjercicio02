package com.sovejo.lexdroidejercicio02;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements SensorEventListener
{
	LinearLayout linearLayout;
	TextView textView;
	Sensor sensor;
	SensorManager sensorManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView) findViewById(R.id.textView01);
		linearLayout = (LinearLayout) findViewById(R.id.linearLayout01);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensor = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		
		sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) 
	{
		// TODO Auto-generated method stub
		String texto = String.valueOf(event.values[0]);
		textView.setText(texto);
		
		float valor = Float.parseFloat(texto);
		
		if(valor == 0)
			linearLayout.setBackgroundColor(Color.RED);
		else
			linearLayout.setBackgroundColor(Color.BLUE);
	}

}
