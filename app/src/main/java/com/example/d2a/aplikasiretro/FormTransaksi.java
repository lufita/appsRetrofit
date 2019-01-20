package com.example.d2a.aplikasiretro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormTransaksi extends AppCompatActivity {

    EditText edtId, edtNama, edtJenis, edtJumlah, edtKeterangan;
    TransaksiServices services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_transaksi);

        edtId = (EditText) findViewById(R.id.edt_id);
        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtJenis = (EditText) findViewById(R.id.edt_jenis);
        edtJumlah = (EditText) findViewById(R.id.edt_jumlah);
        edtKeterangan = (EditText) findViewById(R.id.edt_keterangan);

        services = ClientInstance.getInstance().create(TransaksiServices.class);
    }

    public void saveTrans(View view) {
        int id = Integer.parseInt(edtId.getText().toString());
        String nama = edtNama.getText().toString();
        int jenis = Integer.parseInt(edtId.getText().toString());
        int jumlah = Integer.parseInt(edtJumlah.getText().toString());
        String ket = edtKeterangan.getText().toString();

        services.newPost(nama, jenis, jumlah, ket).enqueue(new Callback<Transaksi>() {
            @Override
            public void onResponse(Call<Transaksi> call, Response<Transaksi> response) {
                Log.d("debug", response.body().toString());
            }

            @Override
            public void onFailure(Call<Transaksi> call, Throwable t) {
                Log.d("debug", t.getMessage());
            }
        });

        finish();
    }
}
