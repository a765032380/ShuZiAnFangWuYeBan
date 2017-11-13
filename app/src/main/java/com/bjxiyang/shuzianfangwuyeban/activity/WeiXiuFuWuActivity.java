package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.RepairUpdate;
import com.bjxiyang.shuzianfangwuyeban.bean.Repairlist;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/7.
 */

public class WeiXiuFuWuActivity extends MySwipeBackActivity{
    @BindView(R.id.iv_wuyejiaofei_fanhui)
    RelativeLayout iv_wuyejiaofei_fanhui;
    @BindView(R.id.lv_weixiufuwu)
    ListView lv_weixiufuwu;

    private MyBaseAdapter<Repairlist.ObjBean.ListBean> adapter;




    @Override
    protected int getContentViewId() {
        return R.layout.activity_weixiufuwu;
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
        String url= URL.REPAIRLIST
                +"pageNum="+1
                +"&pageSize=" +5
                +"&search=";
        RequestCenter.all(url, Repairlist.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                Repairlist repairlist= (Repairlist) responseObj;
                if (repairlist.getCode()== CodeUtil.SUCCESS){

                    adapter=new MyBaseAdapter<Repairlist.ObjBean.ListBean>(
                            WeiXiuFuWuActivity.this, repairlist.getObj().getList(),R.layout.item_weixiufuwu) {
                        @Override
                        public void convert(ViewHolder helper, final Repairlist.ObjBean.ListBean item) {
                            helper.setText(R.id.tv_date,item.getAdd_time());
                            helper.setText(R.id.tv_neirong,item.getContact_way());
                            helper.setText(R.id.tv_name,item.getRepair_name());
                            helper.setText(R.id.tv_dizhi,item.getCommunityName()+item.getNperName()
                            +item.getFloorName()+item.getUnitName()+item.getDoorName());
                            helper.setText(R.id.tv_dingdanhao,"单号："+item.getRepair_no());
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
                            final ViewHolder mHelper=helper;
                            if (item.getRepair_status()==0){
                                helper.setTextColor(R.id.tv_button,0xffffffff);
                                helper.setText(R.id.tv_button,"受理");

                                helper.setOnClickListener(R.id.tv_button, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String url=URL.REPAIRUPDATE
                                                +"repair_status="+1
                                                +"&repair_id="+item.getRepair_id();

                                        RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                                            @Override
                                            public void onSuccess(Object responseObj) {
                                                RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                                                if (repairUpdate.getCode()==CodeUtil.SUCCESS){
                                                    mHelper.setBackgroundResource(R.id.tv_button,R.drawable.a_b_a_btn_fasong);
                                                    mHelper.setTextColor(R.id.tv_button,0xff297aff);
                                                    mHelper.setText(R.id.tv_button,"维修中");
                                                    mHelper.setOnClickListener(R.id.tv_button, new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            String url=URL.REPAIRUPDATE
                                                                    +"repair_status="+2
                                                                    +"&repair_id="+item.getRepair_id();
                                                            RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                                                                @Override
                                                                public void onSuccess(Object responseObj) {
                                                                    RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                                                                    if (repairUpdate.getCode()==CodeUtil.SUCCESS){
                                                                        mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
                                                                        mHelper.setTextColor(R.id.tv_button,0xffada8a8);
                                                                        mHelper.setText(R.id.tv_button,"维修成功");
                                                                    }

                                                                }

                                                                @Override
                                                                public void onFailure(Object reasonObj) {

                                                                }
                                                            });
                                                        }
                                                    });
                                                }

                                            }

                                            @Override
                                            public void onFailure(Object reasonObj) {

                                            }
                                        });
                                    }
                                });

                            }
                            if (item.getRepair_status()==1){
                                helper.setBackgroundResource(R.id.tv_button,R.drawable.a_b_a_btn_fasong);
                                helper.setText(R.id.tv_button,"维修中");
                                helper.setTextColor(R.id.tv_button,0xff297aff);
                                helper.setOnClickListener(R.id.tv_button, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String url=URL.REPAIRUPDATE
                                                +"repair_status="+2
                                                +"&repair_id="+item.getRepair_id();
                                        RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                                            @Override
                                            public void onSuccess(Object responseObj) {
                                                RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                                                if (repairUpdate.getCode()==CodeUtil.SUCCESS){
                                                    mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
                                                    mHelper.setTextColor(R.id.tv_button,0xffada8a8);
                                                    mHelper.setText(R.id.tv_button,"维修成功");
                                                    mHelper.setOnClickListener(R.id.tv_button,null);
                                                }

                                            }

                                            @Override
                                            public void onFailure(Object reasonObj) {

                                            }
                                        });
                                    }
                                });

                            }
                            if (item.getRepair_status()==2) {
                                helper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
                                helper.setTextColor(R.id.tv_button,0xffada8a8);
                                helper.setText(R.id.tv_button,"维修成功");
                                helper.setOnClickListener(R.id.tv_button,null);
                            }


                        }

                    };
                    lv_weixiufuwu.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }


}
