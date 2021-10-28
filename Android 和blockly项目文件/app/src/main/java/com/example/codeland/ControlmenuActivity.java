package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;
import com.example.codeland.car.BlocklyControlActivity;
import com.example.codeland.car.DirectionActivity;
import com.example.codeland.car.SpeechActivity;
import com.example.codeland.scratchgame.HubActivity;

public class ControlmenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_blocklymode, iv_voicemode, iv_buttonmode, iv_carmode, iv_leavemode;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlmenu);
        iv_blocklymode = (ImageView) findViewById(R.id.to_blocklymode);
        iv_blocklymode.setOnClickListener(this);
        iv_voicemode = (ImageView) findViewById(R.id.to_voicemode);
        iv_voicemode.setOnClickListener(this);
        iv_buttonmode = (ImageView) findViewById(R.id.to_buttonmode);
        iv_buttonmode.setOnClickListener(this);
        iv_carmode = (ImageView) findViewById(R.id.to_carmode);
        iv_carmode.setOnClickListener(this);
        iv_leavemode = (ImageView) findViewById(R.id.to_leavemode);
        iv_leavemode.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_blocklymode:
                MyApplication.playClickVoice(ControlmenuActivity.this,"button");
                intent = new Intent(ControlmenuActivity.this, BlocklyControlActivity.class);
                startActivity(intent);
                break;
            case R.id.to_voicemode:
                MyApplication.playClickVoice(ControlmenuActivity.this,"button");
                intent = new Intent(ControlmenuActivity.this, SpeechActivity.class);
                startActivity(intent);
                break;
            case R.id.to_buttonmode:
                MyApplication.playClickVoice(ControlmenuActivity.this,"button");
                intent = new Intent(ControlmenuActivity.this, DirectionActivity.class);
//                intent = new Intent(ControlmenuActivity.this, BluetoothClientTest.class);
                startActivity(intent);
                break;
            case R.id.to_carmode:
                MyApplication.playClickVoice(ControlmenuActivity.this,"button");
                intent = new Intent(ControlmenuActivity.this, PoemActivity.class);
                startActivity(intent);
                break;
            case R.id.to_leavemode:
                MyApplication.playClickVoice(ControlmenuActivity.this,"button");
                onBackPressed();
            case R.id.button_back_main:
                MyApplication.playClickVoice(ControlmenuActivity.this,"button");
                onBackPressed();
        }
    }
}