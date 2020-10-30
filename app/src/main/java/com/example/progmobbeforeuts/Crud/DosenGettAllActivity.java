package com.example.progmobbeforeuts.Crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmobbeforeuts.Adapter.DosenCRUDRecyclerAdapter;
import com.example.progmobbeforeuts.Model.Dosen;
import com.example.progmobbeforeuts.Network.GetDataService;
import com.example.progmobbeforeuts.Network.RetrofitClientInstance;
import com.example.progmobbeforeuts.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenGettAllActivity extends AppCompatActivity {
    RecyclerView rvGetDosen;
    DosenCRUDRecyclerAdapter dosenAdapter;
    ProgressDialog pd;
    List<Dosen> dosenList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_gett_all);
        rvGetDosen = (RecyclerView)findViewById(R.id.rvGetDosen);
        pd = new ProgressDialog(this);
        pd.setTitle("Sabar Ya Loading");
        pd.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Dosen>> call = service.getDosen(
                "72180234");
        call.enqueue(new Callback<List<Dosen>>() {
            @Override
            public void onResponse(Call<List<Dosen>> call, Response<List<Dosen>> response) {
                pd.dismiss();
                dosenList = response.body();
                dosenAdapter = new DosenCRUDRecyclerAdapter(dosenList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DosenGettAllActivity.this);
                rvGetDosen.setLayoutManager(layoutManager);
                rvGetDosen.setAdapter(dosenAdapter);
            }
            @Override
            public void onFailure(Call<List<Dosen>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(DosenGettAllActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}