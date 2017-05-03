package com.mycompany.myfirstapp.stu.fragment.stu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/5/1.
 */

public class WanttodoView extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_wanttodo);
    }

    public void register(View view) {
        finish();
    }
}
