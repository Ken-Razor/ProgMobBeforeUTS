package com.example.progmobbeforeuts.Uts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.progmobbeforeuts.Crud.DosenAddActivity;
import com.example.progmobbeforeuts.Model.ModelLogin;
import com.example.progmobbeforeuts.Network.GetDataService;
import com.example.progmobbeforeuts.Network.RetrofitClientInstance;
import com.example.progmobbeforeuts.R;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText editTextNim, editTextPassword;
    Button btnLogin;
    String isLogin = "";
    ProgressDialog pd;
    private static final String PREFER_NAME = "preference";
    List<ModelLogin> responLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView txtViewSign = (TextView)findViewById(R.id.txtSignUp);
        editTextNim = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        pd = new ProgressDialog(LoginActivity.this);
        if (isLogin.equals("1")){
           Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
           startActivity(intent);
        }
        else {
            btnLogin.setText("Login");
        }
        txtViewSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Loading");
                pd.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<List<ModelLogin>> call = service.login(
                        editTextNim.getText().toString(),
                        editTextPassword.getText().toString()
                );
                if (editTextNim.getText().toString().isEmpty() && editTextPassword.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "DICOBA CEK DATANYA !!!", Toast.LENGTH_LONG).show();
                    pd.dismiss();
                    return;
                }
                call.enqueue(new Callback<List<ModelLogin>>() {
                    @Override
                    public void onResponse(Call<List<ModelLogin>> call, Response<List<ModelLogin>> response) {
                        responLogin = response.body();
                        pd.dismiss();
                        if (response.isSuccessful()) {
                            if (responLogin.size() == 0) {
                                Toast.makeText(LoginActivity.this, "Masukan NIM dan Password dengan Benar", Toast.LENGTH_LONG).show();
                                pd.dismiss();
                            } else {
                                editor.putString("nimnik", responLogin.get(0).getNimNik().toString());
                                editor.putString("password", responLogin.get(0).getPassword().toString());
                                editor.putString("isLogin", "1");
                                editor.commit();
                                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<List<ModelLogin>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}