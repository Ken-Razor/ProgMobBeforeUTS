package com.example.progmobbeforeuts.Crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmobbeforeuts.Adapter.MatakuliahCRUDRecyclerAdapter;
import com.example.progmobbeforeuts.Model.Matakuliah;
import com.example.progmobbeforeuts.Network.GetDataService;
import com.example.progmobbeforeuts.Network.RetrofitClientInstance;
import com.example.progmobbeforeuts.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatakuliahGetAllActivity extends AppCompatActivity {
    RecyclerView rvGetMatakuliah;
    MatakuliahCRUDRecyclerAdapter matakuliahAdapter;
    ProgressDialog pd;
    List<Matakuliah> matakuliahList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_get_all);
        rvGetMatakuliah = (RecyclerView)findViewById(R.id.rvGetMatakuliah);
        pd = new ProgressDialog(this);
        pd.setTitle("Sabar Dongs :)");
        pd.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Matakuliah>> call = service.getMatkul(
                "72180234");
        call.enqueue(new Callback<List<Matakuliah>>() {
            @Override
            public void onResponse(Call<List<Matakuliah>> call, Response<List<Matakuliah>> response) {
                pd.dismiss();
                matakuliahList = response.body();
                matakuliahAdapter = new MatakuliahCRUDRecyclerAdapter(matakuliahList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                        MatakuliahGetAllActivity.this);
                rvGetMatakuliah.setLayoutManager(layoutManager);
                rvGetMatakuliah.setAdapter(matakuliahAdapter);
            }
            @Override
            public void onFailure(Call<List<Matakuliah>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatakuliahGetAllActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}