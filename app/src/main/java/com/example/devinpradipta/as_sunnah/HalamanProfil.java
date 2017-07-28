package com.example.devinpradipta.as_sunnah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanProfil extends AppCompatActivity {
    Button enters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_profil);
        enters = (Button) findViewById(R.id.button29);

        enters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Penjelasan.class);
                startActivity(i);
            }
        });
    }
}
