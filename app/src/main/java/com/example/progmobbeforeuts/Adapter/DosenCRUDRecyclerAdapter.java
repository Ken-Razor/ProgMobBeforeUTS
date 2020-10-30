package com.example.progmobbeforeuts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.progmobbeforeuts.Crud.DosenUpdateActivity;
import com.example.progmobbeforeuts.Model.Dosen;
import com.example.progmobbeforeuts.R;

import java.util.ArrayList;
import java.util.List;

public class DosenCRUDRecyclerAdapter extends RecyclerView.Adapter<DosenCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Dosen> dosenList;
    public DosenCRUDRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
    }
    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }
    public List<Dosen> getDosenList() {
        return dosenList;
    }
    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_dosen, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen dsn = dosenList.get(position);
        holder.tvNamaDosen.setText(dsn.getNamaDosen());
        holder.tvNidnDosen.setText(dsn.getNidnDosen());
        holder.tvAlamatDosen.setText(dsn.getAlamatDosen());
        holder.tvEmailDosen.setText(dsn.getEmailDosen());
        holder.tvGelarDosen.setText(dsn.getGelar());
        holder.dosen = dsn;
    }
    @Override
    public int getItemCount() {
        return dosenList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNamaDosen, tvNidnDosen, tvAlamatDosen, tvEmailDosen, tvGelarDosen;
        private RecyclerView rvGetDosen;
        Dosen dosen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaDosen = itemView.findViewById(R.id.tvNamaDosen);
            tvNidnDosen = itemView.findViewById(R.id.tvNidn);
            tvAlamatDosen = itemView.findViewById(R.id.tvAlamatDosen);
            tvEmailDosen = itemView.findViewById(R.id.tvEmailDosen);
            tvGelarDosen = itemView.findViewById(R.id.tvGelarDosen);
            rvGetDosen = itemView.findViewById(R.id.rvGetDosen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goInput = new Intent(itemView.getContext(), DosenUpdateActivity.class);
                    goInput.putExtra("nidn", dosen.getNidnDosen());
                    goInput.putExtra("nama", dosen.getNamaDosen());
                    goInput.putExtra("alamat", dosen.getAlamatDosen());
                    goInput.putExtra("email", dosen.getEmailDosen());
                    goInput.putExtra("gelar", dosen.getGelar());
                    itemView.getContext().startActivity(goInput);
                }
            });
        }
    }
}
