package com.mycompany.myfirstapp.sch.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.sch.SchPresenter;
import com.mycompany.myfirstapp.sch.SchView;
import com.mycompany.myfirstapp.sch.fragment.sch.GiveNumberView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/14.
 */

public class SchFragment extends Fragment {
    ImageView mMe;
    SearchView mSearchView;
    SchPresenter mPresenter;
    GridView mList;
    int[] idLists = {R.id.textView25, R.id.textView24, R.id.textView26};
    SimpleAdapter mAdapter;
    String []keys = {"key1", "key2", "key3"};
    Button mPublish;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = ((SchView)getActivity()).mPresenter;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sch_main, container, false);

        mMe = (ImageView) view.findViewById(R.id.sch_presonal);
        mMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onMe();
            }
        });

        mList = (GridView) view.findViewById(R.id.gv_sch_places);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), GiveNumberView.class));
            }
        });

//        String sql = "select Enterprise.Ename, Job.Jname, Assignment.Asnum " +
//                "from Enterprise, Job, Assignment, Instructor, Recruitment " +
//                "where Instructor.Scuse = '"+USER_ID+"' and Instructor.Cid = Assignment.Cid " +
//                "and Assignment.Rid = Recruitment.Rid and Recruitment.Jid = Job.Jid " +
//                "and Recruitment.Eid = Enterprise.Eid";
//        Log.i(TAG, "onCreateView: "+sql);
//        List<HashMap<String, Object>> data = SQLiteInteractor.getData(mPresenter.mView.mDatabase, sql, keys);
        List<HashMap<String, Object>> data = getAdapterData();
        mAdapter = new SimpleAdapter(getContext(), data, R.layout.sch_myplaces_module, keys, idLists);
        mList.setAdapter(mAdapter);

        return view;
    }
    List<HashMap<String, Object>> getAdapterData(){
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(keys[0], "浙江中医药大学");
        map.put(keys[1],"医学信息工程");
        map.put(keys[2],"5/10");
        data.add(map);
        return data;
    }
}
