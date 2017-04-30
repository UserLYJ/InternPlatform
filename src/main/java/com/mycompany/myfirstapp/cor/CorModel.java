package com.mycompany.myfirstapp.cor;

import android.database.Cursor;

import com.mycompany.myfirstapp.utilities.JSONInteractor;

import org.json.JSONObject;

import static com.mycompany.myfirstapp.index.Constants.SERVER_URL;

/**
 * Created by wangz on 2017/4/14.
 */

public class CorModel {

    CorPresenter mPresenter;
    CorView mView;

    CorModel(CorPresenter presenter, CorView view){
        mPresenter = presenter;
        mView = view;
    }

    public void pullResumeList() {
        JSONInteractor interactor = new JSONInteractor();

        interactor.setRequestJSON(null);

        interactor.setOnCompleteListener(new JSONInteractor.OnCompleteListener() {
            @Override
            public void onComplete(final JSONObject resJSON) {
                //need update UI on UI thread
                mView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.dismissProgressDialog();
                        mView.mResumeFragment.setAdapterToResume(resJSON);
                    }
                });
            }
        });

        interactor.getResponseJSON(SERVER_URL + "resumelist");
    }

    public void pullPlacesList() {
        JSONInteractor interactor = new JSONInteractor();

        interactor.setRequestJSON(null);

        interactor.setOnCompleteListener(new JSONInteractor.OnCompleteListener() {
            @Override
            public void onComplete(final JSONObject resJSON) {
                //need update UI on UI thread
                mView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.dismissProgressDialog();
                        mView.mPlaceFragment.setAdapterToPlaces(resJSON);
                    }
                });
            }
        });

        interactor.getResponseJSON(SERVER_URL + "joblist");
    }

    public void pullTrainDepList() {
        JSONInteractor interactor = new JSONInteractor();

        interactor.setRequestJSON(null);

        interactor.setOnCompleteListener(new JSONInteractor.OnCompleteListener() {
            @Override
            public void onComplete(final JSONObject resJSON) {
                //need update UI on UI thread
                mView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.dismissProgressDialog();
                        mView.mTrainingDepFragment.setAdapterToTrainingDep(resJSON);
                    }
                });
            }
        });

        interactor.getResponseJSON(SERVER_URL + "trainingdepartmentlist");
    }

    public String[] getResumeDetails(String stuse) {
        String sql = "select Login.Uname, Major.Mname, Honor.Hname from Login, Major, Honor, Student " +
                "where Login.User = ? and Student.Stuse = ? and Student.Mid = Major.Mid " +
                "and Honor.Stuse = ?";
        Cursor cursor = mView.mDatabase.rawQuery(sql, new String[]{stuse, stuse, stuse});
        cursor.moveToNext();

        String[] data = new String[5];
        data[0] = cursor.getString(0);
        data[1] = cursor.getString(1);
        data[2] = "I don't know where they are";
        data[3] = cursor.getString(2);
        data[4] = "I don't know where they are";

        return data;
    }
}
