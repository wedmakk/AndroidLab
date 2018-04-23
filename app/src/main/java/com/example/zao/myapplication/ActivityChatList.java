package com.example.zao.myapplication;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.UserMessage;

import java.util.ArrayList;
import java.util.Collections;

public class ActivityChatList extends AppCompatActivity {

    EditText etMessage;
    ListView chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        etMessage = findViewById(R.id.etMessage);
        chat = findViewById(R.id.listChats);

        ActivityChannels.myCpenChannel.enter(new OpenChannel.OpenChannelEnterHandler() {
            public void onResult(com.sendbird.android.SendBirdException e) {
                if (e != null) {
                    //  MY_openChannel = openChannel;
                }
            }
        });
    }

    public void SendMessageButton_OnClick(View view) {
        ActivityChannels.myCpenChannel.sendUserMessage(etMessage.getText().toString(), null, "776", new BaseChannel.SendUserMessageHandler() {
            @Override
            public void onSent(UserMessage userMessage, SendBirdException e) {
            }
        });

        chat.setAdapter(new ArrayAdapter<>
                (ActivityChatList.this, android.R.layout.simple_list_item_1,
                        new ArrayList<>(Collections.singletonList("User1: " + etMessage.getText().toString()))));
    }
}
