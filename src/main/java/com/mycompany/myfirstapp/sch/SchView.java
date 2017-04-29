package com.mycompany.myfirstapp.sch;

import android.app.FragmentManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.sch.fragment.MeFragment;
import com.mycompany.myfirstapp.sch.fragment.MessageFragment;
import com.mycompany.myfirstapp.sch.fragment.MoreFragment;
import com.mycompany.myfirstapp.sch.fragment.MyStudentsFragment;
import com.mycompany.myfirstapp.sch.fragment.SchFragment;
import com.mycompany.myfirstapp.sch.fragment.TeachingPlanFragment;
import com.mycompany.myfirstapp.utilities.TabButton;

/**
 * Created by wangz on 2017/4/14.
 */

public class SchView extends AppCompatActivity implements View.OnClickListener{

    TabButton mBtnMessage, mBtnStudents, mBtnPlan, mBtnMore, mBtnSch;
    MeFragment mMeFragment;
    MessageFragment mMessageFragment;
    MoreFragment mMoreFragment;
    MyStudentsFragment mStudentsFragment;
    SchFragment mSchFragment;
    TeachingPlanFragment mPlanFragment;
    Bitmap[] mTabButtonBitmap = new Bitmap[10];

    private FragmentManager mManager;
    public SchPresenter mPresenter;
    public SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initiate();
        mManager.beginTransaction().replace(R.id.sch_container,mSchFragment).commitNow();
    }

    private void initiate() {
        setContentView(R.layout.sch_main_nav);

        mBtnSch= (TabButton) findViewById(R.id.button);
        mBtnStudents= (TabButton)findViewById(R.id.button1);
        mBtnPlan= (TabButton)findViewById(R.id.button2);
        mBtnMessage= (TabButton)findViewById(R.id.button3);
        mBtnMore= (TabButton)findViewById(R.id.button4);

        mBtnMessage.TAG = "我的消息";
        mBtnMore.TAG = "更多";
        mBtnStudents.TAG = "本院学生";
        mBtnPlan.TAG = "教学计划";
        mBtnSch.TAG = "首页";
        mBtnMessage.paint.setColor(0xff000000);
        mBtnMore.paint.setColor(0xff000000);
        mBtnStudents.paint.setColor(0xff000000);
        mBtnPlan.paint.setColor(0xff000000);

        mBtnMessage.setOnClickListener(this);
        mBtnMore.setOnClickListener(this);
        mBtnStudents.setOnClickListener(this);
        mBtnPlan.setOnClickListener(this);
        mBtnSch.setOnClickListener(this);

        mMeFragment = new MeFragment();
        mMessageFragment = new MessageFragment();
        mMoreFragment = new MoreFragment();
        mPlanFragment = new TeachingPlanFragment();
        mSchFragment = new SchFragment();
        mStudentsFragment = new MyStudentsFragment();

        mPresenter = new SchPresenter(this);
        mManager = getFragmentManager();

        mTabButtonBitmap[0] = BitmapFactory.decodeResource(getResources(), R.drawable.message_);
        mTabButtonBitmap[1] = BitmapFactory.decodeResource(getResources(), R.drawable.message);
        mTabButtonBitmap[4] = BitmapFactory.decodeResource(getResources(), R.drawable.main_);
        mTabButtonBitmap[5] = BitmapFactory.decodeResource(getResources(), R.drawable.main);
        mTabButtonBitmap[2] = BitmapFactory.decodeResource(getResources(), R.drawable.more_);
        mTabButtonBitmap[3] = BitmapFactory.decodeResource(getResources(), R.drawable.more);
        mTabButtonBitmap[8] = BitmapFactory.decodeResource(getResources(), R.drawable.place_);
        mTabButtonBitmap[9] = BitmapFactory.decodeResource(getResources(), R.drawable.place);
        mTabButtonBitmap[6] = BitmapFactory.decodeResource(getResources(), R.drawable.students_);
        mTabButtonBitmap[7] = BitmapFactory.decodeResource(getResources(), R.drawable.students);


        mBtnSch.bitmap = mTabButtonBitmap[4];
        mBtnStudents.bitmap = mTabButtonBitmap[7];
        mBtnMessage.bitmap = mTabButtonBitmap[1];
        mBtnMore.bitmap = mTabButtonBitmap[3];
        mBtnPlan.bitmap = mTabButtonBitmap[9];

        mDatabase = SQLiteDatabase.openDatabase(getCacheDir() + "/test.db", null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public void onClick(View v) {
        mBtnSch.bitmap = mTabButtonBitmap[5];
        mBtnStudents.bitmap = mTabButtonBitmap[7];
        mBtnMessage.bitmap = mTabButtonBitmap[1];
        mBtnMore.bitmap = mTabButtonBitmap[3];
        mBtnPlan.bitmap = mTabButtonBitmap[9];
        mBtnMessage.paint.setColor(0xff000000);
        mBtnMore.paint.setColor(0xff000000);
        mBtnStudents.paint.setColor(0xff000000);
        mBtnPlan.paint.setColor(0xff000000);
        mBtnSch.paint.setColor(0xff000000);

        switch (v.getId()){
            case R.id.button:
                mBtnSch.paint.setColor(0xff00b7ef);
                mBtnSch.bitmap = mTabButtonBitmap[4];
                mManager.beginTransaction().replace(R.id.sch_container, mSchFragment).commitNow();
                break;
            case R.id.button1:
                mBtnStudents.paint.setColor(0xff00b7ef);
                mBtnStudents.bitmap = mTabButtonBitmap[6];

                mManager.beginTransaction().replace(R.id.sch_container,mStudentsFragment).commitNow();

                break;
            case R.id.button2:
                mBtnPlan.paint.setColor(0xff00b7ef);
                mBtnPlan.bitmap = mTabButtonBitmap[8];

                mManager.beginTransaction().replace(R.id.sch_container,mPlanFragment).commitNow();

                break;
            case R.id.button3:
                mBtnMessage.paint.setColor(0xff00b7ef);
                mBtnMessage.bitmap = mTabButtonBitmap[0];

                mManager.beginTransaction().replace(R.id.sch_container,mMessageFragment).commitNow();

                break;
            case  R.id.button4:
                mBtnMore.paint.setColor(0xff00b7ef);
                mBtnMore.bitmap = mTabButtonBitmap[2];

                mManager.beginTransaction().replace(R.id.sch_container,mMoreFragment).commitNow();

                break;
        }

        mBtnMessage.invalidate();
        mBtnMore.invalidate();
        mBtnStudents.invalidate();
        mBtnPlan.invalidate();
        mBtnSch.invalidate();
    }

    public void GoToMeFragment() {
        mManager.beginTransaction().replace(R.id.sch_container,mMeFragment).commitNow();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.close();
    }
}
