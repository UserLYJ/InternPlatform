package com.mycompany.myfirstapp.sch.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.sch.SchView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/14.
 */

public class TeachingPlanFragment extends Fragment {
    GridView mPlanLists;
    SchView mView;
    int[] idLists = {R.id.textView5, R.id.textView9};
    SimpleAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mView = (SchView)getActivity();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sch_teachplanlist, container, false);
        mPlanLists = (GridView)view.findViewById(R.id.gv_sch_planlist);
        mPlanLists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mView.mPresenter.onCreateTeachingPlan();
        return view;
    }
    public void populateAdapter(List<HashMap<String, Object>> data, String[] keys){
        mAdapter = new SimpleAdapter(mView, data, R.layout.gv_data, keys, idLists);
        mPlanLists.setAdapter(mAdapter);
    }
}
