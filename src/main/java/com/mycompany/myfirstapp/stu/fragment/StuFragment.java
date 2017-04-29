package com.mycompany.myfirstapp.stu.fragment;

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
import com.mycompany.myfirstapp.stu.StuPresenter;
import com.mycompany.myfirstapp.stu.StuView;

/**
 * Created by wangz on 2017/4/14.
 */

public class StuFragment extends Fragment {
    ImageView mMe;
    SearchView mSearchView;
    StuPresenter mPresenter;


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
        return view;
    }
}
