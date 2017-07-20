package com.example.devinpradipta.as_sunnah;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.checked;

public class Zakat extends AppCompatActivity {
    Button simpan;
    SharedPreferences zakats;
    EditText harga;
    TextView tampilkan;
    int hargaAkhir1;
    String hargaAkhir;
    String waktu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat);
        simpan = (Button) findViewById(R.id.button22);

        harga = (EditText) findViewById(R.id.editText);
        tampilkan = (TextView) findViewById(R.id.textView17);
        hargaAkhir = harga.getText().toString();
        //hargaAkhir1 = Integer.valueOf(hargaAkhir);

        SharedPreferences simpanZakat = getSharedPreferences("Zakat", Context.MODE_PRIVATE);
        String hehe = simpanZakat.getString("ZKT",hargaAkhir);

        tampilkan.setText("Zakat yang dikeluarkan " + hehe + " / Hari");

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hargaAkhir = harga.getText().toString();

                SharedPreferences simpanZakat = getSharedPreferences("Zakat", Context.MODE_PRIVATE);
                SharedPreferences.Editor edits = simpanZakat.edit();
                edits.putString("ZKT",hargaAkhir);
                edits.apply();

                Toast.makeText(getApplicationContext(),"Data telah tersimpan, pastikan anda mampu dan konsisten untuk melakukannya",Toast.LENGTH_SHORT).show();

            }


        });
    }


}










