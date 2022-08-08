package com.wazziimedia.communicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class WhatsApp extends AppCompatActivity {

    private RadioButton rbLocal,rbUniversal;
    private EditText msgNumber, countryCode;
    private Button btnLocal,btnUniversal,btnClear,btnW2Main;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app);

        rbLocal = findViewById(R.id.rbLocal);
        rbUniversal = findViewById(R.id.rbUniversal);
        msgNumber = findViewById(R.id.etMsgNumber);
        countryCode = findViewById(R.id.etCountryCode);
        btnLocal = findViewById(R.id.btnLocal);
        btnUniversal = findViewById(R.id.btnUniversal);
        btnClear = findViewById(R.id.btnClear);
        btnW2Main = findViewById(R.id.btnWhatstoMainScreen);

        msgNumber.setVisibility(View.GONE);
        countryCode.setVisibility(View.GONE);
        btnLocal.setVisibility(View.GONE);
        btnUniversal.setVisibility(View.GONE);
        btnClear.setVisibility(View.GONE);


    }

    @Override
    protected void onStart() {
        super.onStart();
        rbLocal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    msgNumber.setVisibility(View.VISIBLE);
                    countryCode.setVisibility(View.GONE);
                    btnUniversal.setVisibility(View.GONE);
                    btnLocal.setVisibility(View.VISIBLE);
                    btnClear.setVisibility(View.VISIBLE);
                }
            }
        });
        rbUniversal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    msgNumber.setVisibility(View.VISIBLE);
                    countryCode.setVisibility(View.VISIBLE);
                    btnUniversal.setVisibility(View.VISIBLE);
                    btnLocal.setVisibility(View.GONE);
                    btnClear.setVisibility(View.VISIBLE);
                }
            }
        });

        btnLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String locLink = "",locCode = "2",whats="",base="wa.me/";
                if(!msgNumber.getText().toString().isEmpty()){
                    whats = msgNumber.getText().toString();
                    locLink = locCode + whats;
                    intent.setData(Uri.parse("https://"+base+locLink));
                    startActivity(intent);
                }else {
                    Toast.makeText(getBaseContext(),"Enter Number",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnUniversal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String uniCode = "",whats="",base="wa.me/",locLink="";
                if(!msgNumber.getText().toString().isEmpty()){
                    whats = msgNumber.getText().toString();
                    uniCode = "+"+ countryCode.getText().toString();
                    locLink = base + uniCode + whats;
                    intent.setData(Uri.parse("https://"+locLink));
                    startActivity(intent);
                }else {
                    Toast.makeText(getBaseContext(),"Enter Number",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgNumber.setText("");
                countryCode.setText("");
                rbLocal.setChecked(false);
                rbUniversal.setChecked(false);
                msgNumber.setVisibility(View.GONE);
                countryCode.setVisibility(View.GONE);
                btnLocal.setVisibility(View.GONE);
                btnUniversal.setVisibility(View.GONE);
                btnClear.setVisibility(View.GONE);
            }
        });


        btnW2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}