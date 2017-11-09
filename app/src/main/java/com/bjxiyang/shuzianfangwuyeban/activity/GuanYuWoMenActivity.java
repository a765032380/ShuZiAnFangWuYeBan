package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bjxiyang.shuzianfangwuyeban.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/3.
 */

public class GuanYuWoMenActivity extends MySwipeBackActivity implements View.OnClickListener{

    @BindView(R.id.rl_about_fanhui)
    RelativeLayout rl_about_fanhui;
    @BindView(R.id.ll_about_yijianfankui)
    LinearLayout ll_about_yijianfankui;
    @BindView(R.id.ll_xingongnengjieshao)
    LinearLayout ll_xingongnengjieshao;
    @BindView(R.id.ll_about_fuwuxieyi)
    LinearLayout ll_about_fuwuxieyi;
    @BindView(R.id.ll_about_yinsi)
    LinearLayout ll_about_yinsi;
    @BindView(R.id.ll_about_banbenxinxi)
    LinearLayout ll_about_banbenxinxi;



    @OnClick({R.id.rl_about_fanhui,
            R.id.ll_about_yijianfankui,
            R.id.ll_xingongnengjieshao,
            R.id.ll_about_fuwuxieyi,
            R.id.ll_about_yinsi,
            R.id.ll_about_banbenxinxi,})
    public void onClick(View view) {
        switch (view.getId()){
            //返回的按键
            case R.id.rl_about_fanhui:
                finish();
                break;
            //意见反馈
            case R.id.ll_about_yijianfankui:
                startActivity(YiJianFanKuiActivity.class);
                break;
            //新功能介绍
            case R.id.ll_xingongnengjieshao:
                break;
            //服务条款
            case R.id.ll_about_fuwuxieyi:
                startActivity(FuWuTiaoKuanActivity.class);
                break;
            //隐私政策
            case R.id.ll_about_yinsi:

                break;
            //版本信息
            case R.id.ll_about_banbenxinxi:
                startActivity(BanBenXinXiActivity.class);
                break;



        }
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_guanyushuzianfang;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);

    }


}
