package com.example.p2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        defineButtons();

    }

    public void defineButtons(){
        findViewById(R.id.buttonP1).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonP2).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonP3).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonP4).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonP1:
                    startActivity(new Intent(Profile.this, Q.class));
                    finish();
                    break;
                case R.id.buttonP2:
                    startActivity(new Intent(Profile.this, Result.class));
                    finish();
                    break;
                case R.id.buttonP3:
                    startActivity(new Intent(Profile.this, Profile.class));
                    finish();
                    break;
                case R.id.buttonP4:
                    startActivity(new Intent(Profile.this, About.class));
                    finish();
                    break;
            }
        }
    };
}