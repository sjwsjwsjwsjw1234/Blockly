package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;

public class CodeteachActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_maxt, iv_logop, iv_lition,iv_go;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codeteach);
        iv_maxt = (ImageView) findViewById(R.id.to_maxt);
        iv_maxt.setOnClickListener(this);
        iv_logop = (ImageView) findViewById(R.id.to_logop);
        iv_logop.setOnClickListener(this);
        iv_lition = (ImageView) findViewById(R.id.to_lition);
        iv_lition.setOnClickListener(this);
        iv_go = (ImageView) findViewById(R.id.to_go);
        iv_go.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_maxt:
                MyApplication.playClickVoice(CodeteachActivity.this,"button");
                intent = new Intent(CodeteachActivity.this, MaxtActivity.class);
                startActivity(intent);
                break;
            case R.id.to_logop:
                MyApplication.playClickVoice(CodeteachActivity.this,"button");
                intent = new Intent(CodeteachActivity.this, LogopActivity.class);
                startActivity(intent);
                break;
            case R.id.to_lition:
                MyApplication.playClickVoice(CodeteachActivity.this,"button");
                intent = new Intent(CodeteachActivity.this, LitionActivity.class);
                startActivity(intent);
                break;
            case R.id.to_go:
                MyApplication.playClickVoice(CodeteachActivity.this,"button");
                onBackPressed();
            case R.id.button_back_main:
                MyApplication.playClickVoice(CodeteachActivity.this,"button");
                onBackPressed();
        }
    }
}