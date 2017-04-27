package com.mycompany.myfirstapp.cor.fragment;

import android.app.Fragment;
import android.content.Context;
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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/14.
 */

public class PlaceFragment extends Fragment {

    GridView mList;
    private SimpleAdapter mAdapter;
    CorPresenter mPresenter;
    private Button mAdd;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CorView corView = (CorView) getActivity();
        mPresenter = corView.mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cor_myplaces, container, false);

        mAdd = (Button)view.findViewById(R.id.btn_cor_addplace);
        mList = (GridView)view.findViewById(R.id.gv_cor_myplacellist);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.onPlaceClicked(position);
            }
        });
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onAddClicked();
            }
        });
        return view;
    }

    public void setAdapterToPlaces(JSONObject resJSON) {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        String[] numerics = getActivity().getResources().getStringArray(R.array.tempPlace);
        for(String numeric: numerics){
            HashMap map = new HashMap();
            map.put("numeric", numeric);
            data.add(map);
        }
        String[] keys = new String[]{"numeric"};
        int[] viewIDs = new int[]{R.id.textView5};

        mAdapter = new SimpleAdapter(getActivity(), data, R.layout.gv_data, keys, viewIDs);

        mList.setAdapter(mAdapter);
    }
}