package com.example.codeland.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.codeland.R;
import com.example.codeland.app.MyApplication;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017-12-18.
 */

public class Util {





    //这里使用到了JAVA的可变长参数 int... dialogModule ，也就是在方法定义中可以使用个数不确定的参数，对于同一方法可以使用不同个数的参数调用
    //我们用dialogModule的值判断是那个模块的对话框，以重新定义对话框的UI布局：目前是 不传参默认第一模块和第二模块；传参为3代表第三模块
    public static void showDialog(Context context, String text, int rating, final Handler handler,int... dialogModule){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);



        View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_match_dialog, null);
        RatingBar ratingBar=  dialogView.findViewById(R.id.match_dialog_ratingbar);
        TextView tvMessage = dialogView.findViewById(R.id.match_dialog_text);
        TextView textView_console = dialogView.findViewById(R.id.textview_console);
        LinearLayout linearLayout_button=dialogView.findViewById(R.id.dialog_button_linearlayout);
        //让文本支持滑动
        tvMessage.setMovementMethod(ScrollingMovementMethod.getInstance());

        //首先一定要注意，如果数组为空，即便是写 if(dialogModule[0]==3)也会报错，所以先判断数组是否存在
        //如果是第三模块中的对话框，那么多出文字“控制台”
        if(dialogModule.length!=0){
            if(dialogModule[0]==3){
                textView_console.setVisibility(View.VISIBLE);
            }
            else if(dialogModule[0]==4){
                textView_console.setVisibility(View.VISIBLE);
                ratingBar.setVisibility(View.GONE);
                linearLayout_button.setVisibility(View.GONE);
            }
            else{

            }
        }

        ratingBar.setRating(rating);
        tvMessage.setText(text);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();

        //而其他模块中，涉及下一关等按钮，除了对话框的按钮，其他都不可点击，否则逻辑很麻烦
        dialog.setCancelable(false);
        dialog.show();

        Button btnQuit = dialogView.findViewById(R.id.match_dialog_btn_quit);
        Button btnCheck = dialogView.findViewById(R.id.match_dialog_btn_check);
        Button btnNext = dialogView.findViewById(R.id.match_dialog_btn_next);

        //如果分数没有达到满分，依然有完善的块，使 下一关的块消失
        if(rating<2){
            MyApplication.playClickVoice(MyApplication.getContext(),"failure");
            btnNext.setVisibility(View.GONE);
        }
        //如果是满分3星，则运行以下代码
        else {
            //播放成功音效
            MyApplication.playClickVoice(MyApplication.getContext(),"success");

            btnNext.setVisibility(View.VISIBLE);
        }

//        if(flag == true){
//            btnNext.setVisibility(View.VISIBLE);
//        }else{
//            btnNext.setVisibility(View.GONE);
//        }

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //使用回调让Activity进行处理
                if(handler!=null)
                    handler.sendEmptyMessage(1);
                dialog.dismiss();
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //使用回调让Activity进行处理
                if(handler!=null)
                    handler.sendEmptyMessage(2);
                dialog.dismiss();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //使用回调让Activity进行处理
                if(handler!=null)
                    handler.sendEmptyMessage(3);
                dialog.dismiss();
            }
        });



    }

    public static void showDialog2(Context context, String text, int rating,boolean flag, final Handler handler,int... dialogModule){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);



        View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_match_dialog, null);
        RatingBar ratingBar=  dialogView.findViewById(R.id.match_dialog_ratingbar);
        TextView tvMessage = dialogView.findViewById(R.id.match_dialog_text);
        TextView textView_console = dialogView.findViewById(R.id.textview_console);
        LinearLayout linearLayout_button=dialogView.findViewById(R.id.dialog_button_linearlayout);
        //让文本支持滑动
        tvMessage.setMovementMethod(ScrollingMovementMethod.getInstance());

        //首先一定要注意，如果数组为空，即便是写 if(dialogModule[0]==3)也会报错，所以先判断数组是否存在
        //如果是第三模块中的对话框，那么多出文字“控制台”
        if(dialogModule.length!=0){
            if(dialogModule[0]==3){
                textView_console.setVisibility(View.VISIBLE);
            }
            else if(dialogModule[0]==4){
                textView_console.setVisibility(View.VISIBLE);
                ratingBar.setVisibility(View.GONE);
                linearLayout_button.setVisibility(View.GONE);
            }
            else{

            }
        }

        ratingBar.setRating(rating);
        tvMessage.setText(text);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();

        //而其他模块中，涉及下一关等按钮，除了对话框的按钮，其他都不可点击，否则逻辑很麻烦
        dialog.setCancelable(false);
        dialog.show();

        Button btnQuit = dialogView.findViewById(R.id.match_dialog_btn_quit);
        Button btnCheck = dialogView.findViewById(R.id.match_dialog_btn_check);
        Button btnNext = dialogView.findViewById(R.id.match_dialog_btn_next);

        //如果分数没有达到满分，依然有完善的块，使 下一关的块消失
        if(rating<2){
            MyApplication.playClickVoice(MyApplication.getContext(),"failure");
            btnNext.setVisibility(View.GONE);
        }
        //如果是满分3星，则运行以下代码
        else {
            //播放成功音效
            MyApplication.playClickVoice(MyApplication.getContext(),"success");

            btnNext.setVisibility(View.VISIBLE);
        }

        //如果是最后一关，隐藏“下一关”按钮
        if(flag == false){
            btnNext.setVisibility(View.GONE);
        }

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //使用回调让Activity进行处理
                if(handler!=null)
                    handler.sendEmptyMessage(1);
                dialog.dismiss();
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //使用回调让Activity进行处理
                if(handler!=null)
                    handler.sendEmptyMessage(2);
                dialog.dismiss();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //使用回调让Activity进行处理
                if(handler!=null)
                    handler.sendEmptyMessage(3);
                dialog.dismiss();
            }
        });



    }

    //二维数组存储 每一章节每一关卡的 答案图片
    private static int[][]image_answer_array={
            {R.mipmap.module3_answer_1_1,R.mipmap.module3_answer_1_2,R.mipmap.module3_answer_1_3},
            {R.mipmap.module3_answer_2_1,R.mipmap.module3_answer_2_2,R.mipmap.module3_answer_2_3,R.mipmap.module3_answer_2_4,R.mipmap.module3_answer_2_5},
            {R.mipmap.module3_answer_3_1,R.mipmap.module3_answer_3_2,R.mipmap.module3_answer_3_3,R.mipmap.module3_answer_3_4,R.mipmap.module3_answer_3_5},
            {R.mipmap.module3_answer_4_1,R.mipmap.module3_answer_4_2,R.mipmap.module3_answer_4_3,R.mipmap.module3_answer_4_4,R.mipmap.module3_answer_4_5},
            {R.mipmap.module3_answer_5_1,R.mipmap.module3_answer_5_2,R.mipmap.module3_answer_5_3,R.mipmap.module3_answer_5_4,R.mipmap.module3_answer_5_5},
            {R.mipmap.module3_answer_6_1,R.mipmap.module3_answer_6_2,R.mipmap.module3_answer_6_3,R.mipmap.module3_answer_6_4,R.mipmap.module3_answer_6_5},
            {R.mipmap.module3_answer_7_1,R.mipmap.module3_answer_7_2,R.mipmap.module3_answer_7_3,R.mipmap.module3_answer_7_4,R.mipmap.module3_answer_7_5}
    };
    private static int[][]image_answer_array_en={
            {R.mipmap.en_1_1,R.mipmap.en_1_2,R.mipmap.en_1_3},
            {R.mipmap.en_2_1,R.mipmap.en_2_2,R.mipmap.en_2_3,R.mipmap.en_2_4,R.mipmap.en_2_5},
            {R.mipmap.en_3_1,R.mipmap.en_3_2,R.mipmap.en_3_3,R.mipmap.en_3_4,R.mipmap.en_3_5},
            {R.mipmap.en_4_1,R.mipmap.en_4_2,R.mipmap.en_4_3,R.mipmap.en_4_4,R.mipmap.en_4_5},
            {R.mipmap.en_5_1,R.mipmap.en_5_2,R.mipmap.en_5_3,R.mipmap.en_5_4,R.mipmap.en_5_5},
            {R.mipmap.en_6_1,R.mipmap.en_6_2,R.mipmap.en_6_3,R.mipmap.en_6_4,R.mipmap.en_6_5},
            {R.mipmap.en_6_1,R.mipmap.en_6_2,R.mipmap.en_6_3,R.mipmap.en_6_4,R.mipmap.en_6_5}
    };


    public static void showModule3TipDialog(Context context,int chapter,int level, final Handler handler){
        if(chapter==0)
            return;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);


        View dialogView = LayoutInflater.from(context).inflate(R.layout.module3_tip_dialog, null);

        Button button_close=dialogView.findViewById(R.id.button_modul3_tip_close);
        final Button button_look_answer=dialogView.findViewById(R.id.button_module3_look_answer);
        final TextView textView_tip=dialogView.findViewById(R.id.module3_tip);
        //让 任务说明文本过长时可支持滑动
        textView_tip.setMovementMethod(ScrollingMovementMethod.getInstance());
        final TextView textView_task=dialogView.findViewById(R.id.module3_task);

        final Button button_back=dialogView.findViewById(R.id.button_modul3_tip_back);
        final ImageView imageView_answer=dialogView.findViewById(R.id.image_module3_answer);

        if (MyApplication.languageFlag==1){
            imageView_answer.setImageResource(image_answer_array[chapter-1][level-1]);
        }
        else{
            imageView_answer.setImageResource(image_answer_array_en[chapter-1][level-1]);
        }
        //读取 关卡要求信息txt，获取每一章节的每一关卡的编程要求
        try{
            if(MyApplication.languageFlag==1) {
                InputStream is = context.getAssets().open("coding/json_chinese/module3_tip.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] arrays = null;//备用数组，用于获取每一行中的 chapter章节，level关卡，信息
                    arrays = line.split(">");
                    //Integer.parseInt(str)用于将字符串转化为int
                    if (chapter == Integer.parseInt(arrays[0]) && level == Integer.parseInt(arrays[1])) {
                        textView_tip.setText(arrays[2]);
                    }

                }
                br.close();
                is.close();
            }
            else{
                InputStream is = context.getAssets().open("coding/json_chinese/english_module3_tip.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] arrays = null;//备用数组，用于获取每一行中的 chapter章节，level关卡，信息
                    arrays = line.split(">");
                    //Integer.parseInt(str)用于将字符串转化为int
                    if (chapter == Integer.parseInt(arrays[0]) && level == Integer.parseInt(arrays[1])) {
                        textView_tip.setText(arrays[2]);
                    }

                }
                br.close();
                is.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        button_look_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_task.setVisibility(View.GONE);
                textView_tip.setVisibility(View.GONE);
                button_look_answer.setVisibility(View.GONE);
                button_back.setVisibility(View.VISIBLE);
                imageView_answer.setVisibility(View.VISIBLE);
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_task.setVisibility(View.VISIBLE);
                textView_tip.setVisibility(View.VISIBLE);
                button_look_answer.setVisibility(View.VISIBLE);
                button_back.setVisibility(View.GONE);
                imageView_answer.setVisibility(View.GONE);
            }
        });
        dialog.show();
    }

    /**
     *此方法的相关信息(All information about this function)
     *@fileName Util
     *@date on 2018/7/29 16:02
     *@author JedLee 李俊德
     *@email 386236308@qq.com
     *@purpose（此方法的用途）
     */
    public static void showContactUsDialog(Context context){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);


        View dialogView = LayoutInflater.from(context).inflate(R.layout.contact_us_dialog, null);

        final TextView textView_contact_us=dialogView.findViewById(R.id.textView_contact_us);
        //让 任务说明文本过长时可支持滑动
        textView_contact_us.setMovementMethod(ScrollingMovementMethod.getInstance());

        TextView textView_contact_us_information=dialogView.findViewById(R.id.textview_contact_us_information);
        textView_contact_us_information.setMovementMethod(ScrollingMovementMethod.getInstance());
        //根据中英文展现不同的语言的联系方式
        if(MyApplication.languageFlag==MyApplication.LANGUAGE_CHINESE) {
            textView_contact_us.setText(R.string.contact_us_chinese);
            textView_contact_us_information.setText(R.string.contact_us_information_chinese);
        }else {
            textView_contact_us.setText(R.string.contact_us_english);
            textView_contact_us_information.setText(R.string.contact_us_information_english);
        }

        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();

        Button buttonClose=dialogView.findViewById(R.id.button_contact_us_close);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


//    /**
//     * 显示引导的蒙版（最为一般的：一张图片+一段文字）
//     */
//    public static void showGuide(final Context context, final int textId, final int imgId) {
//        NewbieGuide.with((Activity) context)
//                .setLabel("page")
//                .alwaysShow(true)
//                .addGuidePage(
//                        GuidePage.newInstance()
//                                .setLayoutRes(R.layout.layout_guide)
////                                .setOnLayoutInflatedListener(new OnLayoutInflatedListener() {
////                                    @Override
////                                    public void onLayoutInflated(View view) {
////                                        TextView tvTip = view.findViewById(R.id.guide_tv_tip);
////                                        ImageView ivExample = view.findViewById(R.id.guide_iv_example);
////                                        tvTip.setText(context.getText(textId));
////                                        ivExample.setImageResource(imgId);
////                                    }
////                                })
//                ).show();
//
//    }

}
