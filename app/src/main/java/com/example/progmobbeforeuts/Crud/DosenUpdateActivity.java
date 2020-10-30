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

public class DosenUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_update);
        final EditText updateNidnLama = (EditText)findViewById(R.id.updateNidnLama);
        final EditText updateNamaDosen = (EditText)findViewById(R.id.updateNamaDosen);
        final EditText updateNidn = (EditText)findViewById(R.id.updateNidn);
        final EditText updateAlamatDosen = (EditText)findViewById(R.id.updateAlamatDosen);
        final EditText updateEmailDosen = (EditText)findViewById(R.id.updateEmailDosen);
        final EditText updateGelarDosen = (EditText)findViewById(R.id.updateGelar);
        Button btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        pd = new ProgressDialog(DosenUpdateActivity.this);
        Intent data = getIntent();
        updateNidnLama.setText(data.getStringExtra("nidn"));
        updateNamaDosen.setText(data.getStringExtra("nama"));
        updateNidn.setText(data.getStringExtra("nidn"));
        updateAlamatDosen.setText(data.getStringExtra("alamat"));
        updateEmailDosen.setText(data.getStringExtra("email"));
        updateGelarDosen.setText(data.getStringExtra("gelar"));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Sabar ya :D");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> del= service.delete_mhs(updateNidnLama.getText().toString(), "72180234"
                );
                del.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(DosenUpdateActivity.this,"Berhasil Update", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Error!",Toast.LENGTH_LONG).show();
                    }
                });
                Call<DefaultResult> call = service.update_dosen(updateNamaDosen.getText().toString(),
                        updateNidn.getText().toString(), updateAlamatDosen.getText().toString(),
                        updateEmailDosen.getText().toString(), updateGelarDosen.getText().toString(),
                        "Hilang gatau kemana", "72180234", updateNidnLama.getText().toString()
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Berhasil disimpan",Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });
                Intent intentBackMainDosen = new Intent(DosenUpdateActivity.this, MainDosenActivity.class);
                startActivity(intentBackMainDosen);
            }
        });
    }
}