package com.example.absen_kelas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard_siswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_siswa);
    }

    public void absensi(View view) {
        Intent i = new Intent(dashboard_siswa.this,absen.class);
        startActivity(i);
    }
}