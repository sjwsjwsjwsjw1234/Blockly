package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codeland.ui.CodingBaseActivity_test;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class ForumActivity extends AppCompatActivity {
    private TextView                 btn_rg;
    private Button                btn_ok;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context otherAppContext;
    private SharedPreferences sprfMain;
    private Button button_back;
    SharedPreferences.Editor editorMain;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        //Bmob.resetDomain("http://codeland.waityousell.com/8/");
        Bmob.initialize(this, "00fbe513d7a008bf4d6b48fdf60235dd");
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        btn_rg = (TextView) findViewById(R.id.id_register);
        btn_ok = (Button) findViewById(R.id.id_ok);
        button_back = (Button) findViewById(R.id.button_back1);
        final EditText lgUser = findViewById(R.id.id_username);
        final EditText lgPassword = findViewById(R.id.id_userpassword);
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            String account = pref.getString("account", "");
            String password = pref.getString("password","");
            lgUser.setText(account);
            lgPassword.setText(password);
        }
        btn_rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lgU = lgUser.getText().toString().trim();
                String lgp = lgPassword.getText().toString().trim();
                final BmobUser bu2 = new BmobUser();
                bu2.setUsername(lgU);
                bu2.setPassword(lgp);
                bu2.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            Toast.makeText(ForumActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                            editor = pref.edit();
                            editor.putBoolean("remember_password", true);
                            editor.putString("account", lgU);
                            editor.putString("password", lgp);
                            editor.commit();
                            onBackPressed();

                        } else {
                            Toast.makeText(ForumActivity.this, "账户名或密码不正确", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}