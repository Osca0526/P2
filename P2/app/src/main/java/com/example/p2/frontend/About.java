package com.example.p2.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.p2.R;

public class About extends AppCompatActivity {

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
                    startActivity(new Intent(About.this, Q.class));
                    finish();
                    break;
                case R.id.buttonA2:
                    startActivity(new Intent(About.this, Result.class));
                    finish();
                    break;
            }
        }
    };

    /*
    @Override
    public void onBackPressed(){
        startActivity(new Intent(About.this,Activity2.class));
    }
    */
}