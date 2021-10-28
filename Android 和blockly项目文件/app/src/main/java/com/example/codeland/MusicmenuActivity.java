package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;

public class MusicmenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_song1, iv_song2;
    private Button button_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicmenu);
        iv_song1 = (ImageView) findViewById(R.id.to_song1);
        iv_song1.setOnClickListener(this);
        iv_song2 = (ImageView) findViewById(R.id.to_song2);
        iv_song2.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_song1:
                MyApplication.playClickVoice(MusicmenuActivity.this,"button");
                intent = new Intent(MusicmenuActivity.this, MusicActivity.class);
                startActivity(intent);
                break;
            case R.id.to_song2:
                MyApplication.playClickVoice(MusicmenuActivity.this,"button");
                intent = new Intent(MusicmenuActivity.this, MyMusicActivity.class);
                startActivity(intent);
                break;
            case R.id.button_back_main:
                MyApplication.playClickVoice(MusicmenuActivity.this,"button");
                onBackPressed();
        }
    }
}