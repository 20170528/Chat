package com.example.chenjian.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenjian.chat.R;

/**
 * Created by chenjian on 17/3/5.
 */

public class fragment_choose extends Fragment implements View.OnClickListener{

    private View view;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_choose,container,false);
        View view_top = view.findViewById(R.id.view_top);
        view_top.setOnClickListener(this);
        return view;

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.view_top:
                getFragmentManager().popBackStack();
        }
    }
}
