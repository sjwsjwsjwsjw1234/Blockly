package com.example.codeland;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.codeland.app.MyApplication;
import com.example.codeland.scratchgame.HubActivity;
import com.example.codeland.ui.GameBaseActivity;
import com.example.codeland.util.AppLanguageUtils;
import com.qw.curtain.lib.Curtain;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    private MyButton ivEnghten;
    private MyButton   ivCoding,buttonSet,buttonMusic,/*buttonHelp,*/ivCar,ivAi, ivAmusement,ivBook,ivStart,ivForum;

    private MediaPlayer mediaPlayer;
    private ParallelViewHelper parallelViewHelper;
    private AudioManager audioManager;
//    private ImageView imageView_main_logo;

    private boolean isVisible = true;
    public boolean music = true;

    private Thread thread;

    private ImageView imageView_main_background;

    /** Run-time Permissions 申请权限用到的一些常量 */
    private final int SCRATCHJR_CAMERA_MIC_PERMISSION = 1;
    public int cameraPermissionResult = PackageManager.PERMISSION_DENIED;
    public int micPermissionResult = PackageManager.PERMISSION_DENIED;

    //从ScratchJrActivity里面借过来的申请权限的方法，用来提前申请权限，避免进入home.html再申请权限时会导致没有权限，第一次加载失败
    public void requestPermissions() {
        cameraPermissionResult = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        micPermissionResult = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);

        String[] desiredPermissions;
        if (cameraPermissionResult != PackageManager.PERMISSION_GRANTED
                && micPermissionResult != PackageManager.PERMISSION_GRANTED) {
            desiredPermissions = new String[]{
                    Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO
            };
        } else if (cameraPermissionResult != PackageManager.PERMISSION_GRANTED) {
            desiredPermissions = new String[]{Manifest.permission.CAMERA};
        } else if (micPermissionResult != PackageManager.PERMISSION_GRANTED) {
            desiredPermissions = new String[]{Manifest.permission.RECORD_AUDIO};
        } else {
            return;
        }

        ActivityCompat.requestPermissions(this,
                desiredPermissions,
                SCRATCHJR_CAMERA_MIC_PERMISSION);
    }

    //从ScratchJrActivity里面借过来的申请权限的方法，用来提前申请权限，避免进入home.html再申请权限时会导致没有权限，第一次加载失败
    @Override
    public void onRequestPermissionsResult(int requestCode,  String permissions[], int[] grantResults) {
        if (requestCode == SCRATCHJR_CAMERA_MIC_PERMISSION) {
            int permissionId = 0;
            for (String permission : permissions) {
                if (permission.equals(Manifest.permission.CAMERA)) {
                    cameraPermissionResult = grantResults[permissionId];
                }
                if (permission.equals(Manifest.permission.RECORD_AUDIO)) {
                    micPermissionResult = grantResults[permissionId];
                }
                permissionId++;
            }
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //changeAppLanguage(getResources(),MyApplication.languageFlag);
       // Bmob.initialize(this, "6c3577912b5551e2a32ab52941919eda");
        setContentView(R.layout.activity_main);

        MyApplication.disableAPIDialog();

        //适配屏幕引入语句
        ScreenAdapterTools.getInstance().loadView((ViewGroup) getWindow().getDecorView());

        //申请 相机+录音权限
        requestPermissions();


//        ivCoding = findViewById(R.id.main_iv_coding);
//        ivAi = findViewById(R.id.main_iv_ai);
//        ivCar=findViewById(R.id.main_iv_car);
//        ivAmusement = findViewById(R.id.main_iv_amusement);
        buttonSet=findViewById(R.id.button_set);
        buttonMusic=findViewById(R.id.button_music);
        imageView_main_background=findViewById(R.id.main_background);
//        ivAmusement.setOnClickListener(this);
//        ivCoding.setOnClickListener(this);
//        ivAi.setOnClickListener(this);
//        ivCar.setOnClickListener(this);
        buttonSet.setOnClickListener(this);
        buttonMusic.setOnClickListener(this);
        ivBook= findViewById(R.id.main_iv_book);
        ivStart = findViewById(R.id.main_iv_start);
        ivForum = findViewById(R.id.main_iv_forum);
        ivBook.setOnClickListener(this);
        ivStart.setOnClickListener(this);
        ivForum.setOnClickListener(this);

        //视差动画 实例化
        parallelViewHelper = new ParallelViewHelper(this, findViewById(R.id.main_background),20,0 );

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //每次刚打开APP，正确初始化 语言按钮对应的图片+文字
        if(MyApplication.languageFlag==1){
//            ivEnghten.setText("动画");
            //     ivGame.setText("游戏");
            ivBook.setText("用户手册");
            ivStart.setText("进入触感编程");
//            ivAi.setText("识物英语");
//            ivGit.setText("论坛");
            ivForum.setText("发现更多");
//            imageView_main_logo.setImageResource(R.mipmap.activity_main_logo2_chinese);
//            ivEnghten.setVisibility(View.VISIBLE);
        }
        else{
//            ivEnghten.setText("Initiation");
            //        ivGame.setText("Games");
            ivBook.setText("Handbook");
            ivStart.setText("Start");
            ivForum.setText("Forum");
//            ivGit.setText("Git");
//            ivCar.setText("Car");
//            imageView_main_logo.setImageResource(R.mipmap.activity_main_logo2_english);
//            ivEnghten.setVisibility(View.GONE);
        }



        //是否第一次打开APP，是则运行，否则不在此运行
        if(MyApplication.isFirstRun("MainActivityNewbieGuide"))
        {
            MainActivityNewbieGuide();
        }
    }

    //每个存在语言切换的Activity需要写
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(AppLanguageUtils.attachBaseContext(newBase));
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
//            case R.id.main_iv_amusement:
//                intent=new Intent(this, AmusementActivity.class);
//                intent.putExtra("part",2);
//                startActivity(intent);
//                break;
//            case R.id.main_iv_ai:
//                intent=new Intent(this, ClassifierActivity.class);
//                intent.putExtra("part",3);
//                startActivity(intent);
//                break;
//            case R.id.main_iv_coding:
//                intent=new Intent(this,ProgramActivity.class);
//                intent.putExtra("part",4);
//                startActivity(intent);
//                break;
//            case R.id.main_iv_car:
//                intent=new Intent(this, GameBaseActivity.class);
//                intent.putExtra("part",6);
//                startActivity(intent);
//                break;
            case R.id.main_iv_book:
                intent=new Intent(this, AmusementActivity.class);
                intent.putExtra("part",2);
                startActivity(intent);
                break;
            case R.id.main_iv_start:
                intent=new Intent(this, MenuActivity.class);
                intent.putExtra("part",3);
                startActivity(intent);
                break;
            case R.id.main_iv_forum:
                intent=new Intent(this,ProgramActivity.class);
                intent.putExtra("part",4);
                startActivity(intent);
                break;
            case R.id.button_set:
                if(buttonMusic.getVisibility()==View.INVISIBLE)
                {
                    buttonMusic.setVisibility(View.VISIBLE);
                }
                else {
                    buttonMusic.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.button_music:
                if(MyApplication.isPlaying){
                    buttonMusic.setBackgroundResource(R.mipmap.music_off);
                    mediaPlayer.setVolume(0f,0f);
                    MyApplication.playClickVoice(MyApplication.getContext(),"setVoice");
                    MyApplication.isPlaying=false;
                }else{
                    buttonMusic.setBackgroundResource(R.mipmap.music_on);
                    mediaPlayer.setVolume(1,1);
                    mediaPlayer.start();
                    MyApplication.isPlaying=true;
                }

                break;
//            case R.id.button_help:
//                MainActivityNewbieGuide();
//                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_VOLUME_MUTE:
                //buttonMusic.setBackgroundResource(R.mipmap.music_off);
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                //buttonMusic.setBackgroundResource(R.mipmap.music_on);
                MyApplication.voiceMax= audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
                MyApplication.voiceCurrent= audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                MyApplication.voiceMax= audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
                MyApplication.voiceCurrent= audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        //videoView.suspend();
        super.onDestroy();
    }

    /**
     * 友盟Session启动、App使用时长等基础数据统计接口API
     * 在App中每个Activity的
     * onResume方法中调用 MobclickAgent.onResume(context)
     * onPause方法中调用 MobclickAgent.onPause(context)
     *
     * 确保在所有的Activity中都调用 MobclickAgent.onResume() 和onPause()方法
     * 这两个调用不会阻塞应用程序的主线程，也不会影响应用程序的性能。
     *
     * 注意：如果您的Activity之间有继承或者控制关系，请不要同时在父和子Activity中
     * 重复添加onPause和onResume方法，否则会造成重复统计，导致启动次数异常增高。
     * (例如：使用TabHost、TabActivity、ActivityGroup时)。
     */

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();



//        mediaPlayer.pause();
        mediaPlayer.release();
        parallelViewHelper.stop();
    }

    //首次创建该活动+onPause该活动后再次onRestart该活动，都开始播放音乐
    @Override
    protected void onStart() {

        playBGSound();
        parallelViewHelper.start();

        thread=new Thread(new Runnable(){
            @Override
            public void run() {
                playBGSound();//播放背景音乐
            }
        });
        thread.start();//开启线程
        super.onStart();
    }

    private void playBGSound() {
        if (mediaPlayer!= null) {
            mediaPlayer.release();//释放资源
        }
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.login_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Log.e("MediaPlayer","Error");
                return false;
            }
        });
        if(!MyApplication.isPlaying)
        {
            mediaPlayer.setVolume(0f,0f);
        }
        else{
            mediaPlayer.setVolume(1,1 );
        }
        if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            Log.e("mediaplayer:","start");
        }
    }

    @Override
    protected void onRestart() {

        super.onRestart();
    }

    public void MainActivityNewbieGuide(){

        //从透明到不透明，不透明到透明的动画定义
        Animation enterAnimation = new AlphaAnimation(0f, 1f);
        enterAnimation.setDuration(600);
        enterAnimation.setFillAfter(true);

        Animation exitAnimation = new AlphaAnimation(1f, 0f);
        exitAnimation.setDuration(600);
        exitAnimation.setFillAfter(true);
        showCurtain();


    }
//由于自适应屏幕的问题，高亮所在地方出现问题，以后修改
    private void showCurtain() {
        new Curtain(MainActivity.this)
//                .with(findViewById(R.id.main_iv_ai))
//                .with(findViewById(R.id.main_iv_car))
//                .with(findViewById(R.id.main_iv_coding))
//                .with(findViewById(R.id.main_iv_amusement))
                .with(findViewById(R.id.main_iv_book))
                .with(findViewById(R.id.main_iv_start))
                .with(findViewById(R.id.main_iv_forum))
                .show();
    }

}
