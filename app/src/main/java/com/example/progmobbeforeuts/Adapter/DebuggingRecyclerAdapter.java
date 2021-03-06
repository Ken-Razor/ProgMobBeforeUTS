package com.example.progmobbeforeuts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.progmobbeforeuts.Model.Mahasiswa;
import com.example.progmobbeforeuts.Model.MahasiswaDebugging;
import com.example.progmobbeforeuts.R;

import java.util.ArrayList;
import java.util.List;


public class DebuggingRecyclerAdapter extends RecyclerView.Adapter<DebuggingRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<MahasiswaDebugging> mahasiswaList;

    public DebuggingRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }

    public List<MahasiswaDebugging> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<MahasiswaDebugging> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_debugging,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        MahasiswaDebugging m = mahasiswaList.get(i);

        holder.tvNama.setText(m.getNama());
        holder.tvNoTelp.setText(m.getNotelp());
        holder.tvNim.setText(m.getNim());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNoTelp = itemView.findViewById(R.id.tvNoTelp);
        }
    }
}
