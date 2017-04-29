package com.mycompany.myfirstapp.index;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wangz on 2017/4/14.
 */

public class IndexModel {

    private final SQLiteDatabase mDatabase;
    IndexPresenter mPresenter;

    IndexModel(IndexPresenter presenter, SQLiteDatabase mDatabase){
        mPresenter = presenter;
        this.mDatabase = mDatabase;
    }
    public String getStuPassword(String username){
        String sql = "select Upwd from Login where Uname = '"+username+"' and Uport = '学生'";
        Cursor cursor = mDatabase.rawQuery(sql, null);
        cursor.moveToNext();
        if(cursor.getCount() == 0)
            return "no records";
        return cursor.getString(cursor.getColumnIndex("Upwd"));
    }
    public String getCorPassword(String username){
        return "456";
    }
    public String getSchPassword(String username){
        return "789";
    }
}

