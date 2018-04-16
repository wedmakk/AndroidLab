package com.example.zao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("testLog", "MainActivity: onCreate()");
    }

        public void login_onClick(View view)
        {
            Intent intent = new Intent(this, ActivityChatList.class);
            startActivity(intent);
        }
    }


