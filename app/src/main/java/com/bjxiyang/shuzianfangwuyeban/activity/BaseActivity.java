package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;

/**
 * Created by gll on 2017/11/2.
 */

public abstract class BaseActivity extends AppCompatActivity {
    //布局文件ID
    protected abstract int getContentViewId();

    //布局中Fragment的ID
    protected abstract int getFragmentContentId();

    //添加fragment
    public void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    //移除fragment
    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
//            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
//            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void startActivity(Class mClass){
        Intent intent=new Intent(this,mClass);
        startActivity(intent);
    }
    public void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }


}

