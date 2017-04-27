package com.mycompany.myfirstapp.cor.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;

/**
 * Created by wangz on 2017/4/14.
 */

public class CorFragment extends Fragment implements View.OnClickListener{

    ImageView mMe;
    SearchView mSearchView;
    CorPresenter mPresenter;
    GridView mRecvPlan;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = ((CorView)getActivity()).mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cor_main, container, false);

        mSearchView = (SearchView)view.findViewById(R.id.cor_searchView);
        mMe = (ImageView) view.findViewById(R.id.cor_presonal);
        mMe.setOnClickListener(this);
        mRecvPlan = (GridView) view.findViewById(R.id.gv_cor_students);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cor_presonal:
                mPresenter.onMe();
                break;
        }
    }
}
