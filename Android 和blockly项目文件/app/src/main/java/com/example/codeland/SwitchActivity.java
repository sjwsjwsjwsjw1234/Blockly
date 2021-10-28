package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;
import com.example.codeland.scratchgame.HubActivity;

public class SwitchActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_javascript, iv_python, iv_php, iv_dart, iv_lua, iv_go;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        iv_javascript = (ImageView) findViewById(R.id.to_javascript);
        iv_javascript.setOnClickListener(this);
        iv_python = (ImageView) findViewById(R.id.to_python);
        iv_python.setOnClickListener(this);
        iv_php = (ImageView) findViewById(R.id.to_php);
        iv_php.setOnClickListener(this);
        iv_dart = (ImageView) findViewById(R.id.to_dart);
        iv_dart.setOnClickListener(this);
        iv_lua = (ImageView) findViewById(R.id.to_lua);
        iv_lua.setOnClickListener(this);
        iv_go = (ImageView) findViewById(R.id.to_go);
        iv_go.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_javascript:
                MyApplication.playClickVoice(SwitchActivity.this,"button");
                intent = new Intent(SwitchActivity.this, JavascriptActivity.class);
                startActivity(intent);
                break;
            case R.id.to_python:
                MyApplication.playClickVoice(SwitchActivity.this,"button");
                intent = new Intent(SwitchActivity.this, PythonActivity.class);
                startActivity(intent);
                break;
            case R.id.to_php:
                MyApplication.playClickVoice(SwitchActivity.this,"button");
                intent = new Intent(SwitchActivity.this, PhpActivity.class);
                startActivity(intent);
                break;
            case R.id.to_dart:
                MyApplication.playClickVoice(SwitchActivity.this,"button");
                intent = new Intent(SwitchActivity.this, DartActivity.class);
                startActivity(intent);
                break;
            case R.id.to_lua:
                MyApplication.playClickVoice(SwitchActivity.this,"button");
                intent = new Intent(SwitchActivity.this, LuaActivity.class);
                startActivity(intent);
                break;
            case R.id.to_go:
                MyApplication.playClickVoice(SwitchActivity.this,"button");
                onBackPressed();
            case R.id.button_back_main:
                MyApplication.playClickVoice(SwitchActivity.this,"button");
                onBackPressed();
        }
    }
}