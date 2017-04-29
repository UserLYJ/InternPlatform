package com.mycompany.myfirstapp.cor.fragment.resume;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/16.
 */

public class StudentDetailsView extends AppCompatActivity {

    TextView[] mTextView = new TextView[5];
    Button mAccept;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.page_studetail);
        mAccept = (Button) findViewById(R.id.btn_page_accept);
        mAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTextView[0] = (TextView)findViewById(R.id.stu_name);
        mTextView[1] = (TextView)findViewById(R.id.stu_schname);
        mTextView[2] = (TextView)findViewById(R.id.exp);
        mTextView[3] = (TextView)findViewById(R.id.honor);
        mTextView[4] = (TextView)findViewById(R.id.stu_describe);
    }
}
