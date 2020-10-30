package com.example.progmobbeforeuts.Uts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.progmobbeforeuts.Crud.MainDosenActivity;
import com.example.progmobbeforeuts.Crud.MainMatakuliahActivity;
import com.example.progmobbeforeuts.Crud.MainMhsActivity;
import com.example.progmobbeforeuts.MainActivity;
import com.example.progmobbeforeuts.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton imgBtnMhs = (ImageButton)findViewById(R.id.imgBtnMhs);
        ImageButton imgBtnMatkul = (ImageButton)findViewById(R.id.imgBtnMatkul);
        ImageButton imgBtnDosen = (ImageButton)findViewById(R.id.imgBtnDosen);
        ImageButton imgLogout = (ImageButton)findViewById(R.id.imgLogout);
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setMessage("Anda Yakin Mau Logout??").setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActivity.this, "Batal Logout", Toast.LENGTH_LONG).show();
                    }
                })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences  pref = MenuActivity.this.getSharedPreferences("preference",MODE_PRIVATE);
                                String isLogin = pref.getString("isLogin", null);
                                SharedPreferences.Editor edit = pref.edit();
                                edit.putString("isLogin","0");
                                edit.commit();
                                Intent intentLogout = new Intent(MenuActivity.this, LoginActivity.class);
                                intentLogout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intentLogout);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        imgBtnMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainMhsActivity.class);
                startActivity(intent);
            }
        });
        imgBtnDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainDosenActivity.class);
                startActivity(intent);
            }
        });
        imgBtnMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainMatakuliahActivity.class);
                startActivity(intent);
            }
        });
    }
}