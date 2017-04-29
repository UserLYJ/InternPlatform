package com.mycompany.myfirstapp.index;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wangz on 2017/4/14.
 */

public class IndexPresenter {
    IndexView mView;
    int identity;
    IndexModel mModel;

    IndexPresenter(IndexView indexView, SQLiteDatabase mDatabase){
        mView = indexView;
        mModel = new IndexModel(this, mDatabase);
    }
    public void onSignIn(String username, String password){
        String realPassword;

        switch (identity){
            case 0:
//                realPassword = mModel.getStuPassword(username);
//                if(!password.equals(realPassword)){
//                    mView.showToast("用户名或密码不正确");
//                    break;
//                }
                mView.GoToStuView();
                break;
            case 1:
//                realPassword = mModel.getCorPassword(username);
//                if(!password.equals(realPassword)){
//                    mView.showToast("用户名或密码不正确");
//                    break;
//                }
                mView.GoToCorView();
                break;
            case 2:
//                realPassword = mModel.getSchPassword(username);
//                if(!password.equals(realPassword)){
//                    mView.showToast("用户名或密码不正确");
//                    break;
//                }
                mView.GoToSchView();
                break;
        }
    }
    public void onSignUp(){}
    public void onStuPicked(){
        identity = 0;
    }
    public void onCorPicked(){
        identity = 1;
    }
    public void onSchPicked(){
        identity = 2;
    }
}
