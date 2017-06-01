package com.example.chenjian.chat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenjian.chat.R;

import java.util.zip.Inflater;

/**
 * Created by chenjian on 17/3/3.
 */

public class fragment_me extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.page_me,container,false);
        return view;
    }
}
