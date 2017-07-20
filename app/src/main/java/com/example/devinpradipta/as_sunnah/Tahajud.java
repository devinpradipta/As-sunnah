package com.example.devinpradipta.as_sunnah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tahajud extends AppCompatActivity {
    Intent tahajud;
    Button progress,tambah,kurang,simpan;
    int rakaatTahajud = 0;
    TextView rakaatThd,angkaRakaat;
    SharedPreferences simpanTahajud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahajud);
        progress = (Button) findViewById(R.id.button6);
        tambah = (Button) findViewById(R.id.button5);
        kurang = (Button) findViewById(R.id.button4);
        simpan = (Button) findViewById(R.id.button24);
        rakaatThd = (TextView) findViewById(R.id.textView6);
        angkaRakaat = (TextView) findViewById(R.id.textView5);

        simpanTahajud = getSharedPreferences("Tahajud", Context.MODE_PRIVATE);
        String hasil = simpanTahajud.getString("THD", String.valueOf(rakaatTahajud));
        rakaatThd.setText("Target Tahajud " + hasil + " Rakaat");

        if (rakaatTahajud <= 0) {
            rakaatTahajud = 0;
        }

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tahajud = new Intent(getApplicationContext(),Masuk_progress.class);
                startActivity(tahajud);
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rakaatTahajud == 8 || rakaatTahajud == 15 || rakaatTahajud == 20){
                    Toast.makeText(getApplicationContext(),"Jangan terlalu banyak memasang target,target melebihi " + rakaatTahajud + " Rakaat",Toast.LENGTH_LONG).show();
                }


                rakaatTahajud += 1;
                angkaRakaat.setText(""+rakaatTahajud);
            }


        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rakaatTahajud -= 1;
                angkaRakaat.setText(""+rakaatTahajud);
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanTahajud = getSharedPreferences("Tahajud", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = simpanTahajud.edit();
                edit.putString("THD", String.valueOf(rakaatTahajud));
                edit.apply();
                Toast.makeText(getApplicationContext(),"Data telah tersimpan",Toast.LENGTH_LONG).show();
            }
        });
    }
}
