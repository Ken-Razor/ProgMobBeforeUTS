package com.example.progmobbeforeuts.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class MahasiswaUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);
        final EditText updateNimLama = (EditText)findViewById(R.id.updateNimLama);
        final EditText updateNama = (EditText)findViewById(R.id.updateNama);
        final EditText updateNim = (EditText)findViewById(R.id.updateNim);
        final EditText updateAlamat = (EditText)findViewById(R.id.updateAlamat);
        final EditText updateEmail = (EditText)findViewById(R.id.updateEmail);
        Button btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        pd = new ProgressDialog(MahasiswaUpdateActivity.this);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Sabar ya :D");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> del= service.delete_mhs(updateNimLama.getText().toString(), "72180234"
                );
                del.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(MahasiswaUpdateActivity.this,"Berhasil Update", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Error!",Toast.LENGTH_LONG).show();
                    }
                });
                Call<DefaultResult> add= service.add_mhs(updateNama.getText().toString(),
                        updateNim.getText().toString(), updateAlamat.getText().toString(),
                        updateEmail.getText().toString(),"kosongkan saja","72180234"
                );
                add.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Berhasil disimpan",Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}