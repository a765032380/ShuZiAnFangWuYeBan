package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.ComplaintSelect;
import com.bjxiyang.shuzianfangwuyeban.bean.Repairlist;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/7.
 */

public class WuYeFanKuiActivity extends MySwipeBackActivity {

    @BindView(R.id.iv_wuyejiaofei_fanhui)
    RelativeLayout iv_wuyejiaofei_fanhui;
    @BindView(R.id.lv_wuyefankui)
    ListView lv_wuyefankui;

    private MyBaseAdapter<ComplaintSelect.ObjBean.ListBean> adapter;




    @Override
    protected int getContentViewId() {
        return R.layout.activity_wuyefankui;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        iv_wuyejiaofei_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getData();



    }
    private void getData(){
        String url= URL.COMPLAINT_SELECT
                +"pageNum="+1
                +"&pageSize=" +5;
        RequestCenter.all(url, ComplaintSelect.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                ComplaintSelect complaintSelect= (ComplaintSelect) responseObj;
                if (complaintSelect.getCode()== CodeUtil.SUCCESS){
                    adapter=new MyBaseAdapter<ComplaintSelect.ObjBean.ListBean>
                            (WuYeFanKuiActivity.this, complaintSelect.getObj().getList(),R.layout.item_wuyefankui) {
                        @Override
                        public void convert(ViewHolder helper, ComplaintSelect.ObjBean.ListBean item) {
                            helper.setText(R.id.tv_date,item.getCreate_time());
                            helper.setText(R.id.tv_neirong,item.getContent());
//                            helper.setText(R.id.tv_name,item.get);
//                            helper.setText(R.id.tv_dizhi,item.getCommunityName()+item.getNperName()
//                                    +item.getFloorName()+item.getUnitName()+item.getDoorName());

                        }
                    };
                    lv_wuyefankui.setAdapter(adapter);



                }





            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }



}
