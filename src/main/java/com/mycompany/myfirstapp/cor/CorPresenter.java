package com.mycompany.myfirstapp.cor;

import org.json.JSONObject;

/**
 * Created by wangz on 2017/4/14.
 */

public class CorPresenter {

    private final CorView mView;
    private final CorModel mModel;

    CorPresenter(CorView corView){
        mView = corView;
        mModel = new CorModel(this, mView);
    }

    public void onResume(){
        mView.showProgressDialog("与服务器通信中");
        mView.changeToResume();
        mModel.pullResumeList();
    }
    public void onMessage(){
        mView.changeToMessage();
    }
    public void onPlace(){
        mView.showProgressDialog("与服务器通信中");
        mView.changeToPlace();
        mModel.pullPlacesList();
    }
    public void onTrainDep(){
        mView.showProgressDialog("与服务器通信中");
        mView.changeToTraining();
        mModel.pullTrainDepList();
    }
    public void onMe() {
        mView.changeToMe();
    }
    public void onIndex() {
        mView.changeToCor();
    }

    public void onResumeClicked(int position) {
        mView.GoToStuDetails();
    }
    public void onMessageClicked(int position) {
        mView.GoToChat();
    }
    public void onPlaceClicked(int position) {
        mView.GoToPlace();
    }
    public void onTrainDepClicked(int position){
        mView.GoToTrain();
    }
    public void onInfor(){
        mView.GoToInfor();
    }
    public void onOffer(){
        mView.GoToOffer();
    }
    public void onCollection(){
        mView.GoToCollection();
    }
    public void onAddClicked() {
        mView.GoToAddPlace();
    }
    public void onAddTeacherClicked() {
        mView.GoToAddTeacher();
    }
}
