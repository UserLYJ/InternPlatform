package com.mycompany.myfirstapp.index;

/**
 * Created by wangz on 2017/4/14.
 */

public class IndexModel {

    IndexPresenter mPresenter;

    IndexModel(IndexPresenter presenter){
        mPresenter = presenter;
    }
    public String getStuPassword(String username){
        return "123";
    }
    public String getCorPassword(String username){
        return "456";
    }
    public String getSchPassword(String username){
        return "789";
    }
}

