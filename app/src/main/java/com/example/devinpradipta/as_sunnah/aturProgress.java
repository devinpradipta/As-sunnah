package com.example.devinpradipta.as_sunnah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aturProgress extends AppCompatActivity {
    Button masuk;
    Intent masuks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atur_progress);
        masuk = (Button)findViewById(R.id.Masuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masuks = new Intent(getApplicationContext(),Penjelasan.class);
                startActivity(masuks);
            }
        });
    }
}
