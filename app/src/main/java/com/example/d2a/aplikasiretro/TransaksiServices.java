package com.example.d2a.aplikasiretro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TransaksiServices {

    @GET("transaksi")
    Call<List<Transaksi>> listAllTransaksi();

    @POST("transaksi")
    @FormUrlEncoded
    Call<Transaksi> newPost(@Field("nama") String nama,
                            @Field("jenis") Integer jenis,
                            @Field("jumlah") Integer jumlah,
                            @Field("keterangan") String keterangan);


}
