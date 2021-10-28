package com.example.codeland.car;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ddz.floatingactionbutton.FloatingActionButton;
import com.example.codeland.R;

/**
 模块选择页面
 */
public class TurtleActivity extends AppCompatActivity {



        private FloatingActionButton btn_1;
        private FloatingActionButton btn_2;
        private FloatingActionButton btn_3;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_turtle);
            btn_1 = (FloatingActionButton)findViewById(R.id.btn_1);
            btn_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TurtleActivity.this,DirectionActivity.class);
                    startActivity(intent);
                }
            });
            btn_2 = (FloatingActionButton)findViewById(R.id.btn_2);
            btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TurtleActivity.this,SpeechActivity.class);
                    startActivity(intent);
                }
            });
            btn_3 = (FloatingActionButton)findViewById(R.id.btn_3);
            btn_3.setOnClickListener(new View.OnClickListener() {
                //Blockly放在这里
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(TurtleActivity.this, BlocklyControlActivity.class);
                    startActivity(intent);
                }
            });
        }

}