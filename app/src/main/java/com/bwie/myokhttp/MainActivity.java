package com.bwie.myokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getExcute();
    }

    private void getExcute() {

        new Thread(){
            @Override
            public void run() {
                super.run();
                final String result = OkHttpUtils.get("http://www.baidu.com");

                textview.post(new Runnable() {
                    @Override
                    public void run() {

                        textview.setText(result);
                    }
                });


            }
        }.start();


    }

    private void initView() {

        textview = (TextView) findViewById(R.id.textview);

    }
}
