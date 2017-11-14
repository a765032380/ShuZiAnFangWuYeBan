package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bjxiyang.shuzianfangwuyeban.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/7.
 */

public class WuYeJiaoFeiActivity extends MySwipeBackActivity implements View.OnClickListener{
    @BindView(R.id.iv_wuyejiaofei_fanhui)
    RelativeLayout iv_wuyejiaofei_fanhui;
    @BindView(R.id.ll_jiaofeijilu)
    LinearLayout ll_jiaofeijilu;
    @BindView(R.id.ll_chuanjianjiaofei)
    LinearLayout ll_chuanjianjiaofei;

    @OnClick({R.id.iv_wuyejiaofei_fanhui,
            R.id.ll_jiaofeijilu,
            R.id.ll_chuanjianjiaofei})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_wuyejiaofei_fanhui:
                finish();
                break;
            //缴费记录
            case R.id.ll_jiaofeijilu:
                startActivity(JiaoFeiJiLuActivity.class);
                break;
            //创建缴费
            case R.id.ll_chuanjianjiaofei:
                startActivity(ChuangJianJiaoFeiActivity.class);
                break;
        }

    }






    @Override
    protected int getContentViewId() {
        return R.layout.activity_wuyejiaofei;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);

    }


}
