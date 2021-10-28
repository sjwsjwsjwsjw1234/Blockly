package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.codeland.app.MyApplication;
import com.example.codeland.scratchgame.HubActivity;

public class GamemenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_song, iv_universe, iv_rubbish, iv_intelligence;
    private Button button_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemenu);
        iv_song = (ImageView) findViewById(R.id.to_song);
        iv_song.setOnClickListener(this);
        iv_universe = (ImageView) findViewById(R.id.to_universe);
        iv_universe.setOnClickListener(this);
        iv_rubbish = (ImageView) findViewById(R.id.to_rubbish);
        iv_rubbish.setOnClickListener(this);
        iv_intelligence = (ImageView) findViewById(R.id.to_intelligence);
        iv_intelligence.setOnClickListener(this);
        button_back=findViewById(R.id.button_back_main);
        button_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.to_song:
                MyApplication.playClickVoice(GamemenuActivity.this,"button");
                intent = new Intent(GamemenuActivity.this, MusicmenuActivity.class);
                startActivity(intent);
                break;
            case R.id.to_universe:
                MyApplication.playClickVoice(GamemenuActivity.this,"button");
                intent = new Intent(GamemenuActivity.this, ExploreActivity.class);
                startActivity(intent);
                break;
            case R.id.to_rubbish:
                MyApplication.playClickVoice(GamemenuActivity.this,"button");
                intent = new Intent(GamemenuActivity.this, SortActivity.class);
                startActivity(intent);
                break;
            case R.id.to_intelligence:
                MyApplication.playClickVoice(GamemenuActivity.this,"button");
                intent = new Intent(GamemenuActivity.this, QuestionActivity.class);
                startActivity(intent);
                break;
            case R.id.button_back_main:
                MyApplication.playClickVoice(GamemenuActivity.this,"button");
                onBackPressed();
        }
    }
}