package com.example.codeland.scratchgame.fragment;

import com.example.codeland.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaikeFragment extends Fragment {
    private WebView mWebView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baike,container,false);
        mWebView = view.findViewById(R.id.f_baike_webview);
        WebSettings settings = mWebView.getSettings();
        //设置支持JS
        settings.setJavaScriptEnabled(true);
        //设置直接在webview中展示网页
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl("file:///android_asset/baike/baike_guide.html");
        return view;
    }

    /**
     * 刷新Fragment
     * @param url
     */
    public void refresh(String url){
        //使用webview加载指定的网页
        mWebView.loadUrl(url);
    }
    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
