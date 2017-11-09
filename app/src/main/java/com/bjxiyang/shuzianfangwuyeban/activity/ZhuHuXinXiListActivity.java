package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.util.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/7.
 */

public class ZhuHuXinXiListActivity extends MySwipeBackActivity {

    @BindView(R.id.lv_zhuhuxinxi)
    ListView lv_zhuhuxinxi;
    @BindView(R.id.rl_zhuhuxinxi_fanhui)
    RelativeLayout rl_zhuhuxinxi_fanhui;

    private MyBaseAdapter<String> adapter;




    @Override
    protected int getContentViewId() {
        return R.layout.activity_zhuhuxinxi_list;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        rl_zhuhuxinxi_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        adapter=new MyBaseAdapter<String>(this, TestUtil.getData(),R.layout.item_lishijiaofei) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_mouth,item);
                helper.setListView(R.id.lv_mListView,TestUtil.getData(3));
                Utility.setListViewHeightBasedOnChildren((ListView) helper.getView(R.id.lv_mListView));
            }
        };
        lv_zhuhuxinxi.setAdapter(adapter);



    }
}
