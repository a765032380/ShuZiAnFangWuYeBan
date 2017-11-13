package com.bjxiyang.shuzianfangwuyeban.fragment_home;

import android.os.Bundle;
import android.view.View;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.ComplaintSelect;
import com.bjxiyang.shuzianfangwuyeban.bean.OrderSelect;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;

/**
 * Created by gll on 2017/11/8.
 */

public class FragmentFour extends BaseFragment {
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        getData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fuwutiaokuan;

    }
    private void getData(){
        String url= URL.ORDER_NEW_SELECR
                +"pageNum="+1
                +"&pageSize=" +5
                +"&communityId="
                +"&nperId="
                +"&floorId="
                +"&unitId="
                +"&doorId=";
        RequestCenter.all(url, OrderSelect.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }



}
