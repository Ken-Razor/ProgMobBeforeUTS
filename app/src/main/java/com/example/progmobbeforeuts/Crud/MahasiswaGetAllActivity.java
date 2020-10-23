package com.example.progmobbeforeuts.Crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmobbeforeuts.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.progmobbeforeuts.Model.Mahasiswa;
import com.example.progmobbeforeuts.Network.GetDataService;
import com.example.progmobbeforeuts.Network.RetrofitClientInstance;
import com.example.progmobbeforeuts.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaGetAllActivity extends AppCompatActivity {
    RecyclerView rvGetMhs;
    MahasiswaCRUDRecyclerAdapter mhsAdapter;
    ProgressDialog pd;
    List<Mahasiswa> mahasiswaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_get_all);
        rvGetMhs = (RecyclerView)findViewById(R.id.rvGetMhs);
        pd = new ProgressDialog(this);
        pd.setTitle("Hayo Udah Sabar Belum :D");
        pd.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Mahasiswa>> call = service.getMahasiswa(
                "72180234");
        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                pd.dismiss();
                mahasiswaList = response.body();
                mhsAdapter = new MahasiswaCRUDRecyclerAdapter(mahasiswaList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                        MahasiswaGetAllActivity.this);
                rvGetMhs.setLayoutManager(layoutManager);
                rvGetMhs.setAdapter(mhsAdapter);
            }
            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MahasiswaGetAllActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}