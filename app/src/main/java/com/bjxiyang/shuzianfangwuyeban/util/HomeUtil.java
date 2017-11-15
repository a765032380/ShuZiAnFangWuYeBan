package com.bjxiyang.shuzianfangwuyeban.util;

import android.content.Context;
import android.widget.ListView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.adapter.DaiBanAdapter;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.DaiBan;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;

/**
 * Created by gll on 2017/11/15.
 */

public class HomeUtil {



    public static void getData(final Context context, int type, final ListView listView){
        String url= URL.SELEVCT_BACKLOG
                +"pageNum=1"
                +"&pageSize=100"
                +"&type="+type;
        RequestCenter.all(url, DaiBan.class, new DisposeDataListener() {

            @Override
            public void onSuccess(Object responseObj) {
                DaiBan daiBan= (DaiBan) responseObj;
                if (daiBan.getCode()== CodeUtil.SUCCESS){
                    DaiBanAdapter adapter=new DaiBanAdapter(context,daiBan.getObj());

//                    adapter=new MyBaseAdapter<String>(getContext(), TestUtil.getData(),R.layout.item_wuyefankui) {
//                        @Override
//                        public void convert(ViewHolder helper, String item) {
//                            helper.setText(R.id.tv_month,item);
//                        }
//                    };
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }

}
