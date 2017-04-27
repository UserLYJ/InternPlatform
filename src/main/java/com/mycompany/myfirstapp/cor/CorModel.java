package com.mycompany.myfirstapp.cor;

import com.mycompany.myfirstapp.utilities.JSONInteractor;

import org.json.JSONObject;

import static com.mycompany.myfirstapp.cor.Constants.SERVER_URL;

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
}
