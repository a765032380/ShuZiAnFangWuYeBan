package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by gll on 2017/11/2.
 */

public abstract class MyBaseActivity extends AppCompatActivity {

    //布局文件ID
    protected abstract int getContentViewId();

    protected abstract void initUI();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initUI();
    }
    public void startActivity(Class mClass){
        Intent intent=new Intent(this,mClass);
        startActivity(intent);
    }
    public void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
