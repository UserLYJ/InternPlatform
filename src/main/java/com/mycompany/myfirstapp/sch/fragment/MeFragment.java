package com.mycompany.myfirstapp.sch.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.sch.SchPresenter;
import com.mycompany.myfirstapp.sch.SchView;
import com.mycompany.myfirstapp.sch.fragment.me.PushTrainView;

/**
 * Created by wangz on 2017/4/16.
 */

public class MeFragment extends Fragment implements View.OnClickListener{

    ImageView mInternPlan;
    SchPresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        SchView corView = (SchView)getActivity();
        mPresenter = corView.mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sch_presonal_, container, false);

        mInternPlan = (ImageView) view.findViewById(R.id.imageView5);
        mInternPlan.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView5:
                Intent intent = new Intent(getContext(), PushTrainView.class);
                startActivity(intent);
                break;
        }
    }
}
