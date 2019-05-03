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
    }


    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonR1:
                    startActivity(new Intent(Result.this, Activity2.class));
                    finish();
                    break;
            }
        }
    };
}