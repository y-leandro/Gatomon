package com.example.u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class escolhergtm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhergtm);
        getSupportActionBar().hide();

    }


    public void cattwash(View v) {
        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
        MainActivity.escolhido = 1;
    }

    public void voltcat(View v) {
        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
        MainActivity.escolhido = 2;
    }

    public void mooncat(View v) {
        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
        MainActivity.escolhido = 3;
    }

}