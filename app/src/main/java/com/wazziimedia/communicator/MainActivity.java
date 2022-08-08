package com.wazziimedia.communicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button whats,telegram;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        whats = findViewById(R.id.whatsApp);
        telegram = findViewById(R.id.telegram);
    }

    @Override
    protected void onStart() {
        super.onStart();
        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,WhatsApp.class);
                startActivity(intent);
            }
        });

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,Telegram.class);
                startActivity(intent);
            }
        });
    }
}