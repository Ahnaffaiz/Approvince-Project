package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Toolbar mTopToolbar;
    private RecyclerView rvProvince;
    private ArrayList<Province> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProvince = findViewById(R.id.rv_province);
        list.addAll(ProvinceData.getListData());
        showRecyclerList();


        //set Toolbar
        mTopToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setTitle("  APPROVINCE");
        getSupportActionBar().setLogo(R.drawable.logo_app);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.my_profil) {
            doAction();
            return true;
        }

        return super.onCreateOptionsMenu((Menu) menuItem);
    }


    private void showRecyclerList() {
        rvProvince.setLayoutManager(new LinearLayoutManager(this));
        ListProvinceAdapter listProvinceAdapter = new ListProvinceAdapter(list);
        rvProvince.setAdapter(listProvinceAdapter);
    }

    public void doAction() {
        Intent profilIntent = new Intent(MainActivity.this, ProfilActivity.class);
        startActivity(profilIntent);
    }


}
