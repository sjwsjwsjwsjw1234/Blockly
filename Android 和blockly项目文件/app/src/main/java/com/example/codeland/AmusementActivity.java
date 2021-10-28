package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.scratchgame.HubActivity;

public class AmusementActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_music, iv_animation, iv_poem;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amusement);
        iv_music = (ImageView) findViewById(R.id.to_music);
        iv_music.setOnClickListener(this);
        iv_animation = (ImageView) findViewById(R.id.to_animation);
        iv_animation.setOnClickListener(this);
        iv_poem = (ImageView) findViewById(R.id.to_poem);
        iv_poem.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_music:
                intent = new Intent(AmusementActivity.this, MusicActivity.class);
                startActivity(intent);
                break;
            case R.id.to_animation:
                intent = new Intent(AmusementActivity.this, HubActivity.class);
                startActivity(intent);
                break;
            case R.id.to_poem:
                intent = new Intent(AmusementActivity.this, PoemActivity.class);
                startActivity(intent);
                break;
            case R.id.button_back_main:
                onBackPressed();
        }
    }
}