package com.bwie.myokhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shenzhaoxing on 2016/11/5.
 */

public class OkHttpUtils {

    private static OkHttpClient client = new OkHttpClient();
    //同步加载（不需要回调接口）
    public static String get(String url){

        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();

            if(response.isSuccessful()){

               return response.body().string();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
