package com.example.zao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityChannels extends AppCompatActivity {

    public static OpenChannel myCpenChannel;
    ListView channelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channels);
        channelsList = findViewById(R.id.ChannelsList);
        channelsList.setAdapter(new ArrayAdapter<>
                (ActivityChannels.this, android.R.layout.simple_list_item_1, new ArrayList<>(Collections.singletonList("Channel"))));
        SendBird.connect("Is it me", "1de7a75e6330b22a4a78838daca22a9e52b49240", new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                if(e == null)
                {
                    Log.w("Error", "Connection faild!");
                }
                else
                {
                    Log.w("OKAY", "Connection OKAY!");
                }
            }
        });

        OpenChannel.getChannel("sendbird_open_channel_35998_849401b9063cdfd1aafa86dbba7bf10ce86be19d", new OpenChannel.OpenChannelGetHandler() {
            @Override
            public void onResult(final OpenChannel openChannel, SendBirdException e) {
                if (e != null) {
                    return;
                }
                Log.w("wqe", " I am here");
                myCpenChannel = openChannel;
                openChannel.enter(new OpenChannel.OpenChannelEnterHandler() {
                    @Override
                    public void onResult(SendBirdException e) {
                        if (e != null) {
                            //  MY_openChannel = openChannel;
                            openChannel.sendUserMessage("LOL", null, "776", new BaseChannel.SendUserMessageHandler() {
                                @Override
                                public void onSent(UserMessage userMessage, SendBirdException e) {
                                    if (e != null) {
                                        // Error.
                                        return;
                                    }
                                }
                            });
                            return;
                        }
                    }
                });
            }
        });
        channelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(ActivityChannels.this, ActivityChatList.class);
                    startActivity(intent);
                }
            }
        });
    }
}
