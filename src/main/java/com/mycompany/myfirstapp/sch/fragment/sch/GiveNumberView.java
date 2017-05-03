package com.mycompany.myfirstapp.sch.fragment.sch;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/30.
 */

public class GiveNumberView extends AppCompatActivity {
    private Button mPublish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sch_givenumer);
        mPublish = (Button)findViewById(R.id.button6);
        mPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void checkRegisteredStu(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.sch_givenumber_dialog);
        builder.show();
    }
}
