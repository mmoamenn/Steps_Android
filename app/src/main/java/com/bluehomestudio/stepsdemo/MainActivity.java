package com.bluehomestudio.stepsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bluehomestudio.steps.CircleImageSteps;

public class MainActivity extends AppCompatActivity {

    CircleImageSteps circleImageSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImageSteps = (CircleImageSteps) findViewById(R.id.cis_steps);
        circleImageSteps.addSteps(R.drawable.flag, R.drawable.fish
                , R.drawable.cooking, R.drawable.alarm
                , R.drawable.eat);


    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.next:
                circleImageSteps.nextStep();
                break;

            case R.id.previous:
                circleImageSteps.previousStep();
                break;

        }

    }


}
