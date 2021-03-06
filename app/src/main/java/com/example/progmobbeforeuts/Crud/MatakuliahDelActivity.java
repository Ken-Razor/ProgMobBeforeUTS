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

public class MatakuliahDelActivity extends AppCompatActivity {
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_del);
        EditText editTextHapusMatakuliah = (EditText)findViewById(R.id.editTextHapusMatakuliah);
        Button btnHapusMatakuliah = (Button)findViewById(R.id.buttonHapusMatakuliah);
        pd = new ProgressDialog(MatakuliahDelActivity.this);
        btnHapusMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Anak Sabar Disayang Tuhan :D");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_matkul(
                        editTextHapusMatakuliah.getText().toString(),"72180234"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahDelActivity.this, "Data Terhapus", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahDelActivity.this, "Galat Error", Toast.LENGTH_LONG).show();
                    }
                });
                Intent intentBackMainMhs = new Intent(MatakuliahDelActivity.this, MainMatakuliahActivity.class);
                startActivity(intentBackMainMhs);
            }
        });
    }
}