package com.mycompany.myfirstapp.stu;

/**
 * Created by wangz on 2017/4/14.
 */

public class StuPresenter {
    public final StuView mView;
    private final StuModel mModel;

    public StuPresenter(StuView mView) {
        this.mView = mView;
        this.mModel = new StuModel(this);
    }

    public void onMe() {
        mView.GoToMeFragment();
    }
}
