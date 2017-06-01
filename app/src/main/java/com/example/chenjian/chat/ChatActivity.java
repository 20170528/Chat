package com.example.chenjian.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by chenjian on 17/3/5.
 */

public class ChatActivity extends AppCompatActivity {

    private TextView tv_nick;

    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();

        String nick = intent.getStringExtra("nick");
        tv_nick = (TextView) findViewById(R.id.tv_nick);
        tv_nick.setText(nick);

        String message = intent.getStringExtra("message");
        tv_message = (TextView)findViewById(R.id.tv_message);
        tv_message.setText(message);


    }
}
