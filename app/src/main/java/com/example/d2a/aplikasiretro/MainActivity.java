package com.example.d2a.aplikasiretro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtShow;
    TransaksiServices services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtShow = (TextView) findViewById(R.id.txtShow);

        services = ClientInstance.getInstance().create(TransaksiServices.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        retrofit2.Call<List<Transaksi>> trans = services.listAllTransaksi();

        trans.enqueue(new Callback<List<Transaksi>>() {
            @Override
            public void onResponse(Call<List<Transaksi>> call, Response<List<Transaksi>> response) {
                String strTrans = "";

                List<Transaksi> data = response.body();
                for(int i = 0; i < data.size(); i++){
                    strTrans += data.get(i).toString();
                }

                txtShow.setText(strTrans);
            }

            @Override
            public void onFailure(Call<List<Transaksi>> call, Throwable t) {
                Log.d("Debug", t.getMessage());
            }
        });
    }

    public void openTrans(View view) {
        startActivity(new Intent(this, FormTransaksi.class));
    }
}
