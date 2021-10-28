package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;
import com.example.codeland.scratchgame.HubActivity;

public class VisionmenuActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_know, iv_knowvid, iv_chase, iv_chasevid, iv_avoid, iv_avoidvid;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visionmenu);
        iv_know = (ImageView) findViewById(R.id.to_know);
        iv_know.setOnClickListener(this);
        iv_knowvid = (ImageView) findViewById(R.id.to_knowvid);
        iv_knowvid.setOnClickListener(this);
        iv_chase = (ImageView) findViewById(R.id.to_chase);
        iv_chase.setOnClickListener(this);
        iv_chasevid= (ImageView) findViewById(R.id.to_chasevid);
        iv_chasevid.setOnClickListener(this);
        iv_avoid = (ImageView) findViewById(R.id.to_avoid);
        iv_avoid.setOnClickListener(this);
        iv_avoidvid = (ImageView) findViewById(R.id.to_avoidvid);
        iv_avoidvid.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_know:
                MyApplication.playClickVoice(VisionmenuActivity.this,"button");
                intent = new Intent(VisionmenuActivity.this, ClassifierActivity.class);
                startActivity(intent);
                break;
            case R.id.to_knowvid:
                MyApplication.playClickVoice(VisionmenuActivity.this,"button");
                intent = new Intent(VisionmenuActivity.this, HubActivity.class);
                startActivity(intent);
                break;
            case R.id.to_chase:
                MyApplication.playClickVoice(VisionmenuActivity.this,"button");
                intent = new Intent(VisionmenuActivity.this, PoemActivity.class);
                startActivity(intent);
                break;
            case R.id.to_chasevid:
                MyApplication.playClickVoice(VisionmenuActivity.this,"button");
                intent = new Intent(VisionmenuActivity.this, PoemActivity.class);
                startActivity(intent);
                break;
            case R.id.to_avoid:
                MyApplication.playClickVoice(VisionmenuActivity.this,"button");
                intent = new Intent(VisionmenuActivity.this, PoemActivity.class);
                startActivity(intent);
                break;
            case R.id.to_avoidvid:
                MyApplication.playClickVoice(VisionmenuActivity.this,"button");
                intent = new Intent(VisionmenuActivity.this, PoemActivity.class);
                startActivity(intent);
                break;
            case R.id.button_back_main:
                MyApplication.playClickVoice(VisionmenuActivity.this,"button");
                onBackPressed();
        }
    }
}