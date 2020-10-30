package com.example.progmobbeforeuts.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dosen {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nidn")
    @Expose
    private String nidn;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("gelar")
    @Expose
    private String gelar;

    @SerializedName("foto")
    @Expose
    private String foto;

    @SerializedName("nim_progmob")
    @Expose
    private String nim_progmob;

    public Dosen(String nama, String nidn, String alamat, String email, String gelar, String foto, String nim_progmob) {
        this.nama = nama;
        this.nidn = nidn;
        this.alamat = alamat;
        this.email = email;
        this.gelar = gelar;
        this.foto = foto;
        this.nim_progmob = nim_progmob;
    }

    public Dosen(String id, String nama, String nidn, String alamat, String email, String gelar, String foto, String nim_progmob) {
        this.id = id;
        this.nama = nama;
        this.nidn = nidn;
        this.alamat = alamat;
        this.email = email;
        this.gelar = gelar;
        this.foto = foto;
        this.nim_progmob = nim_progmob;
    }

    public String getNamaDosen() {
        return nama;
    }

    public void setNamaDosen(String nama) {
        this.nama = nama;
    }

    public String getNidnDosen() {
        return nidn;
    }

    public void setNidnDosen(String nidn) {
        this.nidn = nidn;
    }

    public String getAlamatDosen() {
        return alamat;
    }

    public void setAlamatDosen(String alamat) {
        this.alamat = alamat;
    }

    public String getEmailDosen() {
        return email;
    }

    public void setEmailDosen(String email) {
        this.email = email;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNim_progmob() {
        return nim_progmob;
    }

    public void setNim_progmob(String nim_progmob) {
        this.nim_progmob = nim_progmob;
    }
}
