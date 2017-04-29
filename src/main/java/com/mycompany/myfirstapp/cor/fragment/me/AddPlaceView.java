package com.mycompany.myfirstapp.cor.fragment.me;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/27.
 */

public class AddPlaceView extends AppCompatActivity implements View.OnClickListener{

    Button [] mButton = new Button[4];
    DatePickerDialog mDialog;
    View mDialogView;
    Spinner mSchoolName;
    EditText mStuCount;
    GridView mList;
    Button mSave, mConfirm;
    private AlertDialog mSchoolDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cor_addplace);

        mDialog = new DatePickerDialog(this);

        mButton[0] = (Button)findViewById(R.id.number);
        mButton[1] = (Button)findViewById(R.id.start_time);
        mButton[2] = (Button)findViewById(R.id.button7);
        mButton[3] = (Button)findViewById(R.id.btn_saveplace);
        for(Button button : mButton)
            button.setOnClickListener(this);

        mDialogView = getLayoutInflater().inflate(R.layout.cor_addplacenumber, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(mDialogView);
        mSchoolDialog = builder.create();

        mSchoolName = (Spinner) mDialogView.findViewById(R.id.spinner5);
        mSchoolName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mStuCount = (EditText) mDialogView.findViewById(R.id.editText9);
        mList = (GridView) mDialogView.findViewById(R.id.number);
        mConfirm = (Button) mDialogView.findViewById(R.id.btn_comfirm);
        mConfirm.setOnClickListener(this);
        mSave = (Button) mDialogView.findViewById(R.id.save);
        mSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.number:
                mSchoolDialog.show();
                break;
            case R.id.start_time:
                mDialog.show();
                break;
            case R.id.button7:
                mDialog.show();
                break;
            case R.id.btn_saveplace:
                finish();
                break;
            case R.id.save:
                showSchoolList();
                break;
            case R.id.btn_comfirm:
                mSchoolDialog.dismiss();
                break;
        }
    }

    private void showSchoolList() {
        String studentCount = mStuCount.getText().toString();

    }
}
