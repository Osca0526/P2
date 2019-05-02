package com.example.p2.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.p2.R;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        defineButtons();

    }

    public void defineButtons(){
        findViewById(R.id.buttonR1).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonR2).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonR3).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonR4).setOnClickListener(buttonClickListener);
    }


    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonR1:
                    startActivity(new Intent(Result.this, Q.class));
                    finish();
                    break;
                case R.id.buttonR2:
                    startActivity(new Intent(Result.this, Result.class));
                    finish();
                    break;
                case R.id.buttonR3:
                    startActivity(new Intent(Result.this, Profile.class));
                    finish();
                    break;
                case R.id.buttonR4:
                    startActivity(new Intent(Result.this, About.class));
                    finish();
                    break;
            }
        }
    };
}