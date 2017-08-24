package com.example.devinpradipta.as_sunnah;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HalamanProfil extends AppCompatActivity {
    Button enters;
    TextView Dzikir,Zakat,Dhuha,Tahajud,Tadarus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_profil);
        enters = (Button) findViewById(R.id.button29);
        Dzikir = (TextView) findViewById(R.id.test1);
        Zakat = (TextView) findViewById(R.id.test2);
        Dhuha = (TextView) findViewById(R.id.test3);
        Tahajud = (TextView) findViewById(R.id.test4);
        Tadarus = (TextView) findViewById(R.id.test5);
        enters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Penjelasan.class);
                startActivity(i);
            }
        });
        //load progress all
        SharedPreferences sp = getSharedPreferences("PROGRESS", Context.MODE_PRIVATE);
        final String dhuhaku = sp.getString("DHUHAKU","");
        final String tahajudku = sp.getString("TAHAJUDKU","");
        final String zakatku = sp.getString("ZAKATKU","");
        final String zikirku = sp.getString("ZIKIRKU","");

        //dhuha
        SharedPreferences save = getSharedPreferences("simpanDHH", Context.MODE_PRIVATE);
        final String testing = save.getString("DHH","");
        Dhuha.setText(""+dhuhaku + "/"+ testing + " rakaat");
        //tahajud
        final SharedPreferences simpanTahajud = getSharedPreferences("Tahajud", Context.MODE_PRIVATE);
        final String hasil = simpanTahajud.getString("THD", "");
        Tahajud.setText(""+tahajudku + "/" + hasil + " rakaat");
        //zakat
        final SharedPreferences simpanZakat = getSharedPreferences("Zakat", Context.MODE_PRIVATE);
        final String hehe = simpanZakat.getString("ZKT","");
        Zakat.setText("Rp " + hehe);
        //dzikir
        final SharedPreferences simpanDzikir = getSharedPreferences("DZIKIR", Context.MODE_PRIVATE);
        final String results = simpanDzikir.getString("DZZ","");
        Dzikir.setText(zikirku + "/" + results );
    }
}
