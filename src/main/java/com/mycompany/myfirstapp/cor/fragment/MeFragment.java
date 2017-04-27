package com.mycompany.myfirstapp.cor.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.sch.SchPresenter;
import com.mycompany.myfirstapp.sch.SchView;

/**
 * Created by wangz on 2017/4/16.
 */

public class MeFragment extends Fragment implements View.OnClickListener{

    ImageView mInfor, mOffer, mCollection;
    ImageView [] mImageView = new ImageView[5];
    CorPresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CorView corView = (CorView) getActivity();
        mPresenter = corView.mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cor_presonal_, container, false);

        mCollection = (ImageView) view.findViewById(R.id.imageView4);
        mInfor = (ImageView) view.findViewById(R.id.imageView5);
        mOffer = (ImageView) view.findViewById(R.id.imageView2);
        mImageView[0] = (ImageView)view.findViewById(R.id.imageView6);

        mCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onCollection();
            }
        });
        mInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onInfor();
            }
        });
        mOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onOffer();
            }
        });
        mImageView[0].setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView6:

                break;
        }
    }
}
