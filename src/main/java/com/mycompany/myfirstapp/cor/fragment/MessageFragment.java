package com.mycompany.myfirstapp.cor.fragment;

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
import com.mycompany.myfirstapp.sch.SchPresenter;
import com.mycompany.myfirstapp.sch.SchView;
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

        HashMap map = new HashMap();
        map.put("key1", numerics[0]);
        map.put("key2", "张三");
        data.add(map);

        map = new HashMap();
        map.put("key1", numerics[1]);
        map.put("key2", "李四");
        data.add(map);

        String[] keys = new String[]{"key1", "key2"};
        int[] viewIDs = new int[]{R.id.textView5, R.id.textView9};

        mAdapter = new SimpleAdapter(getActivity(), data, R.layout.gv_data, keys, viewIDs);

        mList.setAdapter(mAdapter);
    }

}
