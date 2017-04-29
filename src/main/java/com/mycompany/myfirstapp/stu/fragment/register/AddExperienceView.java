package com.mycompany.myfirstapp.stu.fragment.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/27.
 */

public class AddExperienceView extends AppCompatActivity {
    Button mButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_addexperience);
        mButton = (Button) findViewById(R.id.btn_stu_saveexper);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
