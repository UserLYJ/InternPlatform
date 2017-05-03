package com.mycompany.myfirstapp.cor;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.fragment.CorFragment;
import com.mycompany.myfirstapp.cor.fragment.MeFragment;
import com.mycompany.myfirstapp.cor.fragment.MessageFragment;
import com.mycompany.myfirstapp.cor.fragment.PlaceFragment;
import com.mycompany.myfirstapp.cor.fragment.ResumeFragment;
import com.mycompany.myfirstapp.cor.fragment.TrainingDepFragment;
import com.mycompany.myfirstapp.cor.fragment.me.CollectionView;
import com.mycompany.myfirstapp.cor.fragment.me.InforView;
import com.mycompany.myfirstapp.cor.fragment.me.OfferView;
import com.mycompany.myfirstapp.cor.fragment.message.ChatView;
import com.mycompany.myfirstapp.cor.fragment.place.AddPlaceView;
import com.mycompany.myfirstapp.cor.fragment.place.PlaceView;
import com.mycompany.myfirstapp.cor.fragment.resume.StudentDetailsView;
import com.mycompany.myfirstapp.cor.fragment.trainingdep.AddTeacherView;
import com.mycompany.myfirstapp.cor.fragment.trainingdep.TrainingView;
import com.mycompany.myfirstapp.utilities.TabButton;

import org.json.JSONObject;

/**
 * Created by wangz on 2017/4/14.
 */

public class CorView extends AppCompatActivity implements View.OnClickListener{

    public CorPresenter mPresenter;
    MessageFragment mMessageFragment;
    PlaceFragment mPlaceFragment;
    ResumeFragment mResumeFragment;
    TrainingDepFragment mTrainingDepFragment;
    CorFragment mCorFragment;
    FragmentManager mFragmentManager;
    private MeFragment mMeFragment;
    private ProgressDialog mDialog;
    TabButton mResume, mMessage, mPlace, mTrainDep, mIndex;
    Bitmap[] mTabButtonBitmap = new Bitmap[10];
    public SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initiate();
        changeToCor();
    }

    private void initiate() {
        setContentView(R.layout.cor_main_nav);
        mResume = (TabButton) findViewById(R.id.btn_cor_getresumes);
        mMessage = (TabButton) findViewById(R.id.btn_cor_message);
        mPlace = (TabButton) findViewById(R.id.btn_cor_places);
        mTrainDep = (TabButton) findViewById(R.id.btn_cor_traindep);
        mIndex = (TabButton) findViewById(R.id.btn_cor_index);

        mResume.setOnClickListener(this);
        mMessage.setOnClickListener(this);
        mPlace.setOnClickListener(this);
        mTrainDep.setOnClickListener(this);
        mIndex.setOnClickListener(this);

        mPresenter = new CorPresenter(this);

        mMessageFragment = new MessageFragment();
        mPlaceFragment = new PlaceFragment();
        mResumeFragment = new ResumeFragment();
        mTrainingDepFragment = new TrainingDepFragment();
        mCorFragment = new CorFragment();
        mMeFragment = new MeFragment();

        mFragmentManager = getFragmentManager();

        mTabButtonBitmap[0] = BitmapFactory.decodeResource(getResources(), R.drawable.message_);
        mTabButtonBitmap[1] = BitmapFactory.decodeResource(getResources(), R.drawable.message);
        mTabButtonBitmap[2] = BitmapFactory.decodeResource(getResources(), R.drawable.training_);
        mTabButtonBitmap[3] = BitmapFactory.decodeResource(getResources(), R.drawable.training);
        mTabButtonBitmap[4] = BitmapFactory.decodeResource(getResources(), R.drawable.main_);
        mTabButtonBitmap[5] = BitmapFactory.decodeResource(getResources(), R.drawable.main);
        mTabButtonBitmap[6] = BitmapFactory.decodeResource(getResources(), R.drawable.place_);
        mTabButtonBitmap[7] = BitmapFactory.decodeResource(getResources(), R.drawable.place);
        mTabButtonBitmap[8] = BitmapFactory.decodeResource(getResources(), R.drawable.resume_);
        mTabButtonBitmap[9] = BitmapFactory.decodeResource(getResources(), R.drawable.resume);


        mIndex.TAG = "主页";
        mIndex.bitmap = mTabButtonBitmap[4];
        mIndex.paint.setColor(0xff00b7ef);

        mResume.TAG = "简历";
        mResume.bitmap = mTabButtonBitmap[9];
        mResume.paint.setColor(0xff000000);

        mPlace.TAG = "职位";
        mPlace.bitmap = mTabButtonBitmap[7];
        mPlace.paint.setColor(0xff000000);

        mMessage.TAG = "聊天";
        mMessage.bitmap = mTabButtonBitmap[1];
        mMessage.paint.setColor(0xff000000);

        mTrainDep.TAG = "培训部";
        mTrainDep.bitmap = mTabButtonBitmap[3];
        mTrainDep.paint.setColor(0xff000000);

        mDatabase = SQLiteDatabase.openDatabase(getCacheDir() + "/test.db", null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void changeToCor(){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.cor_container, mCorFragment);
        transaction.addToBackStack(null).commit();
    }
    public void changeToMessage(){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.cor_container, mMessageFragment);
        //transaction.addToBackStack(null).commit();
        transaction.commitNow();
    }
    public void changeToPlace(){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.cor_container, mPlaceFragment);
        //transaction.addToBackStack(null).commit();
        transaction.commitNow();
    }
    public void changeToResume(){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.cor_container, mResumeFragment);
        //transaction.addToBackStack(null).commit();
        //这种提交是同步的
        //// TODO: 2017/4/16 this is not good
        transaction.commitNow();
    }
    public void changeToTraining(){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.cor_container, mTrainingDepFragment);
        //transaction.addToBackStack(null).commit();
        transaction.commitNow();
    }

    public void changeToMe() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.cor_container, mMeFragment);
        transaction.addToBackStack(null).commit();
    }

    public void showProgressDialog(String content) {
        mDialog = ProgressDialog.show(this, null, content, true, false);
    }
    public void dismissProgressDialog(){
        mDialog.dismiss();
    }

    public void GoToStuDetails(String[] details) {
        Intent intent = new Intent(getApplicationContext(), StudentDetailsView.class);
        intent.putExtra("data", details);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        mPlace.bitmap = mTabButtonBitmap[7];
        mIndex.bitmap = mTabButtonBitmap[5];
        mResume.bitmap = mTabButtonBitmap[9];
        mMessage.bitmap = mTabButtonBitmap[1];
        mTrainDep.bitmap = mTabButtonBitmap[3];

        mPlace.paint.setColor(0xff000000);
        mIndex.paint.setColor(0xff000000);
        mResume.paint.setColor(0xff000000);
        mMessage.paint.setColor(0xff000000);
        mTrainDep.paint.setColor(0xff000000);

        switch (v.getId()){
            case R.id.btn_cor_getresumes:
                mPresenter.onResume();
                mResume.bitmap = mTabButtonBitmap[8];
                mResume.paint.setColor(0xff00b7ef);
                break;
            case R.id.btn_cor_message:
                mPresenter.onMessage();
                mMessage.bitmap = mTabButtonBitmap[0];
                mMessage.paint.setColor(0xff00b7ef);
                break;
            case R.id.btn_cor_places:
                mPresenter.onPlace();
                mPlace.bitmap = mTabButtonBitmap[6];
                mPlace.paint.setColor(0xff00b7ef);
                break;
            case R.id.btn_cor_traindep:
                mPresenter.onTrainDep();
                mTrainDep.bitmap = mTabButtonBitmap[2];
                mTrainDep.paint.setColor(0xff00b7ef);
                break;
            case R.id.btn_cor_index:
                mPresenter.onIndex();
                mIndex.bitmap = mTabButtonBitmap[4];
                mIndex.paint.setColor(0xff00b7ef);
        }

        mPlace.invalidate();
        mTrainDep.invalidate();
        mMessage.invalidate();
        mResume.invalidate();
        mIndex.invalidate();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void GoToChat() {
        Intent intent = new Intent(this, ChatView.class);
        startActivity(intent);
    }

    public void GoToPlace() {
        Intent intent = new Intent(this, PlaceView.class);
        startActivity(intent);
    }

    public void GoToTrain() {
        Intent intent = new Intent(this, TrainingView.class);
        startActivity(intent);
    }

    public void GoToInfor() {
        Intent intent = new Intent(this, InforView.class);
        startActivity(intent);
    }

    public void GoToOffer() {
        Intent intent = new Intent(this, OfferView.class);
        startActivity(intent);
    }

    public void GoToCollection() {
        Intent intent = new Intent(this, CollectionView.class);
        startActivity(intent);
    }

    public void GoToAddPlace() {
        Intent intent = new Intent(this, AddPlaceView.class);
        startActivity(intent);
    }

    public void GoToAddTeacher() {
        startActivity(new Intent(this, AddTeacherView.class));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.close();
    }
}
