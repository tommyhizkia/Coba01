package com.example.dotnetuser.coba01;


import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dotnetuser.coba01.entity.quiz;
import com.example.dotnetuser.coba01.util.DBAdapter;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity{

    private static final String TAG = MainActivity.class.getName();

   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
