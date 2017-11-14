package com.bjxiyang.shuzianfangwuyeban.fragment_home;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.DaiBan;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

/**
 * Created by gll on 2017/11/8.
 */

public class FragmentOne extends BaseFragment {
    private MyBaseAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView=view.findViewById(R.id.lv_home);

        getData(1);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    private void getData(int type){
        String url= URL.SELEVCT_BACKLOG
                +"pageNum=1"
                +"&pageSize=1"
                +"&type="+type;
        RequestCenter.all(url, DaiBan.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                DaiBan daiBan= (DaiBan) responseObj;
                if (daiBan.getCode()== CodeUtil.SUCCESS){
                    adapter=new MyBaseAdapter<String>(getContext(), TestUtil.getData(),R.layout.item_wuyefankui) {
                        @Override
                        public void convert(ViewHolder helper, String item) {
                            helper.setText(R.id.tv_month,item);
                        }
                    };
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }


}
