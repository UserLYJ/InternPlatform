package com.mycompany.myfirstapp.stu.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.stu.StuPresenter;
import com.mycompany.myfirstapp.stu.StuView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mycompany.myfirstapp.index.Constants.USER_ID;

/**
 * Created by wangz on 2017/4/14.
 */

public class PlaceFragment extends Fragment {

    GridView mList;
    private SimpleAdapter mAdapter;
    StuPresenter mPresenter;
    private Button mAdd;
    int [] mIDList = {R.id.editText7, R.id.editText8, R.id.editText10};
    String[] mKeyList = {"key1", "key2", "key3"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        StuView corView = (StuView) getActivity();
        mPresenter = corView.mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stu_placeslist, container, false);

        mList = (GridView)view.findViewById(R.id.gv_stu_placeslist);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map;
//        String sql = "select Ename, Jname, Isagree from Show_Apply where Stuse = '"+USER_ID+"'";
//        Cursor cursor = mPresenter.mView.mDatabase.rawQuery(sql, null);
//        for(int i = 0; cursor.moveToNext(); i++) {
            map = new HashMap<String, Object>();
            map.put(mKeyList[0], "阿里巴巴");
            map.put(mKeyList[1], "Java工程师");
            map.put(mKeyList[2], "已录用\n");
            list.add(map);
//        }
        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "恒生电子");
        map.put(mKeyList[1], "C++工程师");
        map.put(mKeyList[2], "已录用\n");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "华为");
        map.put(mKeyList[1], "Php工程师");
        map.put(mKeyList[2], "未录用\n");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "网易");
        map.put(mKeyList[1], "游戏开发");
        map.put(mKeyList[2], "未录用\n");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "百度");
        map.put(mKeyList[1], "大数据科学家");
        map.put(mKeyList[2], "已录用\n");
        list.add(map);

        mAdapter = new SimpleAdapter(getContext(), list, R.layout.stu_places_gridview, mKeyList, mIDList);
        mList.setAdapter(mAdapter);

        return view;
    }

//    public void setAdapterToPlaces(JSONObject resJSON) {
//        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
//        String[] numerics = getActivity().getResources().getStringArray(R.array.tempPlace);
//        for(String numeric: numerics){
//            HashMap map = new HashMap();
//            map.put("numeric", numeric);
//            data.add(map);
//        }
//        String[] keys = new String[]{"numeric"};
//        int[] viewIDs = new int[]{R.id.textView5};
//
//        mAdapter = new SimpleAdapter(getActivity(), data, R.layout.gv_data, keys, viewIDs);
//
//        mList.setAdapter(mAdapter);
//    }
}
