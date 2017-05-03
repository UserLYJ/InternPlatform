package com.mycompany.myfirstapp.cor.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.cor.fragment.me.AddPlaceView;
import com.mycompany.myfirstapp.cor.fragment.me.FeedbackView;
import com.mycompany.myfirstapp.sch.SchPresenter;
import com.mycompany.myfirstapp.sch.SchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mycompany.myfirstapp.index.Constants.USER_ID;

/**
 * Created by wangz on 2017/4/16.
 */

public class MeFragment extends Fragment implements View.OnClickListener{

    ImageView mInfor, mOffer, mCollection;
    ImageView [] mImageView = new ImageView[5];
    CorPresenter mPresenter;
    int [] mIDList = {R.id.textView10, R.id.textView20, R.id.textView32};
    String[] mKeyList = {"key1", "key2", "key3"};
    View mDialog;
    GridView mGridView;
    SimpleAdapter mAdapter;

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
        mImageView[1] = (ImageView) view.findViewById(R.id.imageView3);

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
        mImageView[1].setOnClickListener(this);

        mDialog = inflater.inflate(R.layout.cor_feedback_dialog, container, false);
        mGridView = (GridView) mDialog.findViewById(R.id.feedback_list);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), FeedbackView.class));
            }
        });

        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map;
//        String sql = "";
//        Cursor cursor = mPresenter.mView.mDatabase.rawQuery(sql, new String[]{USER_ID});
            map = new HashMap<String, Object>();
            map.put(mKeyList[0], "张三");
            map.put(mKeyList[1], "计算机科学与技术");
            map.put(mKeyList[2], "Java工程师\n");
            list.add(map);

        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "李四");
        map.put(mKeyList[1], "计算机科学与技术");
        map.put(mKeyList[2], "Php工程师\n");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "王五");
        map.put(mKeyList[1], "医学信息工程");
        map.put(mKeyList[2], "C++工程师\n");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(mKeyList[0], "张三");
        map.put(mKeyList[1], "医学信息工程");
        map.put(mKeyList[2], "C#工程师\n");
        list.add(map);

        mAdapter = new SimpleAdapter(getContext(), list, R.layout.cor_feedback_dialog_entry, mKeyList, mIDList);
        mGridView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView6:
                startActivity(new Intent(getContext(), AddPlaceView.class));
                break;
            case R.id.imageView3:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(mGridView);
                builder.show();
                break;
        }
    }
}
