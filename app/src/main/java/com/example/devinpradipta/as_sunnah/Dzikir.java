package com.example.devinpradipta.as_sunnah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Dzikir extends AppCompatActivity {
    Button Masuk,kurang,tambah,saves;
    Intent zikir;
    int jumlahDzikir = 0;
    TextView hasilnya,jumlah;
    CheckBox Subhanallah,Alhamdulillah,Allahuakbar,Astagfirullah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir);
        Masuk = (Button) findViewById(R.id.button21);
        kurang = (Button) findViewById(R.id.button20);
        tambah = (Button) findViewById(R.id.button17);
        saves = (Button) findViewById(R.id.button25);
        Subhanallah = (CheckBox) findViewById(R.id.checkBox);
        Alhamdulillah = (CheckBox) findViewById(R.id.checkBox2);
        Allahuakbar = (CheckBox) findViewById(R.id.checkBox3);
        Astagfirullah = (CheckBox) findViewById(R.id.checkBox4);
        hasilnya = (TextView) findViewById(R.id.textView14);
        jumlah = (TextView) findViewById(R.id.textView13);




        Masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zikir = new Intent(getApplicationContext(),Masuk_progress.class);
                startActivity(zikir);
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlahDzikir -= 1;
                jumlah.setText(""+jumlahDzikir);
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jumlahDzikir >= 33){
                    Toast.makeText(getApplicationContext(),"Jangan terlalu banyak memasang target",Toast.LENGTH_LONG).show();
                }
                jumlahDzikir += 1;
                jumlah.setText(""+jumlahDzikir);
            }
        });

        SharedPreferences simpanDzikir = getSharedPreferences("DZIKIR", Context.MODE_PRIVATE);
        String results = simpanDzikir.getString("DZZ","");
        hasilnya.setText("target Dzikir "+ results+ " kali");
        Subhanallah.setChecked(simpanDzikir.getBoolean("SBB",false));
        Alhamdulillah.setChecked(simpanDzikir.getBoolean("ALH",false));
        Allahuakbar.setChecked(simpanDzikir.getBoolean("ALK",false));
        Astagfirullah.setChecked(simpanDzikir.getBoolean("AST",false));
        saves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences simpanDzikir = getSharedPreferences("DZIKIR", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = simpanDzikir.edit();
                edit.putString("DZZ",String.valueOf(jumlahDzikir));
                edit.putBoolean("SBB",Boolean.valueOf(Subhanallah.isChecked()));
                edit.putBoolean("ALH",Boolean.valueOf(Alhamdulillah.isChecked()));
                edit.putBoolean("ALK",Boolean.valueOf(Allahuakbar.isChecked()));
                edit.putBoolean("AST",Boolean.valueOf(Astagfirullah.isChecked()));
                edit.apply();
                Toast.makeText(getApplicationContext(),"Data telah tersimpan",Toast.LENGTH_LONG).show();
            }


        });


    }
}
