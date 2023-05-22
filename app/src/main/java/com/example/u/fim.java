package com.example.u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);
    }

    public void recomecar(View v){
        Intent j = new Intent(this, inicio.class);
        startActivity(j);
        super.onBackPressed();
    }

}