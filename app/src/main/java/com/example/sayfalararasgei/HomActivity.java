package com.example.sayfalararasgei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class HomActivity extends AppCompatActivity {

    private TextView txtKullanici;
    private String gelenKAdi,gelenKSifre;
    private Switch music;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hom);

        txtKullanici=(TextView) findViewById(R.id.textViewUser);
        music= (Switch) findViewById(R.id.switchMusic);
        mediaPlayer = (MediaPlayer.create(getApplicationContext(),R.raw.m1));

        Intent gelenIntent = getIntent();
        gelenKAdi = gelenIntent.getStringExtra("kullaniciAdi");
        txtKullanici.setText("Hoşgeldiniz " + gelenKAdi);

        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mediaPlayer.start();
                }else {
                    mediaPlayer.pause();
                }
            }
        });
    }
}