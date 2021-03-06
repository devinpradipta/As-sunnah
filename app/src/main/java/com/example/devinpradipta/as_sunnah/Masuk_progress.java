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

import org.w3c.dom.Text;

public class Masuk_progress extends AppCompatActivity {
    Button progress,tambahDhuha,kurangDhuha,tambahTahajud,kurangTahajud,tambahDzikir,kurangDzikir,simpan,simpan11,simpan22,simpan33;
    Intent menu;
    TextView dhuha,tahajud,zakat,dzikir;
    int progresDhuha;
    int progresTahajud;
    int progresZakat;
    int progressZikir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_progress);
        progress = (Button) findViewById(R.id.button16);
        dhuha = (TextView) findViewById(R.id.textView9);
        tahajud = (TextView) findViewById(R.id.textView10);

        dzikir = (TextView) findViewById(R.id.textView12);
        tambahDhuha = (Button) findViewById(R.id.button10);
        kurangDhuha = (Button) findViewById(R.id.button11);
        tambahTahajud = (Button) findViewById(R.id.button12);
        kurangTahajud = (Button) findViewById(R.id.button13);
        tambahDzikir = (Button) findViewById(R.id.button18);
        kurangDzikir = (Button) findViewById(R.id.button19);

        simpan11 = (Button) findViewById(R.id.button27);
        simpan22 = (Button) findViewById(R.id.button30);
        simpan33 = (Button) findViewById(R.id.button32);



        //load progress all
        SharedPreferences sp = getSharedPreferences("PROGRESS",Context.MODE_PRIVATE);
        final String dhuhaku = sp.getString("DHUHAKU","");
        final String tahajudku = sp.getString("TAHAJUDKU","");
        final String zikirku = sp.getString("ZIKIRKU","");




        //dhuha
        SharedPreferences save1 = getSharedPreferences("simpanDHH", Context.MODE_PRIVATE);
        final String testing = save1.getString("DHH","");
        dhuha.setText("Dhuha: "+ dhuhaku + "/"+ testing + " rakaat" );
        //tahajud
        final SharedPreferences simpanTahajud = getSharedPreferences("Tahajud", Context.MODE_PRIVATE);
        final String hasil = simpanTahajud.getString("THD", "");
        tahajud.setText("Tahajud: " + tahajudku + "/" + hasil + " rakaat");

        //dzikir
        final SharedPreferences simpanDzikir = getSharedPreferences("DZIKIR", Context.MODE_PRIVATE);
        final String results = simpanDzikir.getString("DZZ","");
        dzikir.setText("Dzikir: " + zikirku + "/" + results + " kali");

        simpan11.setEnabled(false);
        simpan22.setEnabled(false);
        simpan33.setEnabled(false);

        simpan11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("PROGRESS",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("DHUHAKU",String.valueOf(progresDhuha));
                edit.apply();
                Toast.makeText(getApplicationContext(),"Data telah tersimpan",Toast.LENGTH_SHORT).show();
            }
        });

        simpan22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("PROGRESS",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("TAHAJUDKU",String.valueOf(progresTahajud));
                edit.apply();
                Toast.makeText(getApplicationContext(),"Data telah tersimpan",Toast.LENGTH_SHORT).show();
            }
        });


        simpan33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("PROGRESS",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("ZIKIRKU",String.valueOf(progresTahajud));
                edit.apply();
                Toast.makeText(getApplicationContext(),"Data telah tersimpan",Toast.LENGTH_SHORT).show();
            }
        });

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu = new Intent(getApplicationContext(),Penjelasan.class);
                startActivity(menu);
            }
        });

        tambahDhuha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan11.setEnabled(true);
                SharedPreferences save = getSharedPreferences("simpanDHH", Context.MODE_PRIVATE);
                final int testing = Integer.parseInt(save.getString("DHH",""));
                progresDhuha = progresDhuha + 1;
                dhuha.setText("Dhuha: "+ progresDhuha + "/"+ testing + " rakaat" );
                if(progresDhuha > testing){
                        progresDhuha = testing;
                }

            }
        });

        kurangDhuha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan11.setEnabled(true);
                progresDhuha -= 1;
                dhuha.setText("Dhuha: "+ progresDhuha + "/"+ testing + " rakaat" );
                if(progresDhuha < 1){
                    dhuha.setText("Dhuha: "+ progresDhuha + "/"+ testing + " rakaat" );
                }


            }
        });

        tambahTahajud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan22.setEnabled(true);
                SharedPreferences simpanTahajud = getSharedPreferences("Tahajud", Context.MODE_PRIVATE);
                final int hasil = Integer.parseInt(simpanTahajud.getString("THD", ""));
                progresTahajud = progresTahajud + 1;
                tahajud.setText("Tahajud: "+ progresTahajud + "/" + hasil + " rakaat");
                if(progresTahajud > hasil){
                    progresTahajud = hasil;
                }
            }
        });

        kurangTahajud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan22.setEnabled(true);
                progresTahajud = progresTahajud - 1;
                tahajud.setText("Tahajud: "+ progresTahajud + "/" + hasil + " rakaat");
                if(progresTahajud < 1){
                    tahajud.setText("Tahajud: "+ progresTahajud + "/" + hasil + " rakaat");
                }
            }
        });

        tambahDzikir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan33.setEnabled(true);
                progressZikir += 1;
                final SharedPreferences simpanDzikir = getSharedPreferences("DZIKIR", Context.MODE_PRIVATE);
                final int results = Integer.parseInt(simpanDzikir.getString("DZZ",""));
                dzikir.setText("Dzikir: " + progressZikir + "/" + results + " kali");
                if(progressZikir >= results){
                    progressZikir = results;
                }
            }
        });

        kurangDzikir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan33.setEnabled(true);
                progressZikir = progressZikir - 1;
                dzikir.setText("Dzikir: " + progressZikir + "/" + results + " kali");
                if(progressZikir < 1){
                    dzikir.setText("Dzikir: " + progressZikir + "/" + results + " kali");
                }
            }
        });



    }
}
