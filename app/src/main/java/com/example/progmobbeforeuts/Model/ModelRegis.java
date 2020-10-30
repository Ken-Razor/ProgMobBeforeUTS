package com.example.progmobbeforeuts.Model;

public class ModelRegis {
    private String is_admin;
    private String id;
    private String nama;
    private String nimnik;
    private String email;
    private String password;

    public ModelRegis(String is_admin, String id, String nama, String nimnik, String email, String password) {
        this.is_admin = is_admin;
        this.id = id;
        this.nama = nama;
        this.nimnik = nimnik;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNimNik() {
        return nimnik;
    }

    public void setNimnik(String nimnik) {
        this.nimnik = nimnik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }
}
