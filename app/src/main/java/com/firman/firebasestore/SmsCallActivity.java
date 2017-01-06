package com.firman.firebasestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SmsCallActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bSms;
    private Button bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_call);

        bSms = (Button) findViewById(R.id.btnsms);
        bSms.setOnClickListener(this);
        bCall = (Button) findViewById(R.id.btncalls);
        bCall.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.btnsms :
                Intent i = new Intent(this, SmsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                Toast.makeText(getApplicationContext(), "Sms Now", Toast.LENGTH_LONG).show();
                break;
            case R.id.btncalls :
                Intent i2 = new Intent(this, CallActivity.class);
                startActivity(i2);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                Toast.makeText(getApplicationContext(), "Call Now", Toast.LENGTH_LONG).show();
                break;


        }
    }
}
