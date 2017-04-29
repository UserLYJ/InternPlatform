package com.mycompany.myfirstapp.utilities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/29.
 */

public class SQLiteInteractor {
    public static List<HashMap<String, Object>> getData(SQLiteDatabase mDatabase, String sql, String[] keys){
        Cursor cursor = mDatabase.rawQuery(sql, null);
        if(cursor.getCount() == 0){
            return null;
        }

        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

        while (cursor.moveToNext()){
            HashMap<String, Object> map = new HashMap<String, Object>();
            for(int i = 0; i < keys.length; i++){
                map.put(keys[i], cursor.getString(i));
            }
            data.add(map);
        }
        cursor.close();
        return data;
    };
}
