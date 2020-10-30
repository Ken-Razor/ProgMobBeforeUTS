package com.example.progmobbeforeuts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmobbeforeuts.Crud.MatakuliahUpdateActivity;
import com.example.progmobbeforeuts.Model.Matakuliah;
import com.example.progmobbeforeuts.R;

import java.util.ArrayList;
import java.util.List;

public class MatakuliahCRUDRecyclerAdapter extends RecyclerView.Adapter<MatakuliahCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Matakuliah> matakuliahList;
    public MatakuliahCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matakuliahList = new ArrayList<>();
    }
    public MatakuliahCRUDRecyclerAdapter(List<Matakuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
    }
    public List<Matakuliah> getMatakuliahList() {
        return matakuliahList;
    }
    public void setMatakuliahList(List<Matakuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MatakuliahCRUDRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_matakuliah, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MatakuliahCRUDRecyclerAdapter.ViewHolder holder, int position) {
        Matakuliah matakuliah = matakuliahList.get(position);
        holder.tvNamaMatakuliah.setText(matakuliah.getNamaMatkul());
        holder.tvKodeMatakuliah.setText(matakuliah.getKodeMatkul());
        holder.tvHari.setText(String.valueOf(matakuliah.getHari()));
        holder.tvSesi.setText(String.valueOf(matakuliah.getSesi()));
        holder.tvSks.setText(String.valueOf(matakuliah.getSks()));
        holder.matakakuliah = matakuliah;
    }
    @Override
    public int getItemCount() {
        return matakuliahList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNamaMatakuliah, tvKodeMatakuliah, tvHari, tvSesi, tvSks;
        private RecyclerView rvGetMatakuliah;
        Matakuliah matakakuliah;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMatakuliah = itemView.findViewById(R.id.tvNamaMatakuliah);
            tvKodeMatakuliah = itemView.findViewById(R.id.tvKodeMatakuliah);
            tvHari = itemView.findViewById(R.id.tvHari);
            tvSesi = itemView.findViewById(R.id.tvSesi);
            tvSks = itemView.findViewById(R.id.tvSks);
            rvGetMatakuliah = itemView.findViewById(R.id.rvGetMatakuliah);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goInput = new Intent(itemView.getContext(), MatakuliahUpdateActivity.class);
                    goInput.putExtra("kode", matakakuliah.getKodeMatkul());
                    goInput.putExtra("nama", matakakuliah.getNamaMatkul());
                    goInput.putExtra("hari", String.valueOf(matakakuliah.getHari()));
                    goInput.putExtra("sesi", String.valueOf(matakakuliah.getSesi()));
                    goInput.putExtra("sks", String.valueOf(matakakuliah.getSks()));
                    itemView.getContext().startActivity(goInput);
                }
            });
        }
    }
}
