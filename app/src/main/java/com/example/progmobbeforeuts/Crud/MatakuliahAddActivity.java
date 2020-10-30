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

public class MatakuliahAddActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_add);
        final EditText editTextNamaMatakuliah = (EditText)findViewById(R.id.editTextNamaMatakuliah);
        final EditText editTextKodeMatakuliah = (EditText)findViewById(R.id.editTextKodeMatakuliah);
        final EditText editTextHari = (EditText)findViewById(R.id.editTextHari);
        final EditText editTextSesi = (EditText)findViewById(R.id.editTextSesi);
        final EditText editTextSks = (EditText)findViewById(R.id.editTextSks);
        Button buttonSimpanMatakuliah = (Button)findViewById(R.id.buttonSimpanMatakuliah);
        pd = new ProgressDialog(MatakuliahAddActivity.this);
        buttonSimpanMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("SABAR YAAA hehehe :D");
                pd.show();
                //DIBUAT INTEGER KARENA DARI API NYA FORMAT NYA INTEGER JIKA DIBUAT STRING ERROR
                Integer hari = Integer.parseInt(editTextHari.getText().toString());
                Integer sesi = Integer.parseInt(editTextSesi.getText().toString());
                Integer sks = Integer.parseInt(editTextSks.getText().toString());
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_matkul(editTextNamaMatakuliah.getText().toString(),
                        "72180234", editTextKodeMatakuliah.getText().toString(),
                        hari,sesi,sks
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahAddActivity.this, "Data Berhasil Disimpan!", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahAddActivity.this, "GAGAL!", Toast.LENGTH_LONG).show();
                    }
                });
                Intent intentBackMainMhs = new Intent(MatakuliahAddActivity.this, MainMatakuliahActivity.class);
                startActivity(intentBackMainMhs);
            }
        });
    }
}