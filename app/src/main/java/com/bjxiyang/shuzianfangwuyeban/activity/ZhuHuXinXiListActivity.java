package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.ComplaintSelect;
import com.bjxiyang.shuzianfangwuyeban.bean.ZhuHuList;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;
import com.bjxiyang.shuzianfangwuyeban.util.Utility;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/7.
 */

public class ZhuHuXinXiListActivity extends MySwipeBackActivity {
    private int pageNum=1;

    @BindView(R.id.lv_zhuhuxinxi)
    ListView lv_zhuhuxinxi;
    @BindView(R.id.rl_zhuhuxinxi_fanhui)
    RelativeLayout rl_zhuhuxinxi_fanhui;
    @BindView(R.id.swipeRefreshLayout)
    PullToRefreshScrollView swipeRefreshLayout;

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
        swipeRefreshLayout.setMode(PullToRefreshBase.Mode.BOTH);
        getData();
        swipeRefreshLayout.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pageNum++;
                getData();
            }
        });

    }


    private void getData(){
        String url= URL.OWNER_SELECT
                +"pageNum="+pageNum
                +"&pageSize=" +5;
        RequestCenter.all(url, ZhuHuList.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                ZhuHuList zhuHuList= (ZhuHuList) responseObj;
                if (zhuHuList.getCode()== CodeUtil.SUCCESS){



                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }



}
