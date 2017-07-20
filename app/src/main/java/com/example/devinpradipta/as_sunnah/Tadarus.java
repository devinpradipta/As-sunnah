package com.example.devinpradipta.as_sunnah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tadarus extends AppCompatActivity {
    Button tadarus,kurang,tambah,simpan;
    Intent masuk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tadarus);
        tadarus = (Button) findViewById(R.id.button9);
        kurang = (Button) findViewById(R.id.button9);
        tambah = (Button) findViewById(R.id.button9);
        simpan = (Button) findViewById(R.id.button9);
        tadarus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masuk = new Intent(getApplicationContext(),Masuk_progress.class);
                startActivity(masuk);
            }
        });
    }
}
