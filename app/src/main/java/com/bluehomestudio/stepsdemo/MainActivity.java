package com.bluehomestudio.stepsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bluehomestudio.steps.CircleImageSteps;

public class MainActivity extends AppCompatActivity {

    CircleImageSteps circleImageSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImageSteps = (CircleImageSteps) findViewById(R.id.cis_steps);
        circleImageSteps.addSteps(R.drawable.ic_action_name, R.drawable.ic_action_name, R.drawable.ic_action_name);
        circleImageSteps.nextStep();

    }
}
