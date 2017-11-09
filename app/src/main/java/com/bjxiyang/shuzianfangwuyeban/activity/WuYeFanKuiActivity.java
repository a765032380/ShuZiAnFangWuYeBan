package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/7.
 */

public class WuYeFanKuiActivity extends MySwipeBackActivity {

    @BindView(R.id.iv_wuyejiaofei_fanhui)
    RelativeLayout iv_wuyejiaofei_fanhui;
    @BindView(R.id.lv_wuyefankui)
    ListView lv_wuyefankui;

    private MyBaseAdapter<String> adapter;




    @Override
    protected int getContentViewId() {
        return R.layout.activity_wuyefankui;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        iv_wuyejiaofei_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        adapter=new MyBaseAdapter<String>(this, TestUtil.getData(),R.layout.item_wuyefankui) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_month,item);
            }
        };
        lv_wuyefankui.setAdapter(adapter);


    }
}
