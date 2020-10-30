package com.example.progmobbeforeuts.Network;

import com.example.progmobbeforeuts.Model.DefaultResult;
import com.example.progmobbeforeuts.Model.Dosen;
import com.example.progmobbeforeuts.Model.Mahasiswa;
import com.example.progmobbeforeuts.Model.Matakuliah;
import com.example.progmobbeforeuts.Model.ModelLogin;


import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {
    //MAHASISSWA
    @GET("api/progmob/mhs/{nim_progmob}")
    Call<List<Mahasiswa>> getMahasiswa(@Path("nim_progmob") String nim_progmob);

    @FormUrlEncoded
    @POST("api/progmob/mhs/delete")
    Call<DefaultResult>delete_mhs(
            @Field("nim") String id,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/mhs/create")
    Call<DefaultResult> add_mhs(
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );
    @FormUrlEncoded
    @POST("api/progmob/mhs/update")
    Call<DefaultResult>update_mhs(
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );

    //ini Login
    @FormUrlEncoded
    @POST("api/progmob/login")
    Call<List<ModelLogin>>login(
            @Field("nimnik") String nimnik,
            @Field("password") String password
    );

    //DOSEN
    @GET("api/progmob/dosen/{nim_progmob}")
    Call<List<Dosen>> getDosen(
            @Path("nim_progmob") String nim_progmob
    );

    @FormUrlEncoded
    @POST("api/progmob/dosen/delete")
    Call<DefaultResult>delete_dosen(
            @Field("nidn") String nidn,
            @Field("nim_progmob") String nim_progmob
    );

    @FormUrlEncoded
    @POST("api/progmob/dosen/create")
    Call<DefaultResult> add_dosen(
            @Field("nama") String nama,
            @Field("nidn") String nidn,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("gelar") String gelar,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob
    );

    @FormUrlEncoded
    @POST("api/progmob/dosen/update")
    Call<DefaultResult>update_dosen(
            @Field("nama") String nama,
            @Field("nidn") String nidn,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("gelar") String gelar,
            @Field("foto") String foto,
            @Field("nim_progmob") String nim_progmob,
            @Field("nidn_cari") String nidn_cari
    );
    //MATAKULIAH ini
    @GET("api/progmob/matkul/{nim_progmob}")
    Call<List<Matakuliah>> getMatkul(
            @Path("nim_progmob") String nim_progmob
    );

    @FormUrlEncoded
    @POST("api/progmob/matkul/delete")
    Call<DefaultResult>delete_matkul(
            @Field("kode") String kode,
            @Field("nim_progmob") String nim_progmob
    );

    @FormUrlEncoded
    @POST("api/progmob/matkul/create")
    Call<DefaultResult> add_matkul(
            @Field("nama") String nama,
            @Field("nim_progmob") String nim_progmob,
            @Field("kode") String kode,
            @Field("hari") Integer hari,
            @Field("sesi") Integer sesi,
            @Field("sks") Integer sks
    );

    @FormUrlEncoded
    @POST("api/progmob/matkul/update")
    Call<DefaultResult>update_matkul(
            @Field("nama") String nama,
            @Field("nim_progmob") String nim_progmob,
            @Field("kode") String kode,
            @Field("hari") Integer hari,
            @Field("sesi") Integer sesi,
            @Field("sks") Integer sks,
            @Field("kode_cari") String kode_cari
    );
}