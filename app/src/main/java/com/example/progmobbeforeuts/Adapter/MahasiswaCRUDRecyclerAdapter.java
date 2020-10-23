package com.example.progmobbeforeuts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmobbeforeuts.Crud.MahasiswaUpdateActivity;
import com.example.progmobbeforeuts.Model.Mahasiswa;
import com.example.progmobbeforeuts.R;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaCRUDRecyclerAdapter extends RecyclerView.Adapter<MahasiswaCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Mahasiswa> mahasiswaList;

    public MahasiswaCRUDRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }

    public MahasiswaCRUDRecyclerAdapter(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa m = mahasiswaList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.tvNim.setText(m.getNim());
        //holder.tvNoTelp.setText(m.getNoTelp());
        holder.tvAlamat.setText(m.getAlamat());
        holder.tvEmail.setText(m.getEmail());
        holder.mhs = m;
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvNoTelp, tvAlamat, tvEmail;
        private RecyclerView rvGetMhs;
        Mahasiswa mhs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            //tvNoTelp = itemView.findViewById(R.id.tvNoTelp);
            rvGetMhs = itemView.findViewById(R.id.rvGetMhs);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goInput = new Intent(itemView.getContext(), MahasiswaUpdateActivity.class);
                    goInput.putExtra("nim", mhs.getNim());
                    goInput.putExtra("nama", mhs.getNama());
                    goInput.putExtra("alamat", mhs.getAlamat());
                    goInput.putExtra("email", mhs.getEmail());
                    itemView.getContext().startActivity(goInput);
                }
            });
        }
    }

}
