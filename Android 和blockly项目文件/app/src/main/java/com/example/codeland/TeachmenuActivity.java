package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;
import com.example.codeland.scratchgame.HubActivity;

public class TeachmenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_program, iv_programvid, iv_change, iv_changevid, iv_search, iv_searchvid;
    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachmenu);
        iv_program = (ImageView) findViewById(R.id.to_program);
        iv_program.setOnClickListener(this);
        iv_programvid = (ImageView) findViewById(R.id.to_programvid);
        iv_programvid.setOnClickListener(this);
        iv_change = (ImageView) findViewById(R.id.to_change);
        iv_change.setOnClickListener(this);
        iv_changevid = (ImageView) findViewById(R.id.to_changevid);
        iv_changevid.setOnClickListener(this);
        iv_search = (ImageView) findViewById(R.id.to_search);
        iv_search.setOnClickListener(this);
        iv_searchvid = (ImageView) findViewById(R.id.to_searchvid);
        iv_searchvid.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_program:
                MyApplication.playClickVoice(TeachmenuActivity.this,"button");
                intent = new Intent(TeachmenuActivity.this, CodeteachActivity.class);
                startActivity(intent);
                break;
            case R.id.to_programvid:
                MyApplication.playClickVoice(TeachmenuActivity.this,"button");
                intent = new Intent(TeachmenuActivity.this, ProgramvidActivity.class);
                startActivity(intent);
                break;
            case R.id.to_change:
                MyApplication.playClickVoice(TeachmenuActivity.this,"button");
                intent = new Intent(TeachmenuActivity.this, SwitchActivity.class);
                startActivity(intent);
                break;
            case R.id.to_changevid:
                MyApplication.playClickVoice(TeachmenuActivity.this,"button");
                intent = new Intent(TeachmenuActivity.this, ChangevidActivity.class);
                startActivity(intent);
                break;
            case R.id.to_search:
                MyApplication.playClickVoice(TeachmenuActivity.this,"button");
                intent = new Intent(TeachmenuActivity.this, TansuoActivity.class);
                startActivity(intent);
                break;
            case R.id.to_searchvid:
                MyApplication.playClickVoice(TeachmenuActivity.this,"button");
                intent = new Intent(TeachmenuActivity.this, SearchvidActivity.class);
                startActivity(intent);
                break;
            case R.id.button_back_main:
                MyApplication.playClickVoice(TeachmenuActivity.this,"button");
                onBackPressed();
        }
    }
}