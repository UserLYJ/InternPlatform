package com.mycompany.myfirstapp.cor.fragment.trainingdep;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/17.
 */

public class AddTeacherView extends AppCompatActivity{
    Button mSave;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cor_addtrainteacher);
        mSave = (Button) findViewById(R.id.btn_savetrain);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
