package com.example.codeland.ui;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.codeland.ContentActivity;
import com.example.codeland.ForumActivity;
import com.example.codeland.R;
import com.example.codeland.adapter.CodingAdapter;
import com.example.codeland.bmob.CodingPlace;
import com.example.codeland.bmob.Content;
import com.example.codeland.bmob.Person;
import com.example.codeland.entity.Coding;
import com.example.codeland.entity.LevelInfo;
import com.example.codeland.util.InputDialog;
import com.example.codeland.util.Util;
import com.google.android.material.snackbar.Snackbar;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class CodingBaseActivity_test extends AppCompatActivity {
    private boolean isload;
    private WebView webView;
    private Button button;
    private Button button1;
    private Button load;
    private Button clear;
    private Button reName;
    private Button answer;
    private Button quit;
    private TextView resultText;
    private TextView recordText;
    private String workspaceLoadPath;
    private SharedPreferences sprfMain;

    private SharedPreferences.Editor editorMain;

    //zhl??????
    private Button back;

    private Button recordback;

    private int clickedChapter;//????????????????????????????????????

    private int clickedLevel;       //???????????????
    private int maxLevel;           //???????????????
    private int rating = 0;//????????????
    private static int a = 0;
    private static int b = 0;
    private static int spaceNum = 1;
    private ListView listView;
    private LinearLayout recordLayout;
    private CodingAdapter adapter;
    private List<CodingPlace> savingRecordList = new ArrayList<>();


    //???????????????????????????scratchGameSingleUse????????????????????? ????????????????????????????????????????????????????????????
    String singUseFlag;
    //????????????????????????????????????
    String model;


    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //??????????????????????????????

            if (msg.what == 1) {
                //???????????????????????????
                //konfettiView.setVisibility(View.GONE);
                //  Toast.makeText(CodingBaseActivity_test.this,"??????????????????????????????????????????",Toast.LENGTH_LONG).show();
                finish();


                Log.e("CodingBaseActivity_test", "what1");

            }
//            //????????????????????????
            else if (msg.what == 2) {
                //?????????????????????????????????????????????
                //???????????????????????????
                //konfettiView.setVisibility(View.GONE);

            }
            //?????????????????????3?????????????????? ????????? ??????
            else if (msg.what == 3) {
                //???????????????????????????
                //konfettiView.setVisibility(View.GONE);
                if (clickedLevel < maxLevel) {
                    //??????????????????????????????????????????
                    SharedPreferences.Editor editor = getSharedPreferences("AllLevel", MODE_PRIVATE).edit();
                    clickedLevel++;
                    editor.putInt("clickedLevel", clickedLevel);
                    editor.commit();
                } else {
                    finish();
                }


            }


            SharedPreferences sharedPreferences = getSharedPreferences("AllLevel", MODE_PRIVATE);
            int chapterUnlockLevel = sharedPreferences.getInt(model + "_UnlockLevel", 0);


            List<LevelInfo> rates = LitePal.where("name = ?", model + " " + clickedLevel).find(LevelInfo.class);
            if (rates.isEmpty()) {
                LevelInfo rate = new LevelInfo();
                rate.setName(model + " " + clickedLevel);
                rate.setModel(model);
                rate.setRating(rating);
                rate.save();
            } else {
                int oldRating = rates.get(0).getRating();
                if (rating > oldRating) {
                    LevelInfo rate = new LevelInfo();
                    rate.setRating(rating);
                    rate.updateAll("name = ?", model + " " + clickedLevel);
                }
            }

            //??????  ?????????????????? ?????? ??????????????????>=????????????????????????????????? ???????????????????????????????????????+1
            if (clickedLevel >= chapterUnlockLevel && rating == 3) {
                SharedPreferences.Editor editor = getSharedPreferences("AllLevel", MODE_PRIVATE).edit();
                editor.putInt(model + "_UnlockLevel", clickedLevel + 1);
                editor.commit();
            }


            rating = 0;
            //??????rating???0

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coding_base_test);
        Bmob.initialize(this, "00fbe513d7a008bf4d6b48fdf60235dd");
        sprfMain= PreferenceManager.getDefaultSharedPreferences(this);

        editorMain=sprfMain.edit();
        //pjh ????????????????????? ?????? coding_+
        final Intent intent = getIntent();
        singUseFlag = intent.getStringExtra("scratchGameSingleUse");
        model = intent.getStringExtra("model");

        initClickedChapter();

        webView = findViewById(R.id.code_test);


        Log.e("CodingBaseActivity_test", model);
        //???????????????
        button = findViewById(R.id.coding_test1);
        recordText = findViewById(R.id.record_text);
        load = findViewById(R.id.button_load);
        clear = findViewById(R.id.button_clear);
        reName = findViewById(R.id.button_rename);
        //???????????????
        button1 = findViewById(R.id.coding_test_ss);
        resultText = findViewById(R.id.mResultText);
        recordLayout = findViewById(R.id.record_layout1);
        listView = findViewById(R.id.record_list_1);
        answer = findViewById(R.id.button_help_coding);
        back = findViewById(R.id.button_back_coding);
        resultText.setMovementMethod(ScrollingMovementMethod.getInstance());

        recordback = findViewById(R.id.button_cancel);

        quit = findViewById(R.id.quit);
        //????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        if (model.equals("coding_printf") || model.equals("coding_math") || model.equals("coding_variable") || model.equals("coding_logic") || model.equals("coding_loop") || model.equals("coding_array") || model.equals("coding_function")) {
            answer.setVisibility(View.VISIBLE);
        }


        WebSettings webSettings = webView.getSettings();
        // ?????????Js???????????????
        webSettings.setJavaScriptEnabled(true);
        // ????????????JS??????
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //Log.e("coding_model",model);
        webView.loadUrl("file:///android_asset/blockly-master/demos/code/index.html?model=" + model);
        //initRecord();
        //adapter = new CodingAdapter(CodingBaseActivity_test.this, R.layout.record_item, savingRecordList);
        listView.setAdapter(adapter);
        //?????????SharedPreferences?????????????????????
        SharedPreferences mySharedPreferences = getSharedPreferences("test",
                Activity.MODE_PRIVATE);
//?????????SharedPreferences.Editor?????????????????????
        final SharedPreferences.Editor editor = mySharedPreferences.edit();
        SharedPreferences levelSharedPreferences = getSharedPreferences("AllLevel", MODE_PRIVATE);
        clickedLevel = levelSharedPreferences.getInt("clickedLevel", 1);
        maxLevel = levelSharedPreferences.getInt(model + "_MaxLevel", 1);
        Util.showModule3TipDialog(CodingBaseActivity_test.this, clickedChapter, clickedLevel, handler);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.showModule3TipDialog(CodingBaseActivity_test.this, clickedChapter, clickedLevel, handler);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, final String message, final JsResult result) {

                //??????onJsAlert()????????????????????????????????????,????????????????????????
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resultText.append(message + "\n");
                        Toast.makeText(getApplicationContext(), message+"\n", Toast.LENGTH_LONG);
                    }
                }, 100);//0.1????????????Runnable??????run??????
                //Toast.makeText(CodingBaseActivity_test.this, message, Toast.LENGTH_SHORT).show();
                result.confirm();
                //Log.e("message:",message);
                //confirm()?????????????????????webview?????????????????????????????????????????????
                return true;
                //return super.onJsAlert(view,url,message,result);
            }

        });
// ??????WebViewClient??????shouldOverrideUrlLoading??????
        //??????web??????android?????????
        webView.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {

                                         // ??????2??????????????????????????????????????????????????????url
                                         // ????????????scheme?????????????????? & authority??????????????????????????????????????????
                                         //????????????????????? url = "js://webview?arg1=111&arg2=222"?????????????????????????????????????????????

                                         Uri uri = Uri.parse(url);
                                         // ??????url????????? = ??????????????? js ??????
                                         // ???????????????????????????
                                         if (uri.getScheme().equals("js")) {

                                             // ?????? authority  = ???????????????????????? webview????????????????????????????????????
                                             // ????????????url,??????JS????????????Android???????????????
                                             if (uri.getAuthority().equals("webview")) {

                                                 //  ??????3???
                                                 // ??????JS????????????????????????
                                                 //??????????????????????????????????????????
                                                 resultText.setText("");
                                                 a = 1;
                                                 JudgeBlock();
                                                 // ??????????????????????????????????????????Android???
                                                 //?????????????????????
                                                 HashMap<String, String> params = new HashMap<>();
                                                 Set<String> collection = uri.getQueryParameterNames();

                                             }

                                             return true;
                                         }
                                         return super.shouldOverrideUrlLoading(view, url);
                                     }
                                 }
        );
        //????????????;
        button.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override

            public void onClick(View v) {
                // Toast.makeText(CodingBaseActivity_test.this,"l",Toast.LENGTH_SHORT).show();
//                if(sprfMain.getBoolean("main",false)){
//                    Intent intent=new Intent(CodingBaseActivity_test.this,ForumActivity.class);
//                    startActivity(intent);
                if(BmobUser.isLogin()) {
                    Person user = BmobUser.getCurrentUser(Person.class);
                    webView.evaluateJavascript("index:Code.changeLanguage()", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            //????????? js ???????????????
//                        editor.putString("JS",value);
//                        editor.commit();
                            saveNewRecord(value);
                            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG);
                        }
                    });
                }
                else {
                    Intent intent=new Intent(CodingBaseActivity_test.this,ForumActivity.class);
                    startActivity(intent);
                }



            }
        });
        //??????????????????????????????
        //????????????
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                if(sprfMain.getBoolean("main",false)){
//                    Intent intent=new Intent(CodingBaseActivity_test.this,ForumActivity.class);
//                    startActivity(intent);
//
//                }
                if(BmobUser.isLogin()) {
                    Person user = BmobUser.getCurrentUser(Person.class);
                    //.getBoolean("main",false)???????????????"main"?????????????????????????????????false
                    workspaceLoadPath = "";
                    loadRecord();
                }
                else {
                    Intent intent=new Intent(CodingBaseActivity_test.this,ForumActivity.class);
                    startActivity(intent);
                }

            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String name = recordText.getText().toString();
                if (name.equals("") || name == null) {
                    Toast.makeText(CodingBaseActivity_test.this, R.string.no_project_selected, Toast.LENGTH_SHORT).show();
                } else {
                    webView.evaluateJavascript("index:Code.loadBlock(" + workspaceLoadPath + ")", new ValueCallback<String>() {

                        @Override
                        public void onReceiveValue(String value) {
                            //????????? js ???????????????
                        }
                    });
                    Toast.makeText(CodingBaseActivity_test.this,workspaceLoadPath,Toast.LENGTH_LONG);
                    initListView();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAllRecord();
            }
        });
        reName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renameRecord();
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser.logOut();
                Toast.makeText(CodingBaseActivity_test.this, "????????????", Toast.LENGTH_LONG).show();
                recordLayout.setVisibility(View.GONE);
            }
        });
        //zhl??????
        recordback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordLayout.setVisibility(View.GONE);
            }
        });

    }

    private void initListView() {
        recordLayout.setVisibility(View.GONE);
        recordText.setText("");
    }

    private void saveNewRecord(final String code) {
        InputDialog dialog = new InputDialog(CodingBaseActivity_test.this, new InputDialog.OnEditInputFinishedListener() {
            @Override
            public void editInputFinished(String name) {
                CodingPlace codingPlace = new CodingPlace();
                codingPlace.setCode(code);
                codingPlace.setName(name);
                codingPlace.setDate(getSavingDate());
                codingPlace.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e==null){
                            Toast.makeText(CodingBaseActivity_test.this, "??????????????????", Toast.LENGTH_LONG).show();
                            onCreate(null);
                        }else{
                            Toast.makeText(CodingBaseActivity_test.this, "??????????????????,??????????????????", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                //initRecord();
            }
        });
        dialog.setView(new EditText(CodingBaseActivity_test.this));
        dialog.show();
    }

    private void loadRecord() {
        //adapter.notifyDataSetChanged();
        recordLayout.setVisibility(View.VISIBLE);
        BmobQuery<CodingPlace> query = new BmobQuery<CodingPlace>();
        String bql ="select * from CodingPlace";//??????????????????
        new BmobQuery<CodingPlace>().doSQLQuery(bql,new SQLQueryListener<CodingPlace>(){
            @Override
            public void done(BmobQueryResult<CodingPlace> result, BmobException e) {
                if(e ==null){
                    savingRecordList = (List<CodingPlace>) result.getResults();
                    if(savingRecordList!=null && savingRecordList.size()>0){
                        ArrayList<Map<String, String>> resultList = new ArrayList<>();

                        for (CodingPlace CodingPlace : savingRecordList) {
                            Map<String, String> map = new HashMap<>();
                            map.put("name", CodingPlace.getName());
                            map.put("date", CodingPlace.getDate());
                            map.put("code", CodingPlace.getCode());
                            resultList.add(map);
                        }

                        SimpleAdapter simpleAdapter = new SimpleAdapter(CodingBaseActivity_test.this, resultList,
                                R.layout.record_item, new String[]{"name", "date"},
                                new int[] {R.id.record_name, R.id.record_date});
                        listView.setAdapter(simpleAdapter);
                    } else {
                        Log.i("smile", "??????????????????????????????");
                        Toast.makeText(CodingBaseActivity_test.this, "???????????????????????????", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Log.i("smile", "????????????"+e.getErrorCode()+"??????????????????"+e.getMessage());
                    Toast.makeText(CodingBaseActivity_test.this, "??????????????????", Toast.LENGTH_LONG).show();
                }
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CodingPlace savingRecord = savingRecordList.get(position);
                recordText.setText(savingRecord.getName());
                workspaceLoadPath = savingRecord.getCode();
                //Toast.makeText(CodingBaseActivity_test.this,workspaceLoadPath,Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                CodingPlace savingRecord = savingRecordList.get(position);
//                Toast.makeText(CodingBlocklyActivity.this,savingRecord.getSavingName()+savingRecord.getSavingWorkspace()+" 22",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(CodingBaseActivity_test.this);
                builder.setTitle(getString(R.string.delete) + savingRecord.getName());
                builder.setMessage(R.string.confirm_delete);
                String tempName = savingRecord.getName();
                builder.setPositiveButton(getString(R.string.delete), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //delete something
//                        LitePal.deleteAll(CodingPlace.class, "name = ? and code = ? and date = ?",
//                                savingRecordList.get(position).getName(),
//                                savingRecordList.get(position).getCode(),
//                                savingRecordList.get(position).getDate());
////
//                        savingRecordList.remove(position);
//                        adapter.notifyDataSetChanged();
                        BmobQuery<CodingPlace> query1 = new BmobQuery<>();
                        query1.addWhereEqualTo("name",tempName);
                        query1.findObjects(new FindListener<CodingPlace>() {
                            @Override
                            public void done(List<CodingPlace> object, BmobException e) {
                                if (e == null) {
                                    CodingPlace codingPlace2 = new CodingPlace();
                                    codingPlace2.delete(object.get(0).getObjectId(),new UpdateListener(){
                                        @Override
                                        public void done(BmobException e) {
                                            if (e == null) {
                                                Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                                            }else {
                                                Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                } else {
                                    Log.e("BMOB", e.toString());
                                    Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                loadRecord();
                builder.setNegativeButton(getString(R.string.cancel), null);
                builder.create().show();

                return false;
            }
        });
    }

//    private void initRecord() {
//        List<Coding> savingRecords = LitePal.findAll(Coding.class);
//        savingRecordList.clear();
//        if (savingRecords.size() > 0) {
//            for (Coding record : savingRecords) {
//                savingRecordList.add(record);
//            }
//        }
//    }

    public String getSavingDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return (simpleDateFormat.format(date));
    }

    private void clearAllRecord() {

        AlertDialog.Builder builder = new AlertDialog.Builder(CodingBaseActivity_test.this);
        builder.setTitle(R.string.clear);
        builder.setMessage(R.string.clear_all_project);
        builder.setPositiveButton(R.string.clear, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //LitePal.deleteAll(Coding.class);
                //adapter.notifyDataSetChanged();
                //initRecord();
                for(CodingPlace codingPlace : savingRecordList){
                    String tempName = codingPlace.getName();
                    BmobQuery<CodingPlace> query1 = new BmobQuery<>();
                    query1.addWhereEqualTo("name",tempName);
                    query1.findObjects(new FindListener<CodingPlace>() {
                        @Override
                        public void done(List<CodingPlace> object, BmobException e) {
                            if (e == null) {
                                CodingPlace codingPlace2 = new CodingPlace();
                                codingPlace2.delete(object.get(0).getObjectId(),new UpdateListener(){
                                    @Override
                                    public void done(BmobException e) {
                                        if (e == null) {
                                            //Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                                        }else {
                                            Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Log.e("BMOB", e.toString());
                                Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }




                initListView();
            }
        });
        loadRecord();
        builder.setNegativeButton(R.string.cancel, null);
        builder.create().show();
    }

    private void renameRecord() {
        if (workspaceLoadPath.equals("")) {
            Toast.makeText(CodingBaseActivity_test.this, R.string.no_project_selected, Toast.LENGTH_SHORT).show();
            return;
        }
        InputDialog dialog = new InputDialog(CodingBaseActivity_test.this, new InputDialog.OnEditInputFinishedListener() {
            @Override
            public void editInputFinished(String name) {
                String newName = name;

                if (!(newName == null || newName.equals(""))) {

                    String oldName = recordText.getText().toString();
                    // Toast.makeText(CodingBlocklyActivity.this,"in"+workspaceLoadPath,Toast.LENGTH_SHORT).show();
                    BmobQuery<CodingPlace> query1 = new BmobQuery<>();
                    query1.addWhereEqualTo("name",oldName);
                    query1.findObjects(new FindListener<CodingPlace>() {
                        @Override
                        public void done(List<CodingPlace> object, BmobException e) {
                            if (e == null) {
                                CodingPlace codingPlace2 = new CodingPlace();
                                codingPlace2.setName(newName);
                                codingPlace2.update(object.get(0).getObjectId(),new UpdateListener(){
                                    @Override
                                    public void done(BmobException e) {
                                        if (e == null) {
                                            Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                                        }else {
                                            Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Log.e("BMOB", e.toString());
                                Toast.makeText(CodingBaseActivity_test.this,"???????????????",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                    recordText.setText(newName);
                    loadRecord();
                    //initRecord();
                    //adapter.notifyDataSetChanged();
                    workspaceLoadPath = "";
                }
            }
        });
        dialog.setView(new EditText(CodingBaseActivity_test.this));
        dialog.show();
    }

    public List<String> returnBlockType(String value, String[] type) {
        List<String> stringList = new ArrayList<>();
        if (type.length <= 0 || value.length() <= 0)
            return null;
        else {
            while (StrMatching(value, type) != -1) {
                int temp = StrMatching(value, type);
                stringList.add(type[temp]);
                int min = value.indexOf(type[temp]);
                value = value.substring(min + 1);
            }
        }
        return stringList;
    }

    public int StrMatching(String value, String[] type)//?????????value???????????????position?????????????????????
    {
        int index = -1;
        int min = value.length() + 1;
        for (int i = 0; i < type.length; i++) {
            if (value.indexOf(type[i]) != -1 && value.indexOf(type[i]) < min) {
                min = value.indexOf(type[i]);
                index = i;
            }
        }
        return index;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void JudgeBlock() {

        webView.evaluateJavascript("index:Code.changeLanguage()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                //????????? js ???????????????
                List<String> stringList;


                Log.e("CodingBaseActivity_test", value);

                if (model.equals("coding_printf")) {

                    String[] type_printf = {"\\\"text_print\\\"", "\\\"text\\\""};
                    stringList = returnBlockType(value, type_printf);
                    switch (clickedLevel) {
                        case 1:
                            String[] strings1 = {"\\\"text_print\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings1, stringList)) {
                                Log.e("CodingBaseActivity_test", "SongSHaoKai");
                                rating = 3;
                            } else {
                                rating = 2;
                            }
                            break;
                        case 2:
                            String[] strings2 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"text\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings2, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 3:
                            String[] strings3 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"text\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"text\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings3, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        default:
                            rating = 2;
                            break;

                    }
                } else if (model.equals("coding_math")) {
                    String[] type_math = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_number\\\"", "\\\"math_arithmetic\\\""
                            , "\\\"math_single\\\"", "\\\"math_trig\\\"", "\\\"math_modulo\\\""};
                    stringList = returnBlockType(value, type_math);

                    switch (clickedLevel) {
                        case 1:
                            String[] strings1 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_number\\\""};

                            if (newStringEquals(strings1, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }

                            break;
                        case 2:
                            String[] strings2 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_arithmetic\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\""};
                            if (newStringEquals(strings2, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 3:
                            String[] strings3 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_single\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\""};
                            if (newStringEquals(strings3, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 4:
                            String[] strings4 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_trig\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\""};
                            if (newStringEquals(strings4, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 5:
                            String[] strings5 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_arithmetic\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\""};
                            if (newStringEquals(strings5, stringList)) {
                                rating = 3;
                            } else {
                                rating = 2;
                            }
                            break;
                        default:
                            rating = 2;
                            break;
                    }
                } else if (model.equals("coding_variable")) {
                    String[] type_variable = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_set\\\"", "\\\"math_number\\\"",
                            "\\\"variables_get\\\"", "\\\"math_change\\\"", "\\\"math_arithmetic\\\""};
                    stringList = returnBlockType(value, type_variable);
                    switch (clickedLevel) {
                        case 1:
                            String[] strings1 = {"\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings1, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 2:
                            String[] strings2 = {"\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"math_change\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings2, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 3:
                            String[] strings3 = {"\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"variables_set\\\"", "\\\"math_number\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_arithmetic\\\"", "\\\"math_number\\\""
                                    , "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings3, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 4:
                            String[] strings4 = {"\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"variables_set\\\"", "\\\"math_number\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_arithmetic\\\"", "\\\"math_number\\\""
                                    , "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_arithmetic\\\"", "\\\"math_number\\\""
                                    , "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings4, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 5:
                            String[] strings5 = {"\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"variables_set\\\"", "\\\"math_number\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_arithmetic\\\"", "\\\"math_number\\\""
                                    , "\\\"variables_get\\\"", "\\\"math_arithmetic\\\"", "\\\"math_number\\\""
                                    , "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings5, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        default:
                            rating = 2;
                            break;
                    }
                } else if (model.equals("coding_logic")) {
                    String[] type_logic = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"controls_if\\\"", "\\\"logic_boolean\\\""
                            , "\\\"logic_ternary\\\"", "\\\"logic_compare\\\"", "\\\"math_number\\\"", "\\\"logic_operation\\\""};
                    stringList = returnBlockType(value, type_logic);
                    Log.e("CodingBaseActivity_test", stringList.toString());
                    switch (clickedLevel) {
                        case 1:
                            String[] strings1 = {"\\\"controls_if\\\"", "\\\"logic_boolean\\\"", "\\\"text_print\\\"",
                                    "\\\"text\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings1, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 2:
                            String[] strings2 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"logic_ternary\\\"", "\\\"logic_boolean\\\"",
                                    "\\\"text\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings2, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 3:
                            String[] strings3 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"logic_ternary\\\"", "\\\"logic_compare\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings3, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 4:
                            String[] strings4 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"logic_ternary\\\"", "\\\"logic_operation\\\"",
                                    "\\\"logic_compare\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"logic_compare\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings4, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 5:
                            String[] strings5 = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"logic_ternary\\\"", "\\\"logic_operation\\\"",
                                    "\\\"logic_compare\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"logic_compare\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings5, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        default:
                            rating = 2;
                            break;
                    }
                } else if (model.equals("coding_loop")) {
                    String[] type_loop = {"\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_number\\\"", "\\\"controls_repeat_ext\\\"",
                            "\\\"controls_for\\\"", "\\\"variables_get\\\"", "\\\"controls_if\\\"", "\\\"math_number_property\\\"",
                            "\\\"logic_compare\\\"", "\\\"math_arithmetic\\\"", "\\\"controls_flow_statements\\\""};
                    stringList = returnBlockType(value, type_loop);
                    switch (clickedLevel) {
                        case 1:
                            String[] strings1 = {"\\\"controls_repeat_ext\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"text\\\""};
                            Log.e("CodingBaseActivity_test", stringList.toString());
                            if (newStringEquals(strings1, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 2:
                            String[] strings2 = {"\\\"controls_for\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings2, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 3:
                            String[] strings3 = {"\\\"controls_for\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"controls_if\\\"",
                                    "\\\"math_number_property\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\"", "\\\"text_print\\\"",
                                    "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings3, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 4:
                            String[] strings4 = {"\\\"controls_for\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"",
                                    "\\\"text\\\"", "\\\"variables_get\\\"", "\\\"controls_if\\\"", "\\\"logic_compare\\\"", "\\\"math_number\\\"",
                                    "\\\"math_arithmetic\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"",
                                    "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings4, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 5:
                            String[] strings5 = {"\\\"controls_for\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"controls_for\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"controls_if\\\"",
                                    "\\\"math_number_property\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\"", "\\\"text_print\\\"",
                                    "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings5, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        default:
                            rating = 2;
                            break;

                    }
                } else if (model.equals("coding_array")) {
                    String[] type_array = {"\\\"variables_get\\\"", "\\\"variables_set\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"math_number\\\"", "\\\"lists_create_empty\\\"",
                            "\\\"lists_create_with\\\"", "\\\"lists_length\\\"", "\\\"lists_repeat\\\"", "\\\"lists_indexOf\\\"", "\\\"lists_getIndex\\\"",
                            "\\\"lists_getSublist\\\"", "\\\"lists_setIndex\\\"", "\\\"lists_sort\\\""};
                    stringList = returnBlockType(value, type_array);
                    Log.e("CodingBaseActivity_test", stringList.toString());
                    switch (clickedLevel) {
                        case 1:
                            String[] strings1 = {"\\\"variables_set\\\"", "\\\"lists_create_with\\\"", "\\\"lists_repeat\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings1, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 2:
                            String[] strings2 = {"\\\"variables_set\\\"", "\\\"lists_create_with\\\"", "\\\"lists_repeat\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings2, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 3:
                            String[] strings3 = {"\\\"variables_set\\\"", "\\\"lists_create_with\\\"", "\\\"lists_repeat\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"lists_indexOf\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\""};
                            if (newStringEquals(strings3, stringList)) {
                                rating = 3;
                            } else {
                                rating = 2;
                            }
                            break;
                        case 4:
                            String[] strings4 = {"\\\"variables_set\\\"", "\\\"lists_create_with\\\"", "\\\"lists_repeat\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"lists_sort\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings4, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 5:
                            String[] strings5 = {"\\\"variables_set\\\"", "\\\"lists_create_with\\\"", "\\\"lists_repeat\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"",
                                    "\\\"lists_setIndex\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"lists_getSublist\\\"", "\\\"variables_get\\\"", "\\\"math_number\\\"", "\\\"math_number\\\""};
                            if (newStringEquals(strings5, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        default:
                            rating = 2;
                            break;
                    }
                } else if (model.equals("coding_function")) {
                    String[] type_function = {"\\\"procedures_callreturn\\\"", "\\\"procedures_ifreturn\\\"", "\\\"logic_boolean\\\"", "\\\"procedures_defreturn\\\"", "\\\"math_change\\\"", "\\\"controls_for\\\"", "\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"procedures_defnoreturn\\\"", "\\\"procedures_callnoreturn\\\""};
                    stringList = returnBlockType(value, type_function);
                    Log.e("CodingBaseActivity_test", stringList.toString());
                    switch (clickedLevel) {
                        case 1:
                            String[] strings1 = {"\\\"procedures_defnoreturn\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"text\\\"", "\\\"procedures_callnoreturn\\\""};
                            if (newStringEquals(strings1, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 2:
                            String[] strings2 = {"\\\"procedures_defnoreturn\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_get\\\"", "\\\"procedures_callnoreturn\\\"", "\\\"text\\\""};
                            if (newStringEquals(strings2, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                            break;
                        case 3:
                            String[] strings3 = {"\\\"procedures_defnoreturn\\\"", "\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"controls_for\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_number\\\"", "\\\"math_change\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"variables_get\\\"", "\\\"procedures_callnoreturn\\\""};
                            if (newStringEquals(strings3, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                        case 4:
                            String[] strings4 = {"\\\"procedures_defreturn\\\"", "\\\"variables_set\\\"", "\\\"math_number\\\"", "\\\"variables_get\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"procedures_callreturn\\\""};
                            if (newStringEquals(strings4, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                        case 5:
                            String[] strings5 = {"\\\"procedures_defreturn\\\"", "\\\"procedures_ifreturn\\\"", "\\\"variables_get\\\"", "\\\"text\\\"", "\\\"text\\\"", "\\\"text_print\\\"", "\\\"text\\\"", "\\\"procedures_callreturn\\\"", "\\\"variables_get\\\""};
                            if (newStringEquals(strings5, stringList))
                                rating = 3;
                            else {
                                rating = 2;
                            }
                        default:
                            rating = 2;
                            break;
                    }
                }
                Log.e("Activity", rating + "d");
                if (rating == 3) {
                    Util.showDialog2(CodingBaseActivity_test.this, getString(R.string.success), 3, clickedLevel < maxLevel, handler);
                } else if (rating == 2) {
                    Util.showDialog2(CodingBaseActivity_test.this, getString(R.string.fail), 0, clickedLevel < maxLevel, handler);
                } else {
                    //???????????????????????????
                }

            }
        });

    }

    private boolean newStringEquals(String[] stringArray, List<String> stringList) {
        if (stringArray.length != stringList.size())
            return false;
        for (int i = 0; i < stringArray.length; i++) {
            if (!stringArray[i].equals(stringList.get(i)))
                return false;
        }
        return true;
    }

    private void initClickedChapter() {
        switch (model) {
            case "coding_printf":
                clickedChapter = 1;
                break;
            case "coding_math":
                clickedChapter = 2;
                break;
            case "coding_variable":
                clickedChapter = 3;
                break;
            case "coding_logic":
                clickedChapter = 4;
                break;
            case "coding_loop":
                clickedChapter = 5;
                break;
            case "coding_array":
                clickedChapter = 6;
                break;
            case "coding_function":
                clickedChapter = 7;
                break;
            default:
                break;
        }
    }
}