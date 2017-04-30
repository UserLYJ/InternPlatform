package com.mycompany.myfirstapp.cor.fragment;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
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
import com.mycompany.myfirstapp.utilities.SQLiteInteractor;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangz on 2017/4/14.
 */

public class ResumeFragment extends Fragment {

    private CorPresenter mPresenter;
    private SimpleAdapter mAdapter;
    private GridView mResumeList;
    private boolean isAttached = false;
    int[] idLists = {R.id.textView5, R.id.textView9, R.id.textView8};
    String[] Stuse;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CorView corView = (CorView) getActivity();
        mPresenter = corView.mPresenter;

        isAttached = true;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cor_acceptresumes, container, false);

        mResumeList = (GridView)view.findViewById(R.id.gv_acceptResumes);

        String sql = "select Login.Uname, Job.Jname, Apply.isApply from Login, Job, Apply, Recruitment " +
                "where Apply.stuse = Login.User and Apply.Rid = Recruitment.Rid and Recruitment.Jid = Job.Jid";
        String []keys = {"key1", "key2", "key3"};
        List<HashMap<String, Object>> data = SQLiteInteractor.getData(mPresenter.mView.mDatabase, sql, keys);
        mAdapter = new SimpleAdapter(getContext(), data, R.layout.gv_data, keys, idLists);
        mResumeList.setAdapter(mAdapter);

        sql = "select Apply.Stuse from Apply";
        Cursor cursor = mPresenter.mView.mDatabase.rawQuery(sql, null);
        int size = cursor.getCount();
        Stuse = new String[size];
        for(int i = 0; cursor.moveToNext(); i++){
            Stuse[i] = cursor.getString(0);
        }

        mResumeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.onResumeClicked(Stuse[position]);
            }
        });

        return view;
    }

    @Deprecated
    public void setAdapterToResume(JSONObject resJSON) {
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

        while(!isAttached);

        String[] numerics = getResources().getStringArray(R.array.tempResume);
        for(String numeric: numerics){
            HashMap map = new HashMap();
            map.put("numeric", numeric);
            data.add(map);
        }
        String[] keys = new String[]{"numeric"};
        int[] viewIDs = new int[]{R.id.textView5};

        mAdapter = new SimpleAdapter(getActivity(), data, R.layout.gv_data, keys, viewIDs);

        mResumeList.setAdapter(mAdapter);
    }
}
