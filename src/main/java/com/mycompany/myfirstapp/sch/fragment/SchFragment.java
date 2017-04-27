package com.mycompany.myfirstapp.sch.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.sch.SchPresenter;
import com.mycompany.myfirstapp.sch.SchView;

/**
 * Created by wangz on 2017/4/14.
 */

public class SchFragment extends Fragment {
    ImageView mMe;
    SearchView mSearchView;
    SchPresenter mPresenter;

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
        return view;
    }
}
