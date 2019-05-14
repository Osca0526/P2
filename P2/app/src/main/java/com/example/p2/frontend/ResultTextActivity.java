package com.example.p2.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.p2.R;
import com.example.p2.backend.questionnaire.Test;

public class ResultTextActivity extends AppCompatActivity {

    Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulttext);
        findViewById(R.id.buttonR1).setOnClickListener(buttonClickListener);
        Intent intent = getIntent();
        test = intent.getParcelableExtra("test");
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonR1:
                    Intent result = new Intent(ResultTextActivity.this, ResultActivity.class);
                    result.putExtra("test2", test);
                    startActivity(result);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    break;
            }
        }
    };

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
