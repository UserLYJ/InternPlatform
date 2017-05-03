package com.mycompany.myfirstapp.stu.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.stu.StuPresenter;
import com.mycompany.myfirstapp.stu.StuView;
import com.mycompany.myfirstapp.stu.fragment.stu.WanttodoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/14.
 */

public class StuFragment extends Fragment {
    ImageView mMe;
    SearchView mSearchView;
    StuPresenter mPresenter;
    GridView mList;
    int[] idLists = {R.id.textView25, R.id.textView24, R.id.textView26};
    SimpleAdapter mAdapter;
    String []keys = {"key1", "key2", "key3"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = ((StuView)getActivity()).mPresenter;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stu_main, container, false);
        mMe = (ImageView) view.findViewById(R.id.stu_presonal);
        mMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onMe();
            }
        });

        mList = (GridView) view.findViewById(R.id.gv_corlist);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), WanttodoView.class));
            }
        });

        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(keys[0], "阿里巴巴");
        map.put(keys[1],"Java开发实习生");
        map.put(keys[2],"5/10");
        data.add(map);
        mAdapter = new SimpleAdapter(getContext(), data, R.layout.stu_main_module, keys, idLists);
        mList.setAdapter(mAdapter);

        return view;
    }

}
