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

public class MahasiswaAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_add);
        EditText editNama = (EditText)findViewById(R.id.editTextNama);
        EditText editNim = (EditText)findViewById(R.id.editTextNimTambah);
        EditText editAlamat = (EditText)findViewById(R.id.editTextAlamat);
        EditText editEmail = (EditText)findViewById(R.id.editTextEmail);
        Button btnSimpan = (Button)findViewById(R.id.buttonSimpan);
        pd = new ProgressDialog(MahasiswaAddActivity.this);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Hayo Kudu Sabaarrrrrr :D");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mhs(editNama.getText().toString(), editNim.getText().toString(),
                        editAlamat.getText().toString(), editEmail.getText().toString(),"ini nda penting Kosong kan aja",
                        "72180234"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this, "Data Berhasil Disimpan!", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this, "GAGAL!", Toast.LENGTH_LONG).show();
                    }
                });
                Intent intentBackMainMhs = new Intent(MahasiswaAddActivity.this, MainMhsActivity.class);
                startActivity(intentBackMainMhs);
            }
        });
    }
}