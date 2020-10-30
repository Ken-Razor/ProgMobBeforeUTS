package com.example.progmobbeforeuts.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Matakuliah {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String namaMatkul;

    @SerializedName("kode")
    @Expose
    private String kodeMatkul;

    @SerializedName("hari")
    @Expose
    private Integer hari;

    @SerializedName("sesi")
    @Expose
    private Integer sesi;

    @SerializedName("sks")
    @Expose
    private Integer sks;

    @SerializedName("nim_progmob")
    @Expose
    private String nim_progmob;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kode) {
        this.kodeMatkul = kode;
    }

    public int getHari() {
        return hari;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }

    public int getSesi() {
        return sesi;
    }

    public void setSesi(int sesi) {
        this.sesi = sesi;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public String getNim_progmob() {
        return nim_progmob;
    }

    public void setNim_progmob(String nim_progmob) {
        this.nim_progmob = nim_progmob;
    }
}
