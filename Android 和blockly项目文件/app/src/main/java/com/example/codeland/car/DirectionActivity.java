package com.example.codeland.car;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.codeland.R;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;


/**
 * 上下左右四个方向键
 */

public class DirectionActivity extends AppCompatActivity implements WheelView.WheelClickListener {
    private WheelView wheel;
    private Button btn_back;
    private Button btn_set;

    public byte[] message = new byte[1];
    private int ENABLE_BLUETOOTH=2;
    private BluetoothAdapter bluetoothAdapter;
    BluetoothDevice bluetoothDevice;
    BluetoothSocket bluetoothSocket = null;
    OutputStream outputStream = null;
//    private static final UUID MY_UUID_SECURE=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final UUID MY_UUID_SECURE=UUID.fromString("10001101-0000-1000-8000-00805F9B34FB");
    private String blueAddress="DC:A6:32:81:88:D7";//MAC

    public void bluesend(byte[] message){
        try{
            outputStream = bluetoothSocket.getOutputStream();
            Log.e("send", Arrays.toString(message));
            outputStream.write(message);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"蓝牙还未连接",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
        Toast.makeText(this, "点击右上角设置按钮进行蓝牙连接", Toast.LENGTH_LONG).show();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter==null){
            Toast.makeText(this,"Bluetooth disabled",Toast.LENGTH_LONG).show();
        }
        else if(!bluetoothAdapter.isEnabled())
        {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent,ENABLE_BLUETOOTH);
        }
        wheel = (WheelView) findViewById(R.id.ctrls);
        wheel.setWheelClickListener(this::onWheelClick);
        btn_back = (Button)findViewById(R.id.back_button);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_set = (Button)findViewById(R.id.set_button);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //连接按钮
                try{
                    bluetoothDevice = bluetoothAdapter.getRemoteDevice(blueAddress);
                    bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(MY_UUID_SECURE);
                    Log.e("true","开始连接");
                    bluetoothSocket.connect();
                    Log.e("true","完成连接");
                    Toast.makeText(getApplicationContext(),"蓝牙连接完成",Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"蓝牙连接失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onWheelClick(int type) {
        switch (type) {
            case WheelView.CLICK_BOTTOM_DOWN:
                //下面按钮按下的时候
                String s1="w";
                message= s1.getBytes() ;
                break;
            case WheelView.CLICK_LEFT_DOWN:
                //左边按钮按下的时候
                String s2="a";
                message= s2.getBytes() ;
                break;
            case WheelView.CLICK_RIGHT_DOWN:
                //右边按钮按下的时候
                String s3="d";
                message= s3.getBytes() ;
                break;
            case WheelView.CLICK_TOP_DOWN:
                //上面按钮按下的时候
                String s4="s";
                message= s4.getBytes() ;
                break;
//            case WheelView.CLICK_BOTTOM_UP:
//                //下面按钮按下抬起的时候
//                break;
//            case WheelView.CLICK_LEFT_UP:
//                //左边按钮按下抬起的时候
//                break;
//            case WheelView.CLICK_RIGHT_UP:
//                //右边按钮按下抬起的时候
//                break;
//            case WheelView.CLICK_TOP_UP:
//                //上面按钮按下抬起的时候
//                break;
        }
        bluesend(message);
    }
}