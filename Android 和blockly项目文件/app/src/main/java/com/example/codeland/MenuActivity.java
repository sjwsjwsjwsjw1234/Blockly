package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;
import com.example.codeland.scratchgame.HubActivity;
import com.example.codeland.ui.GameBaseActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_teach, iv_control, iv_vision, iv_game;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        iv_teach = (ImageView) findViewById(R.id.to_teach);
        iv_teach.setOnClickListener(this);
        iv_control = (ImageView) findViewById(R.id.to_control);
        iv_control.setOnClickListener(this);
        iv_vision = (ImageView) findViewById(R.id.to_vision);
        iv_vision.setOnClickListener(this);
        iv_game = (ImageView) findViewById(R.id.to_game);
        iv_game.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_teach:
                MyApplication.playClickVoice(MenuActivity.this,"button");
                intent = new Intent(MenuActivity.this, TeachmenuActivity.class);
                startActivity(intent);
                break;
            case R.id.to_control:
                MyApplication.playClickVoice(MenuActivity.this,"button");
                intent = new Intent(MenuActivity.this, ControlmenuActivity.class);
                startActivity(intent);
                break;
            case R.id.to_vision:
                MyApplication.playClickVoice(MenuActivity.this,"button");
                intent = new Intent(MenuActivity.this, VisionmenuActivity.class);
                startActivity(intent);
                break;
            case R.id.to_game:
                MyApplication.playClickVoice(MenuActivity.this,"button");
                intent = new Intent(MenuActivity.this, GamemenuActivity.class);
                startActivity(intent);
                break;
            case R.id.button_back_main:
                MyApplication.playClickVoice(MenuActivity.this,"button");
                onBackPressed();
        }
    }
}