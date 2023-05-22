package com.example.u;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView es, ps;
    int pa1, pa2, pill;
    int act, ea1, ea2, ei, epill;
    int pl = 100;
    int el = 100;
    int pe = 5;
    int ee = 5;
    int md = 1;
    Random catk = new Random();
    static int escolhido = 0;
    static int inimigo = 0;
    ImageView imggato;
    ImageView imgdog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        es = findViewById(R.id.estats);
        ps = findViewById(R.id.pstats);

        escolha();
        escolheadver();
        arrumavida();
    }



    public void escolheadver() {
        imgdog = findViewById(R.id.dogmon);
        switch (inimigo){

            case 1:
                imgdog.setImageResource(R.drawable.mc_dogen);
                break;
            case 2:
                imgdog.setImageResource(R.drawable.goofydog);
                break;
            case 3:
                imgdog.setImageResource(R.drawable.baldbossdog);
                break;
            default:
                imgdog.setImageResource(R.drawable.advodog);
                break;

        }
    }



    public void restart(){
        if (verificalife()){
            pl = 100;
            el = 100;
            pe = 5;
            ee = 5;
            inimigo ++;
            Toast.makeText(this, "Fim de jogo.", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder itemgt = new AlertDialog.Builder(this);
            itemgt.setTitle("BOAA");
            itemgt.setMessage("Você derrotou o inimigo!");
            itemgt.setPositiveButton("Continuar", null);
            itemgt.create().show();
            escolheadver();
            arrumavida();
            if (inimigo == 4){
                Intent j = new Intent(this, fim.class);
                startActivity(j);
                inimigo = 0;
            }
        }
        if (gmover()){
            pl = 100;
            el = 100;
            pe = 5;
            ee = 5;
            AlertDialog.Builder itemgt = new AlertDialog.Builder(this);
            itemgt.setTitle("FIM DE JOGO");
            itemgt.setMessage("Você foi derrotado :(");
            itemgt.setNegativeButton("Recomeçar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    recomeca();
                }
            });
            itemgt.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pl = 100;
                    el = 100;
                    pe = 5;
                    ee = 5;
                    arrumavida();
                }
            });

            itemgt.create().show();
        }
    }

    public void recomeca(){
        Intent j = new Intent(this, inicio.class);
        startActivity(j);
        arrumavida();
    }

    public boolean gmover() {
            if (pl > 0){
                return false;
            }
        return true;
    }

    public boolean verificalife() {
            if (el > 0) {
                return false;
            }
        return true;
    }

    public void escolha (){
        imggato = findViewById(R.id.gtmon);
        if (escolhido == 1){
            imggato.setImageResource(R.drawable.cattwash);
        } else if (escolhido == 2){
            imggato.setImageResource(R.drawable.voltcat);
        } else {
            imggato.setImageResource(R.drawable.mooncat);
        }
    }

    public void atk1(View v){
        pa1 = catk.nextInt(5);
        if (el > 0){
            if (md == 1) {
                el -= pa1 + 5;
            } else {
                el -= pa1 + 15;
                md --;
            }
            actenemy();
            arrumavida();
        }
    }

    public void atk2(View v){
        pa2 = catk.nextInt(8)+ 7;
        if (pe > 0) {
            if (md == 1) {
                if (el > 0) {
                    el -= pa2;
                }
                else {
                    el -= pa2 + 7;
                    md --;
                }
            }
            pe--;
            arrumavida();
            actenemy();
        } else {
            Toast.makeText(this, "Você está sem energia.", Toast.LENGTH_SHORT).show();
        }
    }

    public void item(View v){
        pill = catk.nextInt(10)+1;
        AlertDialog.Builder itemgt = new AlertDialog.Builder(this);
        itemgt.setTitle("ITEM");
        itemgt.setMessage("Escolha um item:");
        itemgt.setPositiveButton("Poção de cura", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pl += pill;
                arrumavida();
                actenemy();
            }
        });
        itemgt.setNeutralButton("Poção de força", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                md ++;
                arrumavida();
                actenemy();
            }
        });
        itemgt.setNegativeButton("Poção de estamina", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pe ++;
                arrumavida();
                actenemy();
            }
        });

        itemgt.create().show();

    }

    public void actenemy(){
        act = catk.nextInt(5);
        switch (act){
            case 1:
                eatk2();
                break;
            case 2:
                eitem();
                break;
            default:
                eatk1();
                break;
        }

    }

    public void eatk1(){
        ea1 = catk.nextInt(6);
        if (pl > 0){
            pl -= ea1 + 5;
            arrumavida();
        }
    }

    public void eatk2(){
        ea2 = catk.nextInt(5);
        if (ee > 0) {
            if (pl > 0) {
                pl -= ea2 + 7;
            }
            ee--;
            arrumavida();
        }
    }

    public void eitem(){
        ei = catk.nextInt(3);
        epill = catk.nextInt(7)+1;
        switch (ei){
            case 1:
                ee ++;
                arrumavida();
                break;
            default:
                el += epill;
                arrumavida();
                break;
        }
    }



    public void arrumavida (){
        ps.setText("HP: "+pl+ " SP: "+pe);
        es.setText("HP: "+el);
        restart();
    }



}