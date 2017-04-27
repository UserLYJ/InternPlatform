package com.mycompany.myfirstapp.stu.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.stu.StuPresenter;
import com.mycompany.myfirstapp.stu.StuView;

/**
 * Created by wangz on 2017/4/16.
 */

public class MeFragment extends Fragment {

    StuPresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        StuView corView = (StuView) getActivity();
        mPresenter = corView.mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stu_presonal_, container, false);
        return view;
    }
}
