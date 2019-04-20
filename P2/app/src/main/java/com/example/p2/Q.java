package com.example.p2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Q extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);

        defineButtons();

    }

    public void defineButtons(){
        findViewById(R.id.buttonQ1).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonQ2).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonQ3).setOnClickListener(buttonClickListener);
        findViewById(R.id.buttonQ4).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonQ1:
                    startActivity(new Intent(Q.this, Q.class));
                    finish();
                    break;
                case R.id.buttonQ2:
                    startActivity(new Intent(Q.this, Result.class));
                    finish();
                    break;
                case R.id.buttonQ3:
                    startActivity(new Intent(Q.this, Profile.class));
                    finish();
                    break;
                case R.id.buttonQ4:
                    startActivity(new Intent(Q.this, About.class));
                    finish();
                    break;
            }
        }
    };
}
