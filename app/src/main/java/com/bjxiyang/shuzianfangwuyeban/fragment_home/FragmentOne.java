package com.bjxiyang.shuzianfangwuyeban.fragment_home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.DaiBanAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.DaiBan;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;
import com.bjxiyang.shuzianfangwuyeban.util.HomeUtil;

/**
 * Created by gll on 2017/11/8.
 */

public class FragmentOne extends BaseFragment {
    private ListView listView;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView=view.findViewById(R.id.lv_home);

        HomeUtil.getData(getContext(),0,listView);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }




}
