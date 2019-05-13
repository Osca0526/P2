package com.example.p2.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.p2.R;

public class InstructionActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        //creating the button for submitting
        Button menuButton = findViewById(R.id.button1);
        Button startButton = findViewById(R.id.button2);
        startButton.setOnClickListener(buttonClickListener);
        menuButton.setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.button1){
                startActivity(new Intent(InstructionActivity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
            if(v.getId() == R.id.button2){
                startActivity(new Intent(InstructionActivity.this, TestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }
    };

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
