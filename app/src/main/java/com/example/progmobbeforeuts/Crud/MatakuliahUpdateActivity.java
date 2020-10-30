package com.example.progmobbeforeuts.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmobbeforeuts.Model.DefaultResult;
import com.example.progmobbeforeuts.Network.GetDataService;
import com.example.progmobbeforeuts.Network.RetrofitClientInstance;
import com.example.progmobbeforeuts.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatakuliahUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_update);
        final  EditText updateKodeMatakuliahLama = (EditText)findViewById(R.id.updateKodeMatakuliahLama);
        final  EditText updateNamaMatakuliah = (EditText)findViewById(R.id.updateNamaMatakuliah);
        final  EditText updateKodeMatakuliah = (EditText)findViewById(R.id.updateKodeMatakuliah);
        final  EditText updateHari = (EditText)findViewById(R.id.updateHari);
        final  EditText updateSesi = (EditText)findViewById(R.id.updateSesi);
        final  EditText updateSks = (EditText)findViewById(R.id.updateSks);
        Button buttonUpdateMatakuliah = (Button)findViewById(R.id.buttonUpdateMatakuliah);
        pd = new ProgressDialog(MatakuliahUpdateActivity.this);
        Intent data = getIntent();
        updateKodeMatakuliahLama.setText(data.getStringExtra("kode"));
        updateNamaMatakuliah.setText(data.getStringExtra("nama"));
        updateKodeMatakuliah.setText(data.getStringExtra("kode"));
        updateHari.setText(data.getStringExtra("hari"));
        updateSesi.setText(data.getStringExtra("sesi"));
        updateSks.setText(data.getStringExtra("sks"));
        buttonUpdateMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Saya Sabar :D");
                pd.show();
                Integer updateHariint = Integer.parseInt(updateHari.getText().toString());
                Integer updateSesiint = Integer.parseInt(updateSesi.getText().toString());
                Integer updateSksint = Integer.parseInt(updateSks.getText().toString());
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_matkul(updateNamaMatakuliah.getText().toString(),
                        "72180234", updateKodeMatakuliah.getText().toString(),
                        updateHariint, updateSesiint, updateSksint, updateKodeMatakuliahLama.getText().toString()
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahUpdateActivity.this,"Berhasil disimpan",Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });
                Intent intentBackMainDosen = new Intent(MatakuliahUpdateActivity.this, MainMatakuliahActivity.class);
                startActivity(intentBackMainDosen);
            }
        });
    }
}