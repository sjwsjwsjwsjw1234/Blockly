package com.example.codeland.car;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.codeland.R;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;

public class BlocklyControlActivity extends AppCompatActivity {

//    private Button btnConnect;
//    private Button btnTurnLeft;

    class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

//        /** Show a toast from the web page */
//        @JavascriptInterface
//        public void showToast(String toast) {
//            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
//        }
//
        @JavascriptInterface
        public void blueConnect() {
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
//
//        @JavascriptInterface
//        public void turnLeft() {
//            message[0]= (byte) 0x32;
//            bluesend(message);
//
//        }

        @JavascriptInterface
        public void control_car(String orderList) {
            deDuplication++;
            if (deDuplication%2 == 0) { return; }
            //Toast.makeText(getApplicationContext(), orderList, Toast.LENGTH_SHORT).show();
            //String[] orders = new String[orderList.length()/2];
            for (int i = 0; i < orderList.length()/2; i++) {
                String order = orderList.substring(2*i, 2*i+2);
                bluesend(order);
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static int deDuplication = 0;

    //bluetooth
    public byte[] message = new byte[1];
    private int ENABLE_BLUETOOTH=2;
    BluetoothAdapter bluetoothAdapter;
    BluetoothDevice bluetoothDevice;
    BluetoothSocket bluetoothSocket = null;
    OutputStream outputStream = null;
//    private static final UUID MY_UUID_SECURE=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final UUID MY_UUID_SECURE=UUID.fromString("10001101-0000-1000-8000-00805F9B34FB");

//    private String blueAddress="AB:8C:2E:57:34:02";//MAC
    private String blueAddress="DC:A6:32:81:88:D7";//MAC

    public void bluesend(String message){
        try{
            outputStream = bluetoothSocket.getOutputStream();
            Log.e("send", message);
            byte [] temp=message.getBytes();
            for (int i=0;i<temp.length;i++)
            {
                outputStream.write(temp[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"蓝牙还未连接",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blockly_control);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter==null){
            Toast.makeText(this,"Bluetooth disabled",Toast.LENGTH_LONG).show();
        }
        else if(!bluetoothAdapter.isEnabled())
        {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent,ENABLE_BLUETOOTH);
        }
        //连接
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

        WebView mWebView = (WebView)findViewById(R.id.blockly_control_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        mWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        mWebView.loadUrl("file:///android_asset/car1/index.html");
//        btnConnect = (Button) findViewById(R.id.btn_connect);
//        btnConnect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //连接按钮
//                try{
//                    bluetoothDevice = bluetoothAdapter.getRemoteDevice(blueAddress);
//                    bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(MY_UUID_SECURE);
//                    Log.e("true","开始连接");
//                    bluetoothSocket.connect();
//                    Log.e("true","完成连接");
//                    Toast.makeText(getApplicationContext(),"蓝牙连接完成",Toast.LENGTH_LONG).show();
//                }catch (IOException e){
//                    e.printStackTrace();
//                    Toast.makeText(getApplicationContext(),"蓝牙连接失败",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        btnTurnLeft = (Button) findViewById(R.id.btn_turn_left);
//        btnTurnLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                message[0]= (byte) 0x32;
//                bluesend(message);
//            }
//        });

    }
}