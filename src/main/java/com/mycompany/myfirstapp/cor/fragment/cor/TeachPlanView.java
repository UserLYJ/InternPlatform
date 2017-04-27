package com.mycompany.myfirstapp.cor.fragment.cor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/27.
 */

public class TeachPlanView extends AppCompatActivity {

    TextView[] mTextView = new TextView[4];
    Button mPush;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cor_teachplan);
        mPush = (Button) findViewById(R.id.btn_cor_pushplace);
        mPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTextView[0] = (TextView)findViewById(R.id.proname);
        mTextView[1] = (TextView)findViewById(R.id.schname);
        mTextView[2] = (TextView)findViewById(R.id.number);
        mTextView[3] = (TextView)findViewById(R.id.protip);
    }
}
