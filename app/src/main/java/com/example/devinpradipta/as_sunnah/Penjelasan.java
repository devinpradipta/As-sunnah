package com.example.devinpradipta.as_sunnah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class Penjelasan extends AppCompatActivity {
    ListView penjelasan;
    String[] isi = {"Progress Anda","Dhuha","tahajud","tadarus","Dzikir","Zakat","Jadwal Shalat","Setting"};
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjelasan);
        penjelasan = (ListView) findViewById(R.id.menu_utama);

        ArrayAdapter<String> adapternya = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,isi);

        penjelasan.setAdapter(adapternya);

        penjelasan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    i = new Intent(getApplication(), Masuk_progress.class);
                    startActivity(i);
                } else if (position == 1) {
                    i = new Intent(getApplication(), Dhuha.class);
                    startActivity(i);
                }else if (position == 2){
                    i = new Intent(getApplication(), Tahajud.class);
                    startActivity(i);
                }else if (position == 3){
                    i = new Intent(getApplication(), Tadarus.class);
                    startActivity(i);
                }else if (position == 4){
                    i = new Intent(getApplication(), Dzikir.class);
                    startActivity(i);
                }else if (position == 5){
                    i = new Intent(getApplication(), Zakat.class);
                    startActivity(i);
                }else if (position == 6){
                    i = new Intent(getApplication(), Zakat.class);//ganti jadwal shalat pake JSON
                    startActivity(i);
                }
            }
        });
    }
}



