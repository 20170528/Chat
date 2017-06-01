package com.example.chenjian.chat.adapter;

/**
 * Created by chenjian on 17/3/1.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenjian.chat.ChatRecond;
import com.example.chenjian.chat.R;

import java.util.ArrayList;

/**
 * Created by chenjian on 17/2/27.
 */

public class adapter_listview_chat extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<ChatRecond> chatReconds;
    private Context context;

    public adapter_listview_chat(Context context, ArrayList<ChatRecond> chatReconds) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.chatReconds = chatReconds;
    }

    @Override
    public int getCount() {
        return chatReconds.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            //view为空则创建view
            convertView = creatView();
        }

        bindView(position,convertView);

        return convertView;

    }

    public View creatView() {
        //createview函数，将单个view模板里的控件ID绑定到viewholder对应的每个属性上
        View view = layoutInflater.inflate(R.layout.singal_view, null);

        viewHolder vHolder = new viewHolder();
        vHolder.portriat = (ImageView) view.findViewById(R.id.chat_item_portrat);
        vHolder.msgnum = (TextView) view.findViewById(R.id.chat_item_messagetips);
        vHolder.nickname = (TextView) view.findViewById(R.id.chat_item_nickname);
        vHolder.msgview = (TextView) view.findViewById(R.id.chat_item_messageview);
        vHolder.msgtime = (TextView) view.findViewById(R.id.chat_item_messagetime);
        view.setTag(vHolder);//settag，下面的gettag要用到

        return view;
    }

    public void bindView(int posotion, View view) {
        //用于根据数据集的数据项给view写入
        ChatRecond chatRecond = chatReconds.get(posotion);

        viewHolder vHolder = (viewHolder) view.getTag();//你看，gettag了吧
        vHolder.portriat.setBackgroundResource(chatRecond.portraitaddr);//将具体值写入
        vHolder.msgnum.setText(chatRecond.msgnum);
        vHolder.nickname.setText(chatRecond.nick);
        vHolder.msgview.setText(chatRecond.msgview);
        vHolder.msgtime.setText(chatRecond.msghour+":"+chatRecond.msgminute);
    }

    public class viewHolder {
        public ImageView portriat;//对应到view中控件ID
        public TextView nickname;
        public TextView msgview;
        public TextView msgnum;
        public TextView msgtime;

    }
}

