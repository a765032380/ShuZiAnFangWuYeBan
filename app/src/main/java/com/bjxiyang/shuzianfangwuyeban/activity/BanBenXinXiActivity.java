package com.bjxiyang.shuzianfangwuyeban.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.bjxiyang.shuzianfangwuyeban.R;


/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class BanBenXinXiActivity extends MySwipeBackActivity {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_guanyuwomen;
    }

    @Override
    protected void initUI() {
        LinearLayout lv_fanhui= (LinearLayout) findViewById(R.id.lv_fanhui);
        lv_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
