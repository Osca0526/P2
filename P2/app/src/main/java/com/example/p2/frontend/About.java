package com.example.p2.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.p2.R;

public class About extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        defineButtons();

    }

    public void defineButtons(){
        findViewById(R.id.buttonA1).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonA2).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonA1:
                    startActivity(new Intent(About.this, Activity2.class));
                    finish();
                    break;
                case R.id.buttonA2:
                    startActivity(new Intent(About.this, Q.class));
                    finish();
                    break;
            }
        }
    };
}