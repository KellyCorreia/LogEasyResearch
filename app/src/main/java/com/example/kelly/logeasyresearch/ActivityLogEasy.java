package com.example.kelly.logeasyresearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityLogEasy extends Activity {
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_easy);

        ImageButton btnStart;
        ImageButton btnInfo;


        btnStart = (ImageButton)findViewById(R.id.btnStart);
        btnInfo  = (ImageButton)findViewById(R.id.btnInfo);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ActivityLogEasy.this,ActivityChoose_Player.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogEasy.this, ActivityInfo.class);
                startActivity(intent);
            }
        });

    }
}
