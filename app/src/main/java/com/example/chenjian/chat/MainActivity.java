package com.example.chenjian.chat;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chenjian.chat.adapter.adapter_fragmentpager;
import com.example.chenjian.chat.adapter.adapter_listview_chat;
import com.example.chenjian.chat.adapter.adapter_viewpager;
import com.example.chenjian.chat.fragment.fragment_chat;
import com.example.chenjian.chat.fragment.fragment_choose;
import com.example.chenjian.chat.fragment.fragment_contact;
import com.example.chenjian.chat.fragment.fragment_discover;
import com.example.chenjian.chat.fragment.fragment_me;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.chenjian.chat.R.layout.fragment_choose;
import static com.example.chenjian.chat.R.layout.page_chat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    // 底部菜单4个Linearlayout
    private LinearLayout ll_chat;
    private LinearLayout ll_contact;
    private LinearLayout ll_discover;
    private LinearLayout ll_me;

    // 底部菜单4个ImageView
    private ImageView iv_chat;
    private ImageView iv_contact;
    private ImageView iv_discover;
    private ImageView iv_me;

    // 底部菜单4个菜单标题
    private TextView tv_chat;
    private TextView tv_contact;
    private TextView tv_discover;
    private TextView tv_me;

    // 中间内容区域
    private ViewPager viewPager;

    // ViewPager适配器ContentAdapter
    private adapter_fragmentpager adapter_fragmentpager;


    //用于储存四个page
    private ArrayList<Fragment> fragments;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        iv_chat.setImageResource(R.drawable.chat_green);
        tv_chat.setTextColor(0xff1ef260);
        setEvent();

    }



    public void initView(){

        ll_chat = (LinearLayout) findViewById(R.id.ll_chat);
        ll_contact = (LinearLayout) findViewById(R.id.ll_contact);
        ll_discover = (LinearLayout) findViewById(R.id.ll_discover);
        ll_me = (LinearLayout) findViewById(R.id.ll_me);

        iv_chat = (ImageView) findViewById(R.id.iv_chat);
        iv_contact = (ImageView) findViewById(R.id.iv_contact);
        iv_discover = (ImageView) findViewById(R.id.iv_discover);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        tv_chat = (TextView) findViewById(R.id.tv_chat);
        tv_contact = (TextView) findViewById(R.id.tv_contact);
        tv_discover =  (TextView) findViewById(R.id.tv_discover);
        tv_me = (TextView) findViewById(R.id.tv_me);

        fragment_chat fragment_chat = new fragment_chat();
        fragment_contact fragment_contact = new fragment_contact();
        fragment_discover fragment_discover = new fragment_discover();
        fragment_me fragment_me = new fragment_me();

        fragments = new ArrayList<Fragment>();
        fragments.add(fragment_chat);
        fragments.add(fragment_contact);
        fragments.add(fragment_discover);
        fragments.add(fragment_me);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        adapter_fragmentpager = new adapter_fragmentpager(getSupportFragmentManager(),fragments);

        viewPager.setAdapter(adapter_fragmentpager);


    }

    @Override
    public void onClick(View v){

        restartButton();
        switch (v.getId()){

            case R.id.ll_chat:
                iv_chat.setImageResource(R.drawable.chat_green);
                tv_chat.setTextColor(0xff1ef260);
                viewPager.setCurrentItem(0,false);
                break;

            case R.id.ll_contact:
                /*iv_contact.setImageResource(R.drawable.contact_green);
                tv_contact.setTextColor(0xff1ef260);
                viewPager.setCurrentItem(1,false);*/

                com.example.chenjian.chat.fragment.fragment_choose fragment_choose = new fragment_choose();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.activity_main,fragment_choose);
                transaction.addToBackStack(null);
                transaction.commit();


                break;

            case R.id.ll_discover:
                iv_discover.setImageResource(R.drawable.discover_green);
                tv_discover.setTextColor(0xff1ef260);
                viewPager.setCurrentItem(2,false);
                break;

            case R.id.ll_me:
                iv_me.setImageResource(R.drawable.me_green);
                tv_me.setTextColor(0xff1ef260);
                viewPager.setCurrentItem(3,false);
                break;

            default:
                break;
        }

    }

    public void restartButton(){

        iv_chat.setImageResource(R.drawable.chats);
        iv_contact.setImageResource(R.drawable.contact);
        iv_discover.setImageResource(R.drawable.discover);
        iv_me.setImageResource(R.drawable.me);

        tv_chat.setTextColor(0xff8a8a8a);
        tv_contact.setTextColor(0xff8a8a8a);
        tv_discover.setTextColor(0xff8a8a8a);
        tv_me.setTextColor(0xff8a8a8a);

    }

    @Override
    public void onPageScrollStateChanged(int arg0){

    }

    @Override
    public void onPageScrolled(int arg0,float arg1,int arg3){

    }

    @Override
    public void onPageSelected(int arg0){

        restartButton();

        switch (arg0){
            case 0:
                iv_chat.setImageResource(R.drawable.chat_green);
                tv_chat.setTextColor(0xff1ef260);
                break;

            case 1:
                iv_contact.setImageResource(R.drawable.contact_green);
                tv_contact.setTextColor(0xff1ef260);
                break;

            case 2:
                iv_discover.setImageResource(R.drawable.discover_green);
                tv_discover.setTextColor(0xff1ef260);
                break;

            case 3:
                iv_me.setImageResource(R.drawable.me_green);
                tv_me.setTextColor(0xff1ef260);
                break;

            default:
                break;
        }
    }

    public void setEvent(){
        ll_chat.setOnClickListener(this);
        ll_contact.setOnClickListener(this);
        ll_discover.setOnClickListener(this);
        ll_me.setOnClickListener(this);

        viewPager.setOnPageChangeListener(this);
    }

}
