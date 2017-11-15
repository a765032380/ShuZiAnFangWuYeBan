package com.bjxiyang.shuzianfangwuyeban.fragment_home;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.ComplaintSelect;
import com.bjxiyang.shuzianfangwuyeban.bean.OrderSelect;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.HomeUtil;

/**
 * Created by gll on 2017/11/8.
 */

public class FragmentFour extends BaseFragment {
    private ListView listView;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView=view.findViewById(R.id.lv_home);

        HomeUtil.getData(getContext(),2,listView);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }



}
