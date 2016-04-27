package vn.coderschool.thorgroup.travelling.service;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by tanlnm on 4/20/2016.
 */
public class HttpService {
    private static class HttpServiceHolder {
        private static HttpService instance = new HttpService();
    }

    public static HttpService getInstance() {
        return HttpServiceHolder.instance;
    }

    private static final String API_URL = "http://128.199.197.252/api";

    private void call(String subfix, String method, Bundle data, File file, final HttpUtils.IResultListener callback) {
        String url = API_URL;

        if (!TextUtils.isEmpty(subfix)) url += subfix;

        if (data != null) {
            for (String key : data.keySet()) {
                String value = data.getString(key);
                if (TextUtils.isEmpty(value)) continue;
                try {
                    value = URLEncoder.encode(value, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    Log.e("DEBUG", "Encode data error!", e);
                }
                url += key + "=" + value + "&";
            }
        }

        new HttpUtils(file, callback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url, method, null, null);
    }

    public void getFeeds(HttpUtils.IResultListener callback) {
        call("/feed", "GET", null, null, callback);
    }
    public void postPosts(HttpUtils.IResultListener callback,String status,double longitude, double latitude,File image,String category,boolean reaction ){
        Bundle bd = new Bundle();
        bd.putString("status",status);
        bd.putDouble("longitude",longitude);
        bd.putDouble("latitude",latitude);
        bd.putString("category",category);
        bd.putBoolean("reaction",reaction);
        call("/posts", "POST", bd, image, callback);
    }
}
