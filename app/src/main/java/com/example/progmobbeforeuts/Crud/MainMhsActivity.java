package com.example.progmobbeforeuts.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progmobbeforeuts.MainActivity;
import com.example.progmobbeforeuts.Pertemuan2.CardViewTestActivity;
import com.example.progmobbeforeuts.R;

public class MainMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        Button btnGetMhs = (Button)findViewById(R.id.buttonGetMhs);
        Button btnAddMhs = (Button)findViewById(R.id.buttonAddMhs);
        Button btnUpdateMhs = (Button)findViewById(R.id.buttonUpdateMhs);
        Button btnDeleteMhs = (Button)findViewById(R.id.buttonDelMhs);

        btnGetMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intent);
            }
        });
        btnAddMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class);
                startActivity(intent);
            }
        });
        btnUpdateMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaUpdateActivity.class);
                startActivity(intent);
            }
        });
        btnDeleteMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaDeleteActivity.class);
                startActivity(intent);
            }
        });
    }
}