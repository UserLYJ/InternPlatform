package com.mycompany.myfirstapp.sch.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mycompany.myfirstapp.R;

/**
 * Created by wangz on 2017/4/14.
 */

public class TeachingPlanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sch_teachplanlist, container, false);
        return view;
    }
}
