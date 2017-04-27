package com.mycompany.myfirstapp.utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * Created by wangz on 2017/4/16.
 */

public class JSONThread implements Runnable {
    JSONInteractor mInteractor;

    JSONThread(JSONInteractor interactor){
        mInteractor = interactor;
    }
    @Override
    public void run() {
        StringBuilder builder = new StringBuilder();
        HttpURLConnection conn = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            conn = (HttpURLConnection)mInteractor.url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);

            out = conn.getOutputStream();
            in = conn.getInputStream();

            out.write(mInteractor.reqJSON.toString().getBytes());
            out.flush();

            byte [] buffer = new byte[100];
            while (in.read(buffer) != -1){
                builder.append(new String(buffer));
            }
            mInteractor.resJSON = new JSONObject(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println(conn.getResponseCode());
                System.out.println(conn.getResponseMessage());
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果发生了异常，就会返回null
        mInteractor.mOnCompleteListener.onComplete(mInteractor.resJSON);
    }
}
