package com.mycompany.myfirstapp.sch;

import com.mycompany.myfirstapp.stu.StuModel;
import com.mycompany.myfirstapp.stu.StuView;

/**
 * Created by wangz on 2017/4/14.
 */

public class SchPresenter {
    public final SchView mView;
    private final SchModel mModel;

    public SchPresenter(SchView mView) {
        this.mView = mView;
        this.mModel = new SchModel(this);
    }
    public void onMe() {
        mView.GoToMeFragment();
    }

    public void onCreateMyStudents() {
        mModel.getMyStudentsData();
    }

    public void onCreateTeachingPlan() {
        mModel.getTeachingPlanData();
    }
}
