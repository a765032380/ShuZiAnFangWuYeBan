package com.bjxiyang.shuzianfangwuyeban.activity;

import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.ComplaintSelect;
import com.bjxiyang.shuzianfangwuyeban.bean.OrderSelect;
import com.bjxiyang.shuzianfangwuyeban.dialog.ListViewDialog;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/7.
 */

public class JiaoFeiJiLuActivity extends MySwipeBackActivity {




    @BindView(R.id.rl_jiaofeijilu_fanhui)
    RelativeLayout rl_jiaofeijilu_fanhui;
    @BindView(R.id.rl_lishijiaofei)
    RelativeLayout rl_lishijiaofei;
    @BindView(R.id.lv_jiaofeijilu)
    ListView lv_jiaofeijilu;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.ll_xiaoqu)
    LinearLayout ll_xiaoqu;
    @BindView(R.id.ll_louhao)
    LinearLayout ll_louhao;
    @BindView(R.id.ll_danyuan)
    LinearLayout ll_danyuan;
    @BindView(R.id.ll_fanghao)
    LinearLayout ll_fanghao;
    @BindView(R.id.tv_chongzhi)
    TextView tv_chongzhi;
    @BindView(R.id.tv_queding)
    TextView tv_queding;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.tv_xiaoqu)
    TextView tv_xiaoqu;
    @BindView(R.id.tv_louhao)
    TextView tv_louhao;
    @BindView(R.id.tv_danyuan)
    TextView tv_danyuan;
    @BindView(R.id.tv_fanghao)
    TextView tv_fanghao;




    @OnClick({R.id.rl_jiaofeijilu_fanhui,
            R.id.rl_lishijiaofei,
            R.id.ll_xiaoqu,
            R.id.ll_danyuan,
            R.id.ll_fanghao,
            R.id.tv_chongzhi,
            R.id.tv_queding,
            R.id.ll_louhao})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rl_jiaofeijilu_fanhui:
                finish();
                break;
            //筛选的按键
            case R.id.rl_lishijiaofei:
                drawerlayout.openDrawer(Gravity.RIGHT);
                break;
            //选择小区
            case R.id.ll_xiaoqu:
                ListViewDialog.showListDialog(this, getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {

                    }
                });
                break;
            //选择楼号
            case R.id.ll_louhao:
                ListViewDialog.showListDialog(this, getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {

                    }
                });
                break;
            //选择单元
            case R.id.ll_danyuan:
                ListViewDialog.showListDialog(this, getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {

                    }
                });
                break;
            //选择房号
            case R.id.ll_fanghao:
                ListViewDialog.showListDialog(this, getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {

                    }
                });
                break;
            //重置的按键
            case R.id.tv_chongzhi:
                break;
            //确定的按键
            case R.id.tv_queding:
                break;
        }



    }





    @Override
    protected int getContentViewId() {
        return R.layout.activity_jiaofeijilu;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        getData1();



    }

    private List<String> getData() {
        List mList=new ArrayList();
        for (int i=0;i<10;i++){
            mList.add("测试数据"+i);
        }


        return mList;
    }

    private void getData1(){
        String url= URL.ORDER_OLD_SELECR
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
                OrderSelect orderSelect = (OrderSelect) responseObj;
                if (orderSelect.getCode()== CodeUtil.SUCCESS){
                    MyBaseAdapter<OrderSelect.ObjBean.ListBean> adapter=
                            new MyBaseAdapter<OrderSelect.ObjBean.ListBean>(
                                    JiaoFeiJiLuActivity.this,
                                    orderSelect.getObj().getList(),R.layout.item_jiaofeijilu) {
                                @Override
                                public void convert(ViewHolder helper, OrderSelect.ObjBean.ListBean item) {
                                    helper.setText(R.id.tv_address,item.getCommunityName()+item.getNperName()
                                            +item.getFloorName()+item.getUnitName()+item.getDoorName());
                                    helper.setText(R.id.tv_date,item.getPayTime()+"");
                                    helper.setText(R.id.tv_jiaofeijine,item.getRentMoney()+"");
                                }

                    };
                    lv_jiaofeijilu.setAdapter(adapter);
                }




            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }




}
