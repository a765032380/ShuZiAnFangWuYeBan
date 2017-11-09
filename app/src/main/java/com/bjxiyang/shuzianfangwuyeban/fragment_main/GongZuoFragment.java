package com.bjxiyang.shuzianfangwuyeban.fragment_main;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.activity.BaseActivity;
import com.bjxiyang.shuzianfangwuyeban.activity.WeiXiuFuWuActivity;
import com.bjxiyang.shuzianfangwuyeban.activity.WuYeFanKuiActivity;
import com.bjxiyang.shuzianfangwuyeban.activity.WuYeJiaoFeiActivity;
import com.bjxiyang.shuzianfangwuyeban.activity.XiaoQuGongGaoActivity;
import com.bjxiyang.shuzianfangwuyeban.activity.ZhuHuXinXiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/2.
 */

public  class GongZuoFragment extends BaseFragment{

    @BindView(R.id.ll_wuyefei)
    LinearLayout ll_wuyefei;
    @BindView(R.id.ll_xiaoqugonggao)
    LinearLayout ll_xiaoqugonggao;
    @BindView(R.id.ll_weixiu)
    LinearLayout ll_weixiu;
    @BindView(R.id.ll_zhuhuxinxi)
    LinearLayout ll_zhuhuxinxi;
    @BindView(R.id.ll_wuyefankui)
    LinearLayout ll_wuyefankui;

    @OnClick({R.id.ll_wuyefei,
            R.id.ll_xiaoqugonggao,
            R.id.ll_weixiu,
            R.id.ll_zhuhuxinxi,
            R.id.ll_wuyefankui})
    public void onClick(View view) {
        switch (view.getId()){
            //物业缴费
            case R.id.ll_wuyefei:
                startActivity(WuYeJiaoFeiActivity.class);
                break;
            //小区公告
            case R.id.ll_xiaoqugonggao:
                startActivity(XiaoQuGongGaoActivity.class);
                break;
            //维修服务
            case R.id.ll_weixiu:
                startActivity(WeiXiuFuWuActivity.class);
                break;
            //住户信息
            case R.id.ll_zhuhuxinxi:
                startActivity(ZhuHuXinXiActivity.class);
                break;
            //物业反馈
            case R.id.ll_wuyefankui:
                startActivity(WuYeFanKuiActivity.class);
                break;

        }

    }


    public static GongZuoFragment newInstance() {
        return new GongZuoFragment();
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this,view);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gongzuo;
    }

}
