package com.example.devinpradipta.as_sunnah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Tadarus extends AppCompatActivity {
    Button tadarus,kurang,tambah,simpan,hasils;
    Intent masuk;
    TextView hasilnya,hasilnya1;
    int jumlahTadarus = 0;
    String kata = "";
    RadioGroup haha;
    RadioButton satu,dua,tiga;
    SharedPreferences simpanTadarus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tadarus);
        tadarus = (Button) findViewById(R.id.button9);
        kurang = (Button) findViewById(R.id.button7);
        tambah = (Button) findViewById(R.id.button8);
        simpan = (Button) findViewById(R.id.button26);
        hasilnya = (TextView) findViewById(R.id.textView7);
        hasilnya1 = (TextView) findViewById(R.id.textView8);
        haha = (RadioGroup) findViewById(R.id.grups);


        tadarus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masuk = new Intent(getApplicationContext(),Masuk_progress.class);
                startActivity(masuk);
            }
        });



        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlahTadarus += 1;
                hasilnya.setText(jumlahTadarus + " ");
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jumlahTadarus -= 1;
                hasilnya.setText(jumlahTadarus + " ");
                if(jumlahTadarus < 0){
                    jumlahTadarus = 0;
                    hasilnya.setText(""+0);
                }
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanTadarus= getSharedPreferences("Tahajud", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = simpanTadarus.edit();
                edit.putString("THD", String.valueOf(jumlahTadarus));
                edit.apply();
                Toast.makeText(getApplicationContext(),"Data telah tersimpan",Toast.LENGTH_LONG).show();
            }
        });

        int id = haha.getCheckedRadioButtonId();
        satu = (RadioButton) findViewById(R.id.radioButton2);

    }
    }


