package com.example.chenjian.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenjian.chat.R;

/**
 * Created by chenjian on 17/3/3.
 */

public class fragment_contact extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.page_contact,container,false);
        return view;
    }
}
