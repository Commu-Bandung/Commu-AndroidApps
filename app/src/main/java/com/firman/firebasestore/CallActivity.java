package com.firman.firebasestore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    //deklarasi variabel global yang akan menampung nilai dari EditText no yang diinput
    EditText txtNo;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        //proses pengisian txtNo yang diisi berdasarkan id EditTextnya
        txtNo = (EditText) findViewById(R.id.txtNo);
    }

    //function onClick yang dibuat pada designya
    protected void makeCall(View view) {
        //pengambilan nilai EditText yang kemudian di parse kedalam String
        String no = txtNo.getText().toString();
        //pembuatan redirect saat function berjalan ke dial default no hp akan otomatis ke-isi
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + no));
        try {
            //menjalankan activity in
            startActivity(in);
        }
        //pembuatan pesan error jikaactivity in gagal dijalankan

        catch (android.content.ActivityNotFoundException e) {

            Toast.makeText(getApplicationContext(),
                    "Tidak ada halaman Activity yang ditemukan", Toast.LENGTH_SHORT).show();

        }

    }

}