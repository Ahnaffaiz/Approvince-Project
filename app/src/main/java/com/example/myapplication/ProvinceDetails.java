package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProvinceDetails extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra name";
    public static final String EXTRA_IBUKOTA = "extra ibu kota";
    public static final String EXTRA_PENDUDUK = "extra penduduk";
    public static final String EXTRA_LUAS = "extra luas";
    public static final String EXTRA_DESKRIPSI = "extra deskripsi";
    public static final String EXTRA_KOTA = "extra kota";
    public static final String EXTRA_KABUPATEN = "extra kabupaten";
    public static final String EXTRA_LOGO = "extra logo";
    public static final String EXTRA_URL = "extra url";
    ImageView logoBig;
    TextView namaProvinsi, ibuKotaProvinsi, deskripsiProvinsi, pendudukProvinsi, luasProvinsi, jmlKabupaten, jmlKota;
    Button btnViewDetails;
    Toolbar toolbarDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province_details);

        logoBig = findViewById(R.id.img_logo_big);
        namaProvinsi = findViewById(R.id.nama_provinsi);
        ibuKotaProvinsi = findViewById(R.id.ibu_kota_provinsi);
        deskripsiProvinsi = findViewById(R.id.detail_provinsi);
        pendudukProvinsi = findViewById(R.id.penduduk_provinsi);
        luasProvinsi = findViewById(R.id.luas_provinsi);
        jmlKabupaten = findViewById(R.id.jml_kabupaten);
        jmlKota = findViewById(R.id.jml_kota);
        btnViewDetails = findViewById(R.id.btn_view_details);

        String nama = getIntent().getStringExtra(EXTRA_NAME);
        String ibuKota = getIntent().getStringExtra(EXTRA_IBUKOTA);
        String deskripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);
        int penduduk = getIntent().getIntExtra(EXTRA_PENDUDUK, 200);
        int luas = getIntent().getIntExtra(EXTRA_LUAS, 0);
        int kota = getIntent().getIntExtra(EXTRA_KOTA, 0);
        int kabupaten = getIntent().getIntExtra(EXTRA_KABUPATEN, 0);
        int logo = getIntent().getIntExtra(EXTRA_LOGO, 0);
        final String url = getIntent().getStringExtra(EXTRA_URL);

        String kabupaten1 = kabupaten + "";
        String kota1 = kota + "";
        String nama1 = nama;
        String ibuKota1 = ibuKota;
        String deskripsi1 = deskripsi;
        String penduduk1 = penduduk + " Jiwa";
        String luas1 = luas + " km²";
        int logo1 = logo;


        namaProvinsi.setText(nama1);
        ibuKotaProvinsi.setText(ibuKota1);
        deskripsiProvinsi.setText(deskripsi1);
        pendudukProvinsi.setText(penduduk1);
        luasProvinsi.setText(luas1);
        jmlKabupaten.setText(kabupaten1);
        jmlKota.setText(kota1);
        logoBig.setImageResource(logo1);

        //set Toolbar
        toolbarDetails = findViewById(R.id.toolbarDetails);
        setSupportActionBar(toolbarDetails);
        getSupportActionBar().setTitle(nama1.toUpperCase());
        toolbarDetails.setNavigationIcon(R.drawable.ic_back);

        //make back button on toolbar
        toolbarDetails.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        btnViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });


    }


}
