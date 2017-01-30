package com.firman.firebasestore;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_id, txt_kategori;
    private Button btnDelete, btnModify;
    private String id, kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txt_kategori = (TextView) findViewById(R.id.txt_kategori);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnModify = (Button) findViewById(R.id.btnModify);
        btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LoadExtraContent();
    }

    private void LoadExtraContent() {
        id = getIntent().getStringExtra("id");
        kategori = getIntent().getStringExtra("kategori");

        txt_kategori.setText(kategori);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDelete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Konfirmasi");
                builder.setMessage("Apakah anda yakin ingin menghapus\n" +
                        kategori + " ?");
                builder.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoadData(URLServices.URL_DELETE(id));
                        Intent i = new Intent(DetailActivity.this, ListActivity.class);
                        startActivityForResult(i, 1);
                        finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
            case R.id.btnModify:
                DialogModify();
                break;
        }
    }

    public void LoadData(String Url) {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Commu", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Commu", error.toString());
            }
        });
        queue.add(stringRequest);
    }

    private void DialogModify() {
        LayoutInflater inflater;
        AlertDialog.Builder dialog;
        View dialogView;

        dialog = new AlertDialog.Builder(DetailActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_add, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Modifikasi Data");


        final TextView txtKategori = (EditText)dialogView.findViewById(R.id.txtKategori);

        txtKategori.setText(kategori);


        dialog.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoadData(URLServices.URL_MODIFY(id,
                        txtKategori.getText().toString()));


               txt_kategori.setText(txtKategori.getText().toString());

                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
