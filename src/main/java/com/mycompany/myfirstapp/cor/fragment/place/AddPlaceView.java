package com.mycompany.myfirstapp.cor.fragment.place;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/17.
 */

public class AddPlaceView extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cor_addplace);
    }
}
