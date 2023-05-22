package com.example.u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        getSupportActionBar().hide();
    }

    public void novojogo(View v) {
        Intent j = new Intent(this, escolhergtm.class);
        startActivity(j);
    }


}