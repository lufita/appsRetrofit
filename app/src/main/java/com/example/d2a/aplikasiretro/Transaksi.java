package com.example.d2a.aplikasiretro;

import com.google.gson.annotations.SerializedName;

public class Transaksi {

    @SerializedName("id")
    private Integer id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("jenis")
    private Integer jenis;
    @SerializedName("jumlah")
    private Integer jumlah;
    @SerializedName("keterangan")
    private String keterangan;

    public Transaksi(Integer id, String nama, Integer jenis, Integer jumlah, String keterangan) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "- [" + id + "] " + nama + " : " + jenis + " : " + jumlah + " : " + keterangan + "\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJenis() {
        return jenis;
    }

    public void setJenis(Integer jenis) {
        this.jenis = jenis;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
