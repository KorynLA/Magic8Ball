package com.koryn.magic8ball;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.hardware.*;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    HashMap<Integer, String> answer;
    private SensorManager mSensorManager;
    private Sensor mSigMotion;
    private TriggerEventListener mListener = new TriggerListener();

     class TriggerListener extends TriggerEventListener {
         public void onTrigger(TriggerEvent event) {
            TextView answerUpdate = (TextView) findViewById(R.id.answer);
            Random randAnswer = new Random();
            int index=randAnswer.nextInt(4)+1;
            answerUpdate.setText(answer.get(index));
         }
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        answer= new HashMap<Integer, String>();
        answer.put(1, "No");
        answer.put(2, "Ask again later");
        answer.put(3, "Yes");
        answer.put(4, "Maybe");
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.ask_button);
        button.setOnClickListener(this);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mSigMotion = mSensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);
    }

    @Override
    public void onClick(View v) {
        TextView answerUpdate = (TextView) findViewById(R.id.answer);
        Random randAnswer = new Random();
        int index=randAnswer.nextInt(4)+1;
        answerUpdate.setText(answer.get(index));
    }
}
