package com.bjxiyang.shuzianfangwuyeban.fragment_main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bjxiyang.shuzianfangwuyeban.activity.BaseActivity;

/**
 * Created by gll on 2017/11/2.
 */

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取布局文件ID
    protected abstract int getLayoutId();

    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    //添加fragment
    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    //移除fragment
    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);
        return view;
    }
    //跳转Activity
    public void startActivity(Class mClass){
        Intent intent=new Intent(getContext(),mClass);
        startActivity(intent);
    }
    //弹Toast
    public void showToast(String message){
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }
}
