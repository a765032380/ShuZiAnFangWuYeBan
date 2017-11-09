package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.listener.OnSwitchListener;
import com.bjxiyang.shuzianfangwuyeban.view.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/3.
 */

public class XinXiaoXiTongZhiActivity extends MySwipeBackActivity implements View.OnClickListener{



    private int isOpen;

    @BindView(R.id.rl_news_fanhui)
    RelativeLayout rl_news_fanhui;
    @BindView(R.id.tv_news)
    TextView tv_news;
    @BindView(R.id.ll_news_xiugai)
    LinearLayout ll_news_xiugai;
    @BindView(R.id.sw_tishiyin)
    SwitchButton sw_tishiyin;


    @OnClick({R.id.rl_news_fanhui,R.id.ll_news_xiugai})
    public void onClick(View view) {
        switch (view.getId()){
            //新消息提醒的按键
            case R.id.ll_news_xiugai:
                break;
            //返回的按键
            case R.id.rl_news_fanhui:
                finish();
                break;
        }
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_xinxiaoxitongzhi;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        initData();
        sw_tishiyin.setOnSwitchListener(new OnSwitchListener() {
            @Override
            public void onSwitchChange() {
                showToast("状态改变");
            }

            /**
             * 如果当前状态是OPEN，操作成功返回true，操作失败返回false
             * 如果当前状态是CLOSE，操作成功返回false,操作失败返回true
             */
            @Override
            public boolean onSwitchIsOpen() {
                //如果当前状态是OPEN，操作成功返回true，
                if (isOpen==SwitchButton.OPEN){

                }else {

                }
                return false;
            }
        });

    }
    private void initData(){
        isOpen=sw_tishiyin.getCurrentStatus();
    }


}
