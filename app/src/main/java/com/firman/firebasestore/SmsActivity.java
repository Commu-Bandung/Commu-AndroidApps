package com.firman.firebasestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    EditText txtNumber;
    EditText txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        txtNumber = (EditText) findViewById(R.id.txtNumber);
        txtText = (EditText) findViewById(R.id.txtText);
    }

    protected void sendMessage(View view) {
        Log.i("Send SMS", "");

        //ambil dari nilai EditText
        String noHp = txtNumber.getText().toString();
        String pesan = txtText.getText().toString();

        try {
            //membuat object sms manager
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(noHp,null,pesan,null,null);

            //Toast
            Toast.makeText(getApplicationContext(), "SMS Terkirim.", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Gagal Kirim SMS", Toast.LENGTH_LONG).show();
            e.printStackTrace();

        }
    }
}
