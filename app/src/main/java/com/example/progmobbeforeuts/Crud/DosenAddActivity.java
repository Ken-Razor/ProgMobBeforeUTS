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

public class DosenAddActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add);
        final EditText editTextNamaDosen = (EditText)findViewById(R.id.editTextNamaDosen);
        final EditText editTextNidnTambah = (EditText)findViewById(R.id.editTextNidnTambah);
        final EditText editTextAlamatDosen = (EditText)findViewById(R.id.editTextAlamatDosen);
        final EditText editTextEmailDosen = (EditText)findViewById(R.id.editTextEmailDosen);
        final EditText editTextGelar = (EditText)findViewById(R.id.editTextGelar);
        Button btnSimpanDosen = (Button)findViewById(R.id.buttonSimpanDosen);
        pd = new ProgressDialog(DosenAddActivity.this);
        btnSimpanDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("SABAR YAAA :D");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dosen(
                        editTextNamaDosen.getText().toString(),
                        editTextNidnTambah.getText().toString(),
                        editTextAlamatDosen.getText().toString(),
                        editTextEmailDosen.getText().toString(),
                        editTextGelar.getText().toString(),
                        "ini kosong aja",
                        "72180234"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Data Berhasil Disimpan!", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "GAGAL!", Toast.LENGTH_LONG).show();
                    }
                });
                Intent intentBackMainMhs = new Intent(DosenAddActivity.this, MainDosenActivity.class);
                startActivity(intentBackMainMhs);
            }
        });
    }
}