package com.mycompany.myfirstapp.stu.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.stu.StuPresenter;
import com.mycompany.myfirstapp.stu.StuView;
import com.mycompany.myfirstapp.stu.fragment.message.ChatView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/14.
 */

public class MessageFragment extends Fragment {

    GridView mList;
    private SimpleAdapter mAdapter;
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
        View view = inflater.inflate(R.layout.page_messagelist, container, false);
        mList = (GridView)view.findViewById(R.id.gv_messagelist);
        //// TODO: 2017/4/16 临时的消息列表
        setAdapterToMessage(null);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ChatView.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void setAdapterToMessage(JSONObject resJSON) {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        String[] numerics = getActivity().getResources().getStringArray(R.array.tempChat);
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
