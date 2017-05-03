package com.mycompany.myfirstapp.stu.fragment;

import android.app.Fragment;
import android.content.Intent;
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
import com.mycompany.myfirstapp.stu.StuPresenter;
import com.mycompany.myfirstapp.stu.fragment.stu.WanttodoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/18.
 */

public class SubmitFragment extends Fragment {

    GridView mList;
    private SimpleAdapter mAdapter;
    StuPresenter mPresenter;
    private Button mAdd;
    int [] mIDList = {R.id.textView35, R.id.textView39, R.id.textView40};
    String[] mKeyList = {"key1", "key2", "key3"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stu_fragment_submit, container, false);
        mList = (GridView)view.findViewById(R.id.gridView);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), WanttodoView.class));
            }
        });

        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map;
        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "恒生电子");
        map.put(mKeyList[1], "C++工程师");
        map.put(mKeyList[2], "C++\n");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "阿里巴巴");
        map.put(mKeyList[1], "Java工程师");
        map.put(mKeyList[2], "Java\n");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "华为");
        map.put(mKeyList[1], "Php工程师");
        map.put(mKeyList[2], "\n");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "海康威视");
        map.put(mKeyList[1], "前端工程师");
        map.put(mKeyList[2], "HTML+CSS+JS\n");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "网易");
        map.put(mKeyList[1], "后端工程师");
        map.put(mKeyList[2], "HSS\n");
        list.add(map);

        mAdapter = new SimpleAdapter(getContext(), list, R.layout.stu_fragment_entry, mKeyList, mIDList);
        mList.setAdapter(mAdapter);
        return view;
    }
}
