package com.example.sayfalararasgei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText kullaniciAdi, sifre;
    private TextView txtSonuc;
    private String dogruKullanici = "sena1bayram", dogruSifre = "sena", kAdi, kSifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullaniciAdi = (EditText) findViewById(R.id.editTxtKullaniciAd);
        sifre = (EditText) findViewById(R.id.editTxtKullaniciSifre);
        txtSonuc = (TextView) findViewById(R.id.txtViewSonuc);
    }

    public void btnClick(View v) {
        kAdi = kullaniciAdi.getText().toString();
        kSifre = sifre.getText().toString();

        if (!TextUtils.isEmpty(kAdi)) {
            if (!TextUtils.isEmpty(kSifre)) {
                if (kAdi.equals(dogruKullanici)) {
                    if (kSifre.equals(dogruSifre)) {
                        //geçiş yap
                        Intent intent = new Intent(MainActivity.this, HomActivity.class);
                        intent.putExtra("kullaniciAdi",kAdi);
                        startActivity(intent);
                    } else {
                        txtSonuc.setText("Şifrenizi Yanlış Girdiniz");
                    }
                } else {
                    txtSonuc.setText("Kullanıcı Adınızı Yanlış Girdiniz");
                }
            } else {
                txtSonuc.setText("Şifre Boş Girilemez");
            }
        } else {
            txtSonuc.setText("Kullanıcı Boş Girilemez");
        }
    }
}