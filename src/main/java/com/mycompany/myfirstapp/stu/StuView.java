package com.mycompany.myfirstapp.stu;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.stu.fragment.MeFragment;
import com.mycompany.myfirstapp.stu.fragment.MessageFragment;
import com.mycompany.myfirstapp.stu.fragment.PlaceFragment;
import com.mycompany.myfirstapp.stu.fragment.ResumeFragment;
import com.mycompany.myfirstapp.stu.fragment.StuFragment;
import com.mycompany.myfirstapp.stu.fragment.SubmitFragment;
import com.mycompany.myfirstapp.utilities.TabButton;

/**
 * Created by wangz on 2017/4/14.
 */

public class StuView extends AppCompatActivity implements View.OnClickListener{

    TabButton mResume, mJob, mMessage, mSubmit, mIndex;
    ImageButton mMe;
    StuFragment mStuFragment;
    ResumeFragment mResumeFragment;
    MessageFragment mMessageFragment;
    private FragmentManager mManager;
    public StuPresenter mPresenter;
    private SubmitFragment mSubmitFragment;
    private PlaceFragment mJobFragment;
    private MeFragment mMeFragment;
    Bitmap[] mTabButtonBitmap = new Bitmap[10];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initiate();

        mManager.beginTransaction().replace(R.id.cor_container, mStuFragment).commitNow();
    }

    private void initiate() {
        setContentView(R.layout.stu_main_nav);

        mResume = (TabButton)findViewById(R.id.button);
        mJob = (TabButton)findViewById(R.id.button1);
        mMessage = (TabButton)findViewById(R.id.button2);
        mSubmit = (TabButton)findViewById(R.id.button3);
        mIndex = (TabButton)findViewById(R.id.button4);

        mResume.setOnClickListener(this);
        mJob.setOnClickListener(this);
        mMessage.setOnClickListener(this);
        mSubmit.setOnClickListener(this);
        mIndex.setOnClickListener(this);

        mResume.TAG = "我的简历";
        mJob.TAG = "我的求职";
        mMessage.TAG = "我的消息";
        mSubmit.TAG = "职位推送";
        mIndex.TAG = "首页";
        mResume.paint.setColor(0xff000000);
        mJob.paint.setColor(0xff000000);
        mMessage.paint.setColor(0xff000000);
        mSubmit.paint.setColor(0xff000000);

        mManager = getFragmentManager();
        mMessageFragment = new MessageFragment();
        mResumeFragment = new ResumeFragment();
        mStuFragment = new StuFragment();
        mSubmitFragment = new SubmitFragment();
        mJobFragment = new PlaceFragment();
        mMeFragment = new MeFragment();

        mPresenter = new StuPresenter(this);

        mTabButtonBitmap[0] = BitmapFactory.decodeResource(getResources(), R.drawable.message_);
        mTabButtonBitmap[1] = BitmapFactory.decodeResource(getResources(), R.drawable.message);
        mTabButtonBitmap[2] = BitmapFactory.decodeResource(getResources(), R.drawable.stu_train_);
        mTabButtonBitmap[3] = BitmapFactory.decodeResource(getResources(), R.drawable.stu_train);
        mTabButtonBitmap[4] = BitmapFactory.decodeResource(getResources(), R.drawable.main_);
        mTabButtonBitmap[5] = BitmapFactory.decodeResource(getResources(), R.drawable.main);
        mTabButtonBitmap[6] = BitmapFactory.decodeResource(getResources(), R.drawable.push_);
        mTabButtonBitmap[7] = BitmapFactory.decodeResource(getResources(), R.drawable.push);
        mTabButtonBitmap[8] = BitmapFactory.decodeResource(getResources(), R.drawable.resume_);
        mTabButtonBitmap[9] = BitmapFactory.decodeResource(getResources(), R.drawable.resume);

        mIndex.bitmap = mTabButtonBitmap[4];
        mMessage.bitmap = mTabButtonBitmap[1];
        mJob.bitmap = mTabButtonBitmap[3];
        mResume.bitmap = mTabButtonBitmap[9];
        mSubmit.bitmap = mTabButtonBitmap[7];
    }

    @Override
    public void onClick(View v) {
        mIndex.bitmap = mTabButtonBitmap[5];
        mMessage.bitmap = mTabButtonBitmap[1];
        mJob.bitmap = mTabButtonBitmap[3];
        mResume.bitmap = mTabButtonBitmap[9];
        mSubmit.bitmap = mTabButtonBitmap[7];
        mResume.paint.setColor(0xff000000);
        mJob.paint.setColor(0xff000000);
        mMessage.paint.setColor(0xff000000);
        mSubmit.paint.setColor(0xff000000);
        mIndex.paint.setColor(0xff000000);

        switch (v.getId()){
            case R.id.button:
                mManager.beginTransaction().replace(R.id.cor_container, mResumeFragment).commitNow();
                mResume.paint.setColor(0xff00b7ef);
                mResume.bitmap = mTabButtonBitmap[8];

                break;
            case R.id.button1:
                mManager.beginTransaction().replace(R.id.cor_container, mJobFragment).commitNow();
                mJob.paint.setColor(0xff00b7ef);
                mJob.bitmap = mTabButtonBitmap[2];

                break;
            case R.id.button2:
                mManager.beginTransaction().replace(R.id.cor_container, mMessageFragment).commitNow();
                mMessage.paint.setColor(0xff00b7ef);
                mMessage.bitmap = mTabButtonBitmap[0];

                break;
            case R.id.button3:
                mManager.beginTransaction().replace(R.id.cor_container, mSubmitFragment).commitNow();
                mSubmit.paint.setColor(0xff00b7ef);
                mSubmit.bitmap = mTabButtonBitmap[6];

                break;
            case R.id.button4:
                mManager.beginTransaction().replace(R.id.cor_container, mStuFragment).commitNow();
                mIndex.paint.setColor(0xff00b7ef);
                mIndex.bitmap = mTabButtonBitmap[4];

                break;
        }

        mResume.invalidate();
        mJob.invalidate();
        mSubmit.invalidate();
        mMessage.invalidate();
        mIndex.invalidate();
    }

    public void GoToMeFragment() {
        mManager.beginTransaction().replace(R.id.cor_container, mMeFragment).commitNow();

    }
}
