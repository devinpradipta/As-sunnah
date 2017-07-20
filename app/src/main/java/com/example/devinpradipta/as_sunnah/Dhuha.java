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

public class Dhuha extends AppCompatActivity {
    Button update,kurang,tambah,simpan;
    Intent lihatUpdate;
    TextView hasil,hasil1;
    int rakaatDhuha = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhuha);
        update = (Button) findViewById(R.id.button3);
        kurang = (Button) findViewById(R.id.button);
        tambah = (Button) findViewById(R.id.button2);
        simpan = (Button) findViewById(R.id.button23);
        hasil = (TextView) findViewById(R.id.textView4);
        hasil1 = (TextView) findViewById(R.id.textView3);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lihatUpdate = new Intent(getApplicationContext(),Masuk_progress.class);
                startActivity(lihatUpdate);
            }
        });


        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rakaatDhuha = rakaatDhuha + 1;
                hasil1.setText(""+rakaatDhuha);
                if(rakaatDhuha == 8 || rakaatDhuha == 15 || rakaatDhuha == 20){
                    Toast.makeText(getApplicationContext(),"Jangan terlalu banyak memasang target, target sudah melebihi " + rakaatDhuha + " Rakaat",Toast.LENGTH_LONG).show();
                }


                if(rakaatDhuha <= 0){
                    rakaatDhuha = 0;
                    hasil1.setText(""+0);
                }
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rakaatDhuha = rakaatDhuha - 1;
                hasil1.setText(""+rakaatDhuha);
                if(rakaatDhuha <= 0){
                    rakaatDhuha = 0;
                    hasil1.setText(""+0);
                }
            }
        });

        SharedPreferences save = getSharedPreferences("simpanDHH",Context.MODE_PRIVATE);
        String testing = save.getString("DHH","");
        hasil1.setText(""+testing);
        hasil.setText("Target Dhuha "+testing+" Rakaat");
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences save = getSharedPreferences("simpanDHH",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = save.edit();
                edit.putString("DHH", String.valueOf(rakaatDhuha));
                edit.apply();
                Toast.makeText(getApplicationContext(),"Data telah tersimpan",Toast.LENGTH_LONG).show();
            }
        });

    }




}
