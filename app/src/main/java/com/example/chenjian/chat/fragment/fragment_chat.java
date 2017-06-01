package com.example.chenjian.chat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chenjian.chat.ChatActivity;
import com.example.chenjian.chat.ChatRecond;
import com.example.chenjian.chat.MainActivity;
import com.example.chenjian.chat.R;
import com.example.chenjian.chat.adapter.adapter_listview_chat;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by chenjian on 17/3/3.
 */

public class fragment_chat extends Fragment {

    private View view;

    //chat界面listview内容
    public ArrayList<ChatRecond> chatReconds;

    //listview_chat适配器
    private adapter_listview_chat adapter_listview_chat;

    public ListView listView_chat;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.page_chat,container,false);
        initChat();

        listView_chat.setOnItemClickListener((new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                ChatRecond chatRecond = chatReconds.get(position);

                Intent intent = new Intent(getActivity(), ChatActivity.class);

                intent.putExtra("nick",chatRecond.nick);
                intent.putExtra("message",chatRecond.msgview);

                startActivity(intent);

            }
        }));

        return view;

    }

    public void initChat(){

        chatReconds = new ArrayList<ChatRecond>();

        ChatRecond chatRecond_1  = new ChatRecond();
        Calendar now = Calendar.getInstance();
        chatRecond_1.msghour = now.get(Calendar.HOUR);
        chatRecond_1.msgminute = now.get(Calendar.MINUTE);
        chatRecond_1.msgnum = "5";
        chatRecond_1.msgview = "林朝阳很厉害哦，厉害哦厉害哦，超级无敌宇宙最牛逼的林朝阳";
        chatRecond_1.nick = "林朝阳";
        chatRecond_1.portraitaddr = R.drawable.boy1;
        chatReconds.add(chatRecond_1);

        ChatRecond chatRecond_2 = new ChatRecond();
        chatRecond_2.portraitaddr = R.drawable.boy2;
        chatRecond_2.nick = "pzz";
        now = Calendar.getInstance();
        chatRecond_2.msghour = now.get(Calendar.HOUR);
        chatRecond_2.msgminute = now.get(Calendar.MINUTE);
        chatRecond_2.msgview = "潘子正好像喜欢林朝阳";
        chatRecond_2.msgnum = "1";
        chatReconds.add(chatRecond_2);

        listView_chat = (ListView) view.findViewById(R.id.listview_chat);

        adapter_listview_chat = new adapter_listview_chat(this.getContext(),chatReconds);

        listView_chat.setAdapter(adapter_listview_chat);

    }
}
