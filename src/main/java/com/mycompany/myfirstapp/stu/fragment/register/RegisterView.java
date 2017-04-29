package com.mycompany.myfirstapp.stu.fragment.register;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/18.
 */

public class RegisterView extends AppCompatActivity implements View.OnClickListener{

    Button [] mButton = new Button[5];
    DatePickerDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.stu_register);
        mButton[0] = (Button)findViewById(R.id.in_time);
        mButton[1] = (Button)findViewById(R.id.out_time);
        mButton[2] = (Button)findViewById(R.id.btn_stu_jumpToEducate);
        mButton[3] = (Button)findViewById(R.id.btn_stu_addaffix);
        mButton[4] = (Button)findViewById(R.id.btn_stu_saveresume);

        for(Button button : mButton){
            button.setOnClickListener(this);
        }

        mDialog = new DatePickerDialog(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.in_time:
                mDialog.show();
                break;
            case R.id.out_time:
                mDialog.show();
                break;
            case R.id.btn_stu_jumpToEducate:
                startActivity(new Intent(this, AddExperienceView.class));
                break;
            case R.id.btn_stu_addaffix:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);
                break;
            case R.id.btn_stu_saveresume:
                finish();
                break;
        }
    }
}
