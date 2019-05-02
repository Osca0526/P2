package com.example.p2.frontend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.p2.R;

//  implements View.OnClickListener
public class Activity2 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // when the activity starts, it runs defineButtons that correspond to the following "defineButton" method
        defineButtons();
    }

    // Another way of doing this could just be by throwing these lines in the "onCreate" method, however, it can quickly become messy
    public void defineButtons(){
        findViewById(R.id.button).setOnClickListener(buttonClickListener);
        findViewById(R.id.button2).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            // this switch statement analyzes the view.getId by defining the buttons using case statements, which checks the id from our view and if it gets the specific ID from one of the following buttons, it will run
            switch (v.getId()){
                case R.id.button:
                    startActivity(new Intent(Activity2.this, Q.class));
                    break;
                case R.id.button2:
                    startActivity(new Intent(Activity2.this, About.class));
                    break;

            }
        }
    };


    @Override
    public void onBackPressed(){

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
             backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
             backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
