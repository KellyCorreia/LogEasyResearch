package com.example.kelly.logeasyresearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LogEasy extends Activity {
    Button btnStart;
    Button btnInfo;
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_easy);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnInfo  = (Button)findViewById(R.id.btnInfo);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LogEasy.this,Choose_Player.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogEasy.this, InfoActivity.class);
                startActivity(intent);
            }
        });

    }
}
