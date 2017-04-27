package com.mycompany.myfirstapp.cor.fragment.place;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/16.
 */

public class PlaceView extends AppCompatActivity {

    Button mDltPlace, mEditPlace;
    ProgressDialog mDialog;
    AlertDialog mAlert;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cor_placedetails);

        mDltPlace = (Button)findViewById(R.id.btn_cor_delectplace);
        mEditPlace = (Button)findViewById(R.id.btn_cor_editplace);

        mEditPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddPlaceView.class));
            }
        });
        mDltPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlert.show();
            }
        });
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确定要删除吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //// TODO: 2017/4/17
                        finish();
                    }
                })
                .setNegativeButton("取消", null);
        mAlert = builder.create();
    }

}
