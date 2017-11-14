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
                +"&pageSize=" +100
                +"&search=";
        RequestCenter.all(url, Repairlist.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                Repairlist repairlist= (Repairlist) responseObj;
                if (repairlist.getCode()== CodeUtil.SUCCESS){

                    adapter=new MyBaseAdapter<Repairlist.ObjBean.ListBean>(
                            WeiXiuFuWuActivity.this, repairlist.getObj().getList(),R.layout.item_weixiufuwu) {
                        @Override
                        public void convert(ViewHolder helper, Repairlist.ObjBean.ListBean item) {
                            final  ViewHolder mHelper=helper;
                            final Repairlist.ObjBean.ListBean   mItem=item;
                            mHelper.setText(R.id.tv_date,mItem.getAdd_time());
                            mHelper.setText(R.id.tv_neirong,mItem.getContact_way());
                            mHelper.setText(R.id.tv_name,mItem.getRepair_name());
                            mHelper.setText(R.id.tv_dizhi,mItem.getCommunityName()+mItem.getNperName()
                            +mItem.getFloorName()+mItem.getUnitName()+mItem.getDoorName());
                            mHelper.setText(R.id.tv_dingdanhao,"单号："+mItem.getRepair_no());
                            if (mItem.getPic_url().size()==0){
                                mHelper.setGoneView(R.id.ll_image,View.GONE);
                            }else {
                                mHelper.setGoneView(R.id.ll_image,View.VISIBLE);
                            }
                            if (mItem.getPic_url().size()==1){
                                mHelper.setImageByUrl(R.id.iv_1,mItem.getPic_url().get(0).getPic_url());
                            }
                            if (mItem.getPic_url().size()==2){
                                mHelper.setImageByUrl(R.id.iv_1,mItem.getPic_url().get(0).getPic_url());
                                mHelper.setImageByUrl(R.id.iv_2,mItem.getPic_url().get(1).getPic_url());
                            }
                            if (mItem.getPic_url().size()==3){
                                mHelper.setImageByUrl(R.id.iv_1,mItem.getPic_url().get(0).getPic_url());
                                mHelper.setImageByUrl(R.id.iv_2,mItem.getPic_url().get(1).getPic_url());
                                mHelper.setImageByUrl(R.id.iv_3,mItem.getPic_url().get(2).getPic_url());
                            }
                            if (mItem.getPic_url().size()==4){
                                mHelper.setImageByUrl(R.id.iv_1,mItem.getPic_url().get(0).getPic_url());
                                mHelper.setImageByUrl(R.id.iv_2,mItem.getPic_url().get(1).getPic_url());
                                mHelper.setImageByUrl(R.id.iv_3,mItem.getPic_url().get(2).getPic_url());
                                mHelper.setImageByUrl(R.id.iv_4,mItem.getPic_url().get(3).getPic_url());
                            }

                            if (mItem.getRepair_status()==0){
                                mHelper.setTextColor(R.id.tv_button,0xffffffff);
                                mHelper.setText(R.id.tv_button,"受理");
                                mHelper.setBackgroundResource(R.id.tv_button,R.drawable.b_d_btn_dadianhua);
                                final int repairId=mItem.getRepair_id();
                                mHelper.setOnClickListener(R.id.tv_button, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String url=URL.REPAIRUPDATE
                                                +"repair_status="+1
                                                +"&repair_id="+repairId;

                                        RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                                            @Override
                                            public void onSuccess(Object responseObj) {
                                                RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                                                if (repairUpdate.getCode()==CodeUtil.SUCCESS){
                                                    mHelper.setBackgroundResource(R.id.tv_button,R.drawable.a_b_a_btn_fasong);
                                                    mHelper.setTextColor(R.id.tv_button,0xff297aff);
                                                    mHelper.setText(R.id.tv_button,"维修中");
                                                    mItem.setRepair_status(1);
                                                    final int repairId=mItem.getRepair_id();
                                                    mHelper.setOnClickListener(R.id.tv_button, new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            String url=URL.REPAIRUPDATE
                                                                    +"repair_status="+2
                                                                    +"&repair_id="+repairId;
                                                            RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                                                                @Override
                                                                public void onSuccess(Object responseObj) {
                                                                    RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                                                                    if (repairUpdate.getCode()==CodeUtil.SUCCESS){
                                                                        mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
                                                                        mHelper.setTextColor(R.id.tv_button,0xffada8a8);
                                                                        mHelper.setText(R.id.tv_button,"维修成功");
                                                                        mItem.setRepair_status(2);
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
                            if (mItem.getRepair_status()==1){
                                mHelper.setBackgroundResource(R.id.tv_button,R.drawable.a_b_a_btn_fasong);
                                mHelper.setText(R.id.tv_button,"维修中");
                                mHelper.setTextColor(R.id.tv_button,0xff297aff);
                                final int repairId=mItem.getRepair_id();
                                mHelper.setOnClickListener(R.id.tv_button, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String url=URL.REPAIRUPDATE
                                                +"repair_status="+2
                                                +"&repair_id="+repairId;
                                        RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                                            @Override
                                            public void onSuccess(Object responseObj) {
                                                RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                                                if (repairUpdate.getCode()==CodeUtil.SUCCESS){
                                                    mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
                                                    mHelper.setTextColor(R.id.tv_button,0xffada8a8);
                                                    mHelper.setText(R.id.tv_button,"维修成功");
                                                    mHelper.setOnClickListener(R.id.tv_button,null);
                                                    mItem.setRepair_status(2);
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
                                mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
                                mHelper.setTextColor(R.id.tv_button,0xffada8a8);
                                mHelper.setText(R.id.tv_button,"维修成功");
                                mHelper.setOnClickListener(R.id.tv_button,null);
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
