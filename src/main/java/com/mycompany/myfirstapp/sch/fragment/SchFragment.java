package com.mycompany.myfirstapp.sch.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.cor.CorPresenter;
import com.mycompany.myfirstapp.cor.CorView;
import com.mycompany.myfirstapp.sch.SchPresenter;
import com.mycompany.myfirstapp.sch.SchView;
import com.mycompany.myfirstapp.utilities.SQLiteInteractor;

import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.mycompany.myfirstapp.index.Constants.USER_ID;

/**
 * Created by wangz on 2017/4/14.
 */

public class SchFragment extends Fragment {
    ImageView mMe;
    SearchView mSearchView;
    SchPresenter mPresenter;
    GridView mList;
    int[] idLists = {R.id.textView25, R.id.textView24, R.id.textView26};
    SimpleAdapter mAdapter;

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

        mList = (GridView) view.findViewById(R.id.gv_sch_places);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

//        String sql = "select Enterprise.Ename, Job.Jname, Assignment.Asnum " +
//                "from Enterprise, Job, Assignment, Instructor, Recruitment " +
//                "where Instructor.Scuse = '"+USER_ID+"' and Instructor.Cid = Assignment.Cid " +
//                "and Assignment.Rid = Recruitment.Rid and Recruitment.Jid = Job.Jid " +
//                "and Recruitment.Eid = Enterprise.Eid";
//        Log.i(TAG, "onCreateView: "+sql);
        String []keys = {"key1", "key2", "key3"};
//        List<HashMap<String, Object>> data = SQLiteInteractor.getData(mPresenter.mView.mDatabase, sql, keys);
        List<HashMap<String, Object>> data = getAdapterData();
        mAdapter = new SimpleAdapter(getContext(), data, R.layout.sch_myplaces_module, keys, idLists);
        mList.setAdapter(mAdapter);

        return view;
    }
    List<HashMap<String, Object>> getAdapterData(){
        
    }
}
