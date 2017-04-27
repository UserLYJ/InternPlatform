package com.mycompany.myfirstapp.utilities;

import com.mycompany.myfirstapp.index.IndexPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wangz on 2017/4/15.
 */

public class JSONInteractor {

    JSONObject reqJSON;
    JSONObject resJSON;
    URL url;
    OnCompleteListener mOnCompleteListener;

    public interface OnCompleteListener{
        void onComplete(JSONObject resJSON);
    }

    public void setOnCompleteListener(OnCompleteListener listener){
        mOnCompleteListener = listener;
    }

    public void setRequestJSON(JSONObject json){
        reqJSON = json;
    }

    public void getResponseJSON(String url){
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            mOnCompleteListener.onComplete(null);
            return;
        }
        new Thread(new JSONThread(this)).start();
    }
}
