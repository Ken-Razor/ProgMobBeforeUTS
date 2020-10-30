package com.example.progmobbeforeuts.Uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.progmobbeforeuts.Model.ModelRegis;
import com.example.progmobbeforeuts.R;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextNim, editTextPassword, editTextEmail, editTextNama;
    Button btnRegis;
    String isCreate = "";
    private static final String PREFER_NAME = "preference";
    List<ModelRegis> responRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView txtViewSign = (TextView)findViewById(R.id.txtSignIn);
        editTextNim = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextNama = (EditText)findViewById(R.id.editTextNama);
        btnRegis = (Button)findViewById(R.id.btnRegis);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (isCreate.equals("1")){
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        else {
            btnRegis.setText("Registed");
        }
        txtViewSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        /// Belum Jadi Pak Fitur Regis nya
    }
}