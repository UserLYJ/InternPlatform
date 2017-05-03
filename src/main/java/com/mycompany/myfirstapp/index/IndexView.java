package com.mycompany.myfirstapp.index;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.sch.SchView;
import com.mycompany.myfirstapp.stu.StuView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by wangz on 2017/4/14.
 */

public class IndexView extends AppCompatActivity {

    private static final String TAG = "IndexView";
    RadioGroup mRadioGroup;
    EditText mName, mPassword;
    Button mSignIn, mSignUp;
    IndexPresenter mPresenter;
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initiate();
    }

    private void initiate() {
        setContentView(R.layout.activity_my);

        mRadioGroup = (RadioGroup)findViewById(R.id.rg_select);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id._sch:
                        mPresenter.onSchPicked();
                        break;
                    case R.id._stu:
                        mPresenter.onStuPicked();
                        break;
                    case R.id._cor:
                        mPresenter.onCorPicked();
                        break;
                }
            }
        });
        mName = (EditText)findViewById(R.id.username);
        mPassword = (EditText)findViewById(R.id.password);
        mSignIn = (Button)findViewById(R.id.btn_login);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onSignIn(mName.getText().toString(), mPassword.getText().toString());
            }
        });
        mSignUp = (Button)findViewById(R.id.btn_register);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onSignUp();
            }
        });

        File f = new File(getCacheDir()+"/test.db");
        if (!f.exists()) try {

            InputStream is = getAssets().open("test.db");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();


            FileOutputStream fos = new FileOutputStream(f);
            fos.write(buffer);
            fos.close();
        } catch (Exception e) { throw new RuntimeException(e); }

        mDatabase = SQLiteDatabase.openDatabase(getCacheDir().getPath() + "/test.db", null, SQLiteDatabase.OPEN_READWRITE);

        mPresenter = new IndexPresenter(this, mDatabase);
    }
    public void GoToCorView(){
        Intent intent = new Intent(this, CorView.class);
        startActivity(intent);
    }
    public void GoToSchView(){
        Intent intent = new Intent(this, SchView.class);
        startActivity(intent);
    }
    public void GoToStuView(){
        Intent intent = new Intent(this, StuView.class);
        startActivity(intent);
    }
    public void showToast(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.close();
    }
}
