package com.example.devinpradipta.as_sunnah;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notifikasi extends AppCompatActivity {
    Button notifikasi;
    Intent masuk;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);
        notifikasi = (Button) findViewById(R.id.button27);

        notifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktifkanNotifikasi();
            }
        });
    }

   private void aktifkanNotifikasi(){
        NotificationCompat.Builder nBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setContentTitle("As-sunnah notification")
                .setContentText("Jangan lupa lakukan ibadah sunnah anda");

       Intent notificationIntent = new Intent(this, Masuk_progress.class);


       // Add as notification
       NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
       manager.notify(0, nBuilder.build());
    }
    

}
