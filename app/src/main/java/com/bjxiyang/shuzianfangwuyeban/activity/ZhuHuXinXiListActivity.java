package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.ComplaintSelect;
import com.bjxiyang.shuzianfangwuyeban.bean.ZhuHuList;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;
import com.bjxiyang.shuzianfangwuyeban.util.Utility;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/7.
 */

public class ZhuHuXinXiListActivity extends MySwipeBackActivity {
    private int pageNum=1;

//    @BindView(R.id.lv_zhuhuxinxi)
//    ListView lv_zhuhuxinxi;
    @BindView(R.id.rl_zhuhuxinxi_fanhui)
    RelativeLayout rl_zhuhuxinxi_fanhui;
    @BindView(R.id.swipeRefreshLayout)
    PullToRefreshListView swipeRefreshLayout;

    private MyBaseAdapter<ZhuHuList.ObjBean.ListBean> adapter;
    private int communityId=-1;
    private int nperId=-1;
    private int floorId=-1;
    private int unitId=-1;
    private int doorId=-1;
    private int role_type=-1;
    private String communityString="";
    private String nperString="";
    private String floorString="";
    private String unitString="";
    private String doorString="";
    private String role_typeString="";
    private List<ZhuHuList.ObjBean.ListBean> list=new ArrayList<>();
    private boolean isShuaXin=true;
    private int height;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_zhuhuxinxi_list;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        Intent intent=getIntent();
        communityId=intent.getIntExtra("communityId",-1);
        nperId=intent.getIntExtra("nperId",-1);
        floorId=intent.getIntExtra("floorId",-1);
        unitId=intent.getIntExtra("unitId",-1);
        doorId=intent.getIntExtra("doorId",-1);
        role_type=intent.getIntExtra("role_type",-1);
        rl_zhuhuxinxi_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        swipeRefreshLayout.setMode(PullToRefreshBase.Mode.BOTH);
        getData();
        swipeRefreshLayout.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                isShuaXin=true;
                pageNum=1;
                getData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                isShuaXin=false;
                pageNum++;
                getData();
            }
        });

    }


    private void getData(){
        if (communityId==-1){
            communityString="";
        }else {
            communityString=communityId+"";
        }
        if (nperId==-1){
            nperString="";
        }else {
            nperString=nperId+"";
        }
        if (floorId==-1){
            floorString="";
        }else {
            floorString=floorId+"";
        }
        if (unitId==-1){
            unitString="";
        }else {
            unitString=unitId+"";
        }
        if (doorId==-1){
            doorString="";
        }else {
            doorString=doorId+"";
        }
        if (role_type==-1){
            role_typeString="";
        }else {
            role_typeString=role_type+"";
        }
        String url= URL.OWNER_SELECT
                +"pageNum="+pageNum
                +"&pageSize=" +10
                +"&communityID="+communityString
                +"&nperID="+nperString
                +"&floorID="+floorString
                +"&unitID="+unitString
                +"&doorID="+doorString
                +"&role_type="+role_type;
        RequestCenter.all(url, ZhuHuList.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                ZhuHuList zhuHuList= (ZhuHuList) responseObj;
                if (zhuHuList.getCode()== CodeUtil.SUCCESS){

                     if (!isShuaXin) {
                         for (int i = 0; i < zhuHuList.getObj().getList().size(); i++) {
                             list.add(zhuHuList.getObj().getList().get(i));
                         }
                         adapter.notifyDataSetChanged();
                         swipeRefreshLayout.onRefreshComplete();
                         return;
                     }else {
                         list= zhuHuList.getObj().getList();
                     }
                    Log.i("LLLL",list.size()+"");
                    adapter=new MyBaseAdapter<ZhuHuList.ObjBean.ListBean>(ZhuHuXinXiListActivity.this,
                            list,R.layout.item_zhuhuxinxi) {

                        @Override
                        public void convert(ViewHolder helper, ZhuHuList.ObjBean.ListBean item) {
                            helper.setText(R.id.tv_dizhi,item.getFloorName()+"-"+item.getUnitName());
                            helper.setText(R.id.tv_fangjian,item.getDoorName()+"");
                            helper.setText(R.id.tv_name,item.getCustomerName());
                            if (item.getOwner_status()==1){
                                helper.setText(R.id.tv_yezhu,"租户");
                            }else {
                                helper.setText(R.id.tv_yezhu,"业主");
                            }
                            helper.setText(R.id.tv_shoujihao,item.getCustomerTel());

                            String addTime[] = item.getAdd_time().split(" ");

                            helper.setText(R.id.tv_ruzhushijian,addTime[0]);


                        }
                    };
                    swipeRefreshLayout.setAdapter(adapter);

                }
                swipeRefreshLayout.onRefreshComplete();

            }

            @Override
            public void onFailure(Object reasonObj) {
                swipeRefreshLayout.onRefreshComplete();
            }
        });
    }



}
