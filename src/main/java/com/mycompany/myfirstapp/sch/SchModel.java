package com.mycompany.myfirstapp.sch;

import android.database.Cursor;

import com.mycompany.myfirstapp.utilities.SQLiteInteractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/14.
 */

public class SchModel {
    private final SchPresenter mPresenter;

    public SchModel(SchPresenter schPresenter) {
        mPresenter = schPresenter;
    }

    public void getMyStudentsData() {
        String sql = "select Login.Uname, Student.Stid, Student.Strecord from Login, Student " +
                "where Student.Stuse = Login.User";
        String[] keys = {"key1", "key2", "key3"};

        List<HashMap<String, Object>> data = SQLiteInteractor.getData(mPresenter.mView.mDatabase, sql, keys);
        mPresenter.mView.mStudentsFragment.populateAdapter(data, new String[]{"key1", "key2", "key3"});
    }

    public void getTeachingPlanData() {
        String sql = "select Major.Mname, Course.Kname from Major,Course, Project " +
                "where Project.Mid = Major.Mid and Project.Kid = Course.Kid ";
        String[] keys = {"key1", "key2"};
        List<HashMap<String, Object>> data = SQLiteInteractor.getData(mPresenter.mView.mDatabase, sql, keys);
        mPresenter.mView.mPlanFragment.populateAdapter(data, new String[]{"key1", "key2"});
    }
}
