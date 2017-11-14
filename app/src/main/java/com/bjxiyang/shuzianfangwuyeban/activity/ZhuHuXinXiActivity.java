package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.FindCommunity;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectDoor;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectFloor;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectNper;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectUnit;
import com.bjxiyang.shuzianfangwuyeban.dialog.ListViewDialog;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/7.
 */

public class ZhuHuXinXiActivity extends MySwipeBackActivity {

    @BindView(R.id.rl_zhuhuxinxi_fanhui)
    RelativeLayout rl_zhuhuxinxi_fanhui;
    @BindView(R.id.rl_jilu)
    RelativeLayout rl_jilu;
    @BindView(R.id.ll_sousuo)
    LinearLayout ll_sousuo;
    @BindView(R.id.ll_xiaoqu)
    LinearLayout ll_xiaoqu;
    @BindView(R.id.ll_jiaose)
    LinearLayout ll_jiaose;
    @BindView(R.id.ll_louhao)
    LinearLayout ll_louhao;
    @BindView(R.id.ll_fanghao)
    LinearLayout ll_fanghao;
    @BindView(R.id.ll_danyuan)
    LinearLayout ll_danyuan;
    @BindView(R.id.tv_queding)
    TextView tv_queding;
    @BindView(R.id.tv_xiaoqu)
    TextView tv_xiaoqu;
    @BindView(R.id.tv_jiaose)
    TextView tv_jiaose;
    @BindView(R.id.tv_louhao)
    TextView tv_louhao;
    @BindView(R.id.tv_danyuan)
    TextView tv_danyuan;
    @BindView(R.id.tv_fanghao)
    TextView tv_fanghao;
    @BindView(R.id.ll_qishu)
    LinearLayout ll_qishu;
    @BindView(R.id.tv_qishu)
    TextView tv_qishu;



    private int communityId=-1;
    private int nperId=-1;
    private int floorId=-1;
    private int unitId=-1;
    private int doorId=-1;
    private int role_type=-1;



    @OnClick({R.id.rl_zhuhuxinxi_fanhui,
            R.id.rl_jilu,
            R.id.ll_sousuo,
            R.id.ll_xiaoqu,
            R.id.ll_jiaose,
            R.id.ll_louhao,
            R.id.ll_fanghao,
            R.id.tv_queding,
            R.id.ll_danyuan,
            R.id.ll_qishu})
    public void OnClick(View view){
        switch (view.getId()){
            //返回的按键
            case R.id.rl_zhuhuxinxi_fanhui:
                finish();
                break;
            //记录的按键
            case R.id.rl_jilu:
                break;
            //搜索的按键
            case R.id.ll_sousuo:
                startActivity(SearchActivity.class);
                break;
            //选择小区的按键
            case R.id.ll_xiaoqu:
                selectXiaoQu();
                break;
            case R.id.ll_qishu:
                if (communityId!=-1){
                    selectNper();
                }else {
                    showToast("请先选择小区");
                }
                break;
            //选择角色的按键
            case R.id.ll_jiaose:
                List<String> mList=new ArrayList<>();
                mList.add("租户");
                mList.add("业主");


                ListViewDialog.showListDialog(this, mList, new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {
                        if (item.equals("租户")){
                            role_type=1;
                        }else {
                            role_type=0;
                        }
                        tv_jiaose.setText(item);

                    }
                });
                break;
            //选择楼号的按键
            case R.id.ll_louhao:
                if (communityId!=-1&&nperId!=-1){
                    selectFloor();
                }else {
                    if (communityId == -1) {
                        showToast("请先选择小区");
                        return;
                    }
                    if (nperId == -1) {
                        showToast("请先选择期数");
                        return;
                    }
                }

//                ListViewDialog.showListDialog(this, TestUtil.getData(), new ListViewDialog.OnSelectItem() {
//                    @Override
//                    public void onSelectItem(String item) {
//                        tv_louhao.setText(item);
//
//                    }
//                });
                break;
            //选择单元的按键
            case R.id.ll_danyuan:

                if (communityId!=-1&&nperId!=-1&&floorId!=-1){
                    selectUnit();
                }else {
                    if (communityId == -1) {
                        showToast("请先选择小区");
                        return;
                    }
                    if (nperId == -1) {
                        showToast("请先选择期数");
                        return;
                    }
                    if (floorId == -1) {
                        showToast("请先选择楼号");
                        return;
                    }
                }
                break;
            //选择房号的按键
            case R.id.ll_fanghao:
                if (communityId!=-1&&nperId!=-1&&floorId!=-1){
                    selectDoor();
                }else {
                    if (communityId == -1) {
                        showToast("请先选择小区");
                        return;
                    }
                    if (nperId == -1) {
                        showToast("请先选择期数");
                        return;
                    }
                    if (floorId == -1) {
                        showToast("请先选择楼号");
                        return;
                    }
                    if (unitId == -1) {
                        showToast("请先选择单元");
                        return;
                    }
                }
                break;
            //确定的按键
            case R.id.tv_queding:
                Intent intent=new Intent(this,ZhuHuXinXiListActivity.class);
                intent.putExtra("communityId",communityId);
                intent.putExtra("nperId",nperId);
                intent.putExtra("floorId",floorId);
                intent.putExtra("unitId",unitId);
                intent.putExtra("doorId",doorId);
                intent.putExtra("role_type",role_type);
                startActivity(intent);
                break;
        }
    }

    private void selectDoor() {
        String url=URL.SELEVCT_DOOR
                +"pageNum=1"
                +"&pageSize=10"
                +"&unitid="+unitId;
        RequestCenter.all(url, SelectDoor.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                final Map<Integer,String> mCommunityMap=new HashMap<>();
                List<String> mCommunityList=new ArrayList<>();
                SelectDoor selectDoor= (SelectDoor) responseObj;
                if (selectDoor.getCode()== CodeUtil.SUCCESS){
                    for (int i=0;i<selectDoor.getObj().getList().size();i++) {
                        mCommunityMap.put(selectDoor.getObj().getList().get(i).getDoorid(),
                                selectDoor.getObj().getList().get(i).getDoorname());
                        mCommunityList.add(selectDoor.getObj().getList().get(i).getDoorname());
                    }
                    ListViewDialog.showListDialog(ZhuHuXinXiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_fanghao.setText(item);
                            doorId=getKey(mCommunityMap,item);
                        }

                    });
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }

    private void selectUnit() {
        String url=URL.SELEVCT_UNIT
                +"pageNum=1"
                +"&pageSize=10"
                +"&floorid="+floorId;
        RequestCenter.all(url, SelectUnit.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                final Map<Integer,String> mCommunityMap=new HashMap<>();
                List<String> mCommunityList=new ArrayList<>();
                SelectUnit selectUnit= (SelectUnit) responseObj;
                if (selectUnit.getCode()== CodeUtil.SUCCESS){
                    for (int i=0;i<selectUnit.getObj().getList().size();i++) {
                        mCommunityMap.put(selectUnit.getObj().getList().get(i).getUnitid(),
                                selectUnit.getObj().getList().get(i).getUnitname());
                        mCommunityList.add(selectUnit.getObj().getList().get(i).getUnitname());
                    }
                    ListViewDialog.showListDialog(ZhuHuXinXiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_danyuan.setText(item);
                            unitId=getKey(mCommunityMap,item);
                            doorId=-1;
                            tv_fanghao.setText("请选择");
                        }

                    });
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });

    }

    private void selectFloor() {
        String url=URL.SELEVCT_FOOLR
                +"pageNum=1"
                +"&pageSize=10"
                +"&nperid="+nperId;
        RequestCenter.all(url, SelectFloor.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                final Map<Integer,String> mCommunityMap=new HashMap<>();
                List<String> mCommunityList=new ArrayList<>();
                SelectFloor selectFloor= (SelectFloor) responseObj;
                if (selectFloor.getCode()== CodeUtil.SUCCESS){
                    for (int i=0;i<selectFloor.getObj().size();i++) {
                        mCommunityMap.put(selectFloor.getObj().get(i).getFloorid(),
                                selectFloor.getObj().get(i).getFloorname());
                        mCommunityList.add(selectFloor.getObj().get(i).getFloorname());
                    }
                    ListViewDialog.showListDialog(ZhuHuXinXiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_louhao.setText(item);
                            floorId=getKey(mCommunityMap,item);
                            unitId=-1;
                            doorId=-1;
                            tv_danyuan.setText("请选择");
                            tv_fanghao.setText("请选择");
                        }

                    });
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }

    private void selectNper() {
        String url=URL.SELEVCT_NPER
                +"pageNum=1"
                +"&pageSize=10"
                +"&communityid="+communityId;
        RequestCenter.all(url, SelectNper.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                final Map<Integer,String> mCommunityMap=new HashMap<>();
                List<String> mCommunityList=new ArrayList<>();
                SelectNper selectNper= (SelectNper) responseObj;
                if (selectNper.getCode()== CodeUtil.SUCCESS){
                    for (int i=0;i<selectNper.getObj().getList().size();i++) {
                        mCommunityMap.put(selectNper.getObj().getList().get(i).getNperid(),
                                selectNper.getObj().getList().get(i).getNpername());
                        mCommunityList.add(selectNper.getObj().getList().get(i).getNpername());
                    }
                    ListViewDialog.showListDialog(ZhuHuXinXiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_qishu.setText(item);
                            nperId=getKey(mCommunityMap,item);
                            floorId=-1;
                            unitId=-1;
                            doorId=-1;
                            tv_louhao.setText("请选择");
                            tv_danyuan.setText("请选择");
                            tv_fanghao.setText("请选择");
                        }

                    });
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });


    }

    private void selectXiaoQu() {

        String url=URL.FINDCOMMUNTITY
                +"pageNum=1"
                +"&pageSize=10";
        RequestCenter.all(url, FindCommunity.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                final Map<Integer,String> mCommunityMap=new HashMap<>();
                List<String> mCommunityList=new ArrayList<>();
                FindCommunity findCommunity= (FindCommunity) responseObj;
                if (findCommunity.getCode()== CodeUtil.SUCCESS){
                    for (int i=0;i<findCommunity.getObj().size();i++) {
                        mCommunityMap.put(findCommunity.getObj().get(i).getCommunityid(),findCommunity.getObj().get(i).getCommunityname());
                        mCommunityList.add(findCommunity.getObj().get(i).getCommunityname());
                    }
                    ListViewDialog.showListDialog(ZhuHuXinXiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_xiaoqu.setText(item);
                            communityId=getKey(mCommunityMap,item);
                            nperId=-1;
                            floorId=-1;
                            unitId=-1;
                            doorId=-1;
                            tv_qishu.setText("请选择");
                            tv_louhao.setText("请选择");
                            tv_danyuan.setText("请选择");
                            tv_fanghao.setText("请选择");

                        }

                    });
                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });





//

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_zhuhuxinxi;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);

    }



    public  int getKey(Map<Integer,String> map,String value){
        int  key = 0;
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for(Integer getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                key = getKey;
            }
        }
        return key;
        //这个key肯定是最后一个满足该条件的key.
    }

}
