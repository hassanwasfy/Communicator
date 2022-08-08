package com.wazziimedia.communicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Telegram extends AppCompatActivity {

    private Spinner options;
    private EditText etTelegramUserName,telegramUserMobile;
    private Button MsgUserName,MsgUserMobile,telegramBacktoMain;
    private final static String teleBase = "t.me/";
    private String userData;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);

        options = findViewById(R.id.telegramOptionArray);
        etTelegramUserName = findViewById(R.id.etTelegramUserName);
        telegramUserMobile = findViewById(R.id.telegramUserMobile);
        MsgUserMobile = findViewById(R.id.btnTelegramMSgNumber);
        MsgUserName = findViewById(R.id.btnTelegramMSgUser);
        telegramBacktoMain = findViewById(R.id.btnTelegramBack);

        etTelegramUserName.setVisibility(View.GONE);
        telegramUserMobile.setVisibility(View.GONE);
        MsgUserName.setVisibility(View.GONE);
        MsgUserMobile.setVisibility(View.GONE);

        intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
    }


    @Override
    protected void onStart() {
        super.onStart();

        telegramBacktoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        MsgUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etTelegramUserName.getText().toString().isEmpty()){
                    userData = etTelegramUserName.getText().toString();
                    intent.setData(Uri.parse("https://"+teleBase+userData));
                    startActivity(intent);
                }else {
                    Toast.makeText(getBaseContext(),"Enter User Name PLease!",Toast.LENGTH_LONG).show();
                }
            }
        });

        MsgUserMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etTelegramUserName.getText().toString().isEmpty()){
                    userData = telegramUserMobile.getText().toString();
                    intent.setData(Uri.parse("https://"+teleBase+userData));
                    startActivity(intent);
                }else {
                    Toast.makeText(getBaseContext(),"Enter User Mobile PLease!",Toast.LENGTH_LONG).show();
                }
            }
        });




        options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        etTelegramUserName.setVisibility(View.GONE);
                        telegramUserMobile.setVisibility(View.GONE);
                        MsgUserName.setVisibility(View.GONE);
                        MsgUserMobile.setVisibility(View.GONE);
                        break;
                    case 1:
                        etTelegramUserName.setVisibility(View.VISIBLE);
                        MsgUserName.setVisibility(View.VISIBLE);
                        telegramUserMobile.setVisibility(View.GONE);
                        MsgUserMobile.setVisibility(View.GONE);
                        break;
                    case 2:
                        etTelegramUserName.setVisibility(View.GONE);
                        MsgUserName.setVisibility(View.GONE);
                        telegramUserMobile.setVisibility(View.VISIBLE);
                        MsgUserMobile.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                etTelegramUserName.setVisibility(View.GONE);
                telegramUserMobile.setVisibility(View.GONE);
                MsgUserName.setVisibility(View.GONE);
                MsgUserMobile.setVisibility(View.GONE);
            }
        });
    }
}