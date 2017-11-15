package com.bjxiyang.shuzianfangwuyeban.fragment_home;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.util.HomeUtil;

/**
 * Created by gll on 2017/11/8.
 */

public class FragmentTwo extends BaseFragment {
    private ListView listView;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView=view.findViewById(R.id.lv_home);

        HomeUtil.getData(getContext(),1,listView);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
