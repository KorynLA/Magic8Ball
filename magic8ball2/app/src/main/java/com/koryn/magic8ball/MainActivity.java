package com.koryn.magic8ball;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.ask_button);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        TextView answerUpdate = (TextView) findViewById(R.id.answer);
        answerUpdate.setText("hi");
    }
}
