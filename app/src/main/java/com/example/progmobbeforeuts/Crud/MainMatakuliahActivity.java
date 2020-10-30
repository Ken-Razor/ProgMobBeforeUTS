package com.example.progmobbeforeuts.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progmobbeforeuts.R;
import com.example.progmobbeforeuts.Uts.MenuActivity;

public class MainMatakuliahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matakuliah);
        Button btnGetMatakuliah = (Button)findViewById(R.id.btnGetMatakuliah);
        Button btnAddMatakuliah = (Button)findViewById(R.id.btnAddMatakuliah);
        Button btnUpdateMatakuliah = (Button)findViewById(R.id.btnUpdateMatakuliah);
        Button btnDelMatakuliah = (Button)findViewById(R.id.btnDelMatakuliah);
        Button btnMainMenu = (Button)findViewById(R.id.buttonMainMenu);

        btnGetMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatakuliahActivity.this, MatakuliahGetAllActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        btnAddMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatakuliahActivity.this, MatakuliahAddActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        btnUpdateMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatakuliahActivity.this, MatakuliahUpdateActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        btnDelMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatakuliahActivity.this, DosenDeleteActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatakuliahActivity.this, MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}