package com.example.codeland;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.codeland.bmob.Content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;


public class ContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        //初始化 Bmob SDK，第一个参数为上下文，第二个参数为Application ID
       // Bmob.resetDomain("http://codeland.waityousell.com/8/");
        Bmob.initialize(this, "00fbe513d7a008bf4d6b48fdf60235dd");

        Button send = findViewById(R.id.btn_hf_send);
        EditText et_hf_content = findViewById(R.id.et_hf_content);
        ListView listView = findViewById(R.id.lv_hf_listview);

        BmobQuery<Content> query = new BmobQuery<Content>();

        String bql ="select * from Content";//查询所有记录
        new BmobQuery<Content>().doSQLQuery(bql,new SQLQueryListener<Content>(){

            @Override
            public void done(BmobQueryResult<Content> result, BmobException e) {
                if(e ==null){
                    List<Content> list = (List<Content>) result.getResults();
                    if(list!=null && list.size()>0){
                        ArrayList<Map<String, String>> resultList = new ArrayList<>();

                        for (Content Content : list) {
                            Map<String, String> map = new HashMap<>();
                            map.put("name", Content.getName());
                            map.put("date", Content.getDate());
                            map.put("content", Content.getContent());
                            resultList.add(map);
                        }

                        SimpleAdapter simpleAdapter = new SimpleAdapter(ContentActivity.this, resultList,
                                R.layout.content, new String[]{"name", "date", "content"},
                                new int[] {R.id.content_name, R.id.content_date, R.id.content_content});
                        listView.setAdapter(simpleAdapter);
                    } else {
                        Log.i("smile", "查询成功，无数据返回");
                        Toast.makeText(ContentActivity.this, "讨论区还没内容哦！", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Log.i("smile", "错误码："+e.getErrorCode()+"，错误描述："+e.getMessage());
                    Toast.makeText(ContentActivity.this, "错误码："+e.getErrorCode()+"，错误描述："+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = et_hf_content.getText().toString();
                if (content.equals("")) {
                    Toast.makeText(ContentActivity.this, "发送内容为空！", Toast.LENGTH_LONG).show();
                } else {
                    Content Content = new Content();
                    Content.setName("无名氏");
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Content.setDate(simpleDateFormat.format(date));
                    Content.setContent(content);
                    Content.save(new SaveListener<String>() {
                        @Override
                        public void done(String objectId,BmobException e) {
                            if(e==null){
                                Toast.makeText(ContentActivity.this, "添加数据成功，返回objectId为："+objectId, Toast.LENGTH_LONG).show();
                                onCreate(null);
                            }else{
                                Toast.makeText(ContentActivity.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}