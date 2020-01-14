package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfilActivity extends AppCompatActivity {

    Toolbar toolbarProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //Toolbar profil
        toolbarProfil = findViewById(R.id.toolbarProfil);
        setSupportActionBar(toolbarProfil);
        getSupportActionBar().setTitle("");
        toolbarProfil.setNavigationIcon(R.drawable.ic_back_white);

        //make back button on toolbar
        toolbarProfil.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}
