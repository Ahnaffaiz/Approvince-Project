package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListProvinceAdapter extends RecyclerView.Adapter<ListProvinceAdapter.ListViewHolder> {

    public CardView cvProvince;
    private ArrayList<Province> listProvince;

    public ListProvinceAdapter(ArrayList<Province> list) {
        this.listProvince = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_province, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Province province = listProvince.get(position);
        Glide.with(holder.itemView.getContext())
                .load(province.getLogo())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imgLogo);
        holder.tvName.setText(province.getProvince_name());
        holder.tvKota.setText(province.getKota());


        holder.cvProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailActivity = new Intent(v.getContext(), ProvinceDetails.class);
                detailActivity.putExtra(ProvinceDetails.EXTRA_NAME, province.getProvince_name());
                detailActivity.putExtra(ProvinceDetails.EXTRA_IBUKOTA, province.getKota());
                detailActivity.putExtra(ProvinceDetails.EXTRA_PENDUDUK, province.getJumlahPenduduk());
                detailActivity.putExtra(ProvinceDetails.EXTRA_LUAS, province.getLuasWil());
                detailActivity.putExtra(ProvinceDetails.EXTRA_KABUPATEN, province.getJml_kabupaten());
                detailActivity.putExtra(ProvinceDetails.EXTRA_KOTA, province.getJml_kota());
                detailActivity.putExtra(ProvinceDetails.EXTRA_LOGO, province.getLogo());
                detailActivity.putExtra(ProvinceDetails.EXTRA_DESKRIPSI, province.getDetail());
                detailActivity.putExtra(ProvinceDetails.EXTRA_URL, province.getWebDetail());
                v.getContext().startActivity(detailActivity);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listProvince.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        CardView cvProvince;
        ImageView imgLogo;
        TextView tvName, tvKota;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_logo);
            tvName = itemView.findViewById(R.id.tv_item_view);
            tvKota = itemView.findViewById(R.id.tv_item_kota);
            cvProvince = itemView.findViewById(R.id.cv_province);
        }
    }
}
