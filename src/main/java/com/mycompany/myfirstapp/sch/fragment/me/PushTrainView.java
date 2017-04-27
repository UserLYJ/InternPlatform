package com.mycompany.myfirstapp.sch.fragment.me;

import android.app.*;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/27.
 */

public class PushTrainView extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DatePickerDialog.OnDateSetListener {

    Spinner mMajor;
    EditText mTotal;
    Button mStart, mEnd, mPublish;
    android.app.DatePickerDialog mDialogStart, mDialogEnd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sch_pushtrain);
        mMajor = (Spinner) findViewById(R.id.spename);
        mTotal = (EditText)findViewById(R.id.stunumber);
        mStart = (Button) findViewById(R.id._starttime);
        mEnd = (Button) findViewById(R.id.end_time);
        mPublish = (Button) findViewById(R.id.push);

        //mMajor.setOnItemClickListener(this);
        mStart.setOnClickListener(this);
        mEnd.setOnClickListener(this);
        mPublish.setOnClickListener(this);

        mDialogStart = new DatePickerDialog(this);
        mDialogStart.setOnDateSetListener(this);
        mDialogEnd = new DatePickerDialog(this);
        mDialogEnd.setOnDateSetListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id._starttime:
                mDialogStart.show();
                break;
            case R.id.end_time:
                mDialogEnd.show();
                break;
            case R.id.push:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
