package com.example.chenjian.chat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by chenjian on 17/3/3.
 */

public class adapter_fragmentpager extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;

    public adapter_fragmentpager(FragmentManager fm, ArrayList<Fragment> list){
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount(){
        return list.size();

    }

    @Override
    public Fragment getItem(int arg0){
        return list.get(arg0);
    }

}
