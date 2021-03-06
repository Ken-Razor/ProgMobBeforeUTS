package com.example.progmobbeforeuts.Pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.example.progmobbeforeuts.Adapter.MahasiswaCardAdapter;
import com.example.progmobbeforeuts.Adapter.MahasiswaRecyclerAdapter;
import com.example.progmobbeforeuts.Model.Mahasiswa;
import com.example.progmobbeforeuts.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_test);

        RecyclerView rv = (RecyclerView)findViewById(R.id.cvLatihan);
        MahasiswaCardAdapter mahasiswaCardAdapter;

        //data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Ken", "72180234", "0822222222");
        Mahasiswa m2 = new Mahasiswa("Will", "72180230", "082111211");
        Mahasiswa m3 = new Mahasiswa("Chris", "72180247", "02332113");
        Mahasiswa m4 = new Mahasiswa("Bill", "72180240", "312123123");
        Mahasiswa m5 = new Mahasiswa("Dennis", "72180226", "46456451");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        mahasiswaCardAdapter = new MahasiswaCardAdapter(CardViewTestActivity.this);
        mahasiswaCardAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(CardViewTestActivity.this));
        rv.setAdapter(mahasiswaCardAdapter);


    }
}