package com.mycompany.myfirstapp.stu.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.stu.fragment.register.RegisterView;

/**
 * Created by wangz on 2017/4/14.
 */

public class ResumeFragment extends Fragment {
    Button mRegister;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stu_resume, container, false);

        mRegister = (Button)view.findViewById(R.id.btn_stu_editResume);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RegisterView.class));
            }
        });
        return view;
    }
}
