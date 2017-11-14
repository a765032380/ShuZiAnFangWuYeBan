package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Intent;
import android.net.Uri;
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
                +"&pageSize=" +100;
        RequestCenter.all(url, ComplaintSelect.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                ComplaintSelect complaintSelect= (ComplaintSelect) responseObj;
                if (complaintSelect.getCode()== CodeUtil.SUCCESS){
                    adapter=new MyBaseAdapter<ComplaintSelect.ObjBean.ListBean>
                            (WuYeFanKuiActivity.this, complaintSelect.getObj().getList(),R.layout.item_wuyefankui) {
                        @Override
                        public void convert(ViewHolder helper, final ComplaintSelect.ObjBean.ListBean item) {
                            if (item.getPic_url().size()==0){
                                helper.setGoneView(R.id.ll_image,View.GONE);
                            }else {
                                helper.setGoneView(R.id.ll_image,View.VISIBLE);
                            }
                            if (item.getPic_url().size()==1){
                                helper.setImageByUrl(R.id.iv_1,item.getPic_url().get(0).getPic_url());
                            }
                            if (item.getPic_url().size()==2){
                                helper.setImageByUrl(R.id.iv_1,item.getPic_url().get(0).getPic_url());
                                helper.setImageByUrl(R.id.iv_2,item.getPic_url().get(1).getPic_url());
                            }
                            if (item.getPic_url().size()==3){
                                helper.setImageByUrl(R.id.iv_1,item.getPic_url().get(0).getPic_url());
                                helper.setImageByUrl(R.id.iv_2,item.getPic_url().get(1).getPic_url());
                                helper.setImageByUrl(R.id.iv_3,item.getPic_url().get(2).getPic_url());
                            }
                            if (item.getPic_url().size()==4){
                                helper.setImageByUrl(R.id.iv_1,item.getPic_url().get(0).getPic_url());
                                helper.setImageByUrl(R.id.iv_2,item.getPic_url().get(1).getPic_url());
                                helper.setImageByUrl(R.id.iv_3,item.getPic_url().get(2).getPic_url());
                                helper.setImageByUrl(R.id.iv_4,item.getPic_url().get(3).getPic_url());
                            }


                            helper.setText(R.id.tv_date,item.getCreate_time());
                            helper.setText(R.id.tv_neirong,item.getContent());
                            helper.setText(R.id.tv_dizhi,item.getCommunityName()+"");
                            helper.setOnClickListener(R.id.tv_button, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+item.getMobilePhone()));
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }
                            });
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
