package com.example.kelly.logeasyresearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ActivityInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Button btnScore = (Button) findViewById(R.id.btnBackStart);
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
