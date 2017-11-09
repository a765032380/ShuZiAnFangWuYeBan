package com.bjxiyang.shuzianfangwuyeban.fragment_home;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;

/**
 * Created by gll on 2017/11/8.
 */

public class FragmentOne extends BaseFragment {


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ListView listView=view.findViewById(R.id.lv_home);
        MyBaseAdapter<String> adapter=new MyBaseAdapter<String>(getContext(), TestUtil.getData(),R.layout.item_wuyefankui) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_month,item);
            }
        };
        listView.setAdapter(adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
