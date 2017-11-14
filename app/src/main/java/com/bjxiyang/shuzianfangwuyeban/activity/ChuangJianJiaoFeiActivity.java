package com.bjxiyang.shuzianfangwuyeban.activity;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.AddOrder;
import com.bjxiyang.shuzianfangwuyeban.bean.FindCommunity;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectDoor;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectFloor;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectNper;
import com.bjxiyang.shuzianfangwuyeban.bean.SelectUnit;
import com.bjxiyang.shuzianfangwuyeban.dialog.ListViewDialog;
import com.bjxiyang.shuzianfangwuyeban.select_date.DateUtils;
import com.bjxiyang.shuzianfangwuyeban.select_date.JudgeDate;
import com.bjxiyang.shuzianfangwuyeban.select_date.ScreenInfo;
import com.bjxiyang.shuzianfangwuyeban.select_date.WheelMain;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/14.
 */

public class ChuangJianJiaoFeiActivity extends MySwipeBackActivity implements View.OnClickListener {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_chuangjianjiaofei;
    }


    @BindView(R.id.iv_chuangjianjiaofei_fanhui)
    RelativeLayout iv_chuangjianjiaofei_fanhui;
    @BindView(R.id.ll_danweimianji)
    LinearLayout ll_danweimianji;
    @BindView(R.id.ll_louhao1)
    LinearLayout ll_louhao1;
    @BindView(R.id.ll_louhao_xiaoqu)
    LinearLayout ll_louhao_xiaoqu;
    @BindView(R.id.ll_louhao_louhao)
    LinearLayout ll_louhao_louhao;
    @BindView(R.id.ll_danyuan)
    LinearLayout ll_danyuan;
    @BindView(R.id.ll_louhao_fanghao)
    LinearLayout ll_louhao_fanghao;
    @BindView(R.id.ll_louhao_time)
    LinearLayout ll_louhao_time;
    @BindView(R.id.ll_louhao_endtime)
    LinearLayout ll_louhao_endtime;
    @BindView(R.id.tv_louhao_xiaoqu)
    TextView tv_louhao_xiaoqu;
    @BindView(R.id.tv_louhao_louhao)
    TextView tv_louhao_louhao;
    @BindView(R.id.tv_louhao_danyuan)
    TextView tv_louhao_danyuan;
    @BindView(R.id.tv_louhao_fanghao)
    TextView tv_louhao_fanghao;
    @BindView(R.id.tv_louhao_time)
    TextView tv_louhao_time;
    @BindView(R.id.tv_louhao_endtime)
    TextView tv_louhao_endtime;
    @BindView(R.id.tv_louhao_tijiao)
    TextView tv_louhao_tijiao;
    @BindView(R.id.ed_louhao_money)
    EditText ed_louhao_money;
    @BindView(R.id.et_louhao_beizhu)
    EditText et_louhao_beizhu;
    @BindView(R.id.ll_xiaoqu)
    LinearLayout ll_xiaoqu;
    @BindView(R.id.et_shezhijine)
    EditText et_shezhijine;
    @BindView(R.id.tv_xiaoqu)
    TextView tv_xiaoqu;
    @BindView(R.id.ll_jiezhishijiann)
    LinearLayout ll_jiezhishijiann;
    @BindView(R.id.tv_jiezhishijiann)
    TextView tv_jiezhishijiann;
    @BindView(R.id.et_beizhu)
    EditText et_beizhu;
    @BindView(R.id.tv_tijiao)
    TextView tv_tijiao;
    @BindView(R.id.tv_danweimianji)
    TextView tv_danweimianji;
    @BindView(R.id.tv_louhao1)
    TextView tv_louhao1;
    @BindView(R.id.view_danweimianji)
    View view_danweimianji;
    @BindView(R.id.view_louhao1)
    View view_louhao1;
    @BindView(R.id.sc_danweimianji)
    ScrollView sc_danweimianji;
    @BindView(R.id.sc_louhao)
    ScrollView sc_louhao;
    @BindView(R.id.ll_louhao_qiqu)
    LinearLayout ll_louhao_qiqu;
    @BindView(R.id.tv_louhao_qiqu)
    TextView tv_louhao_qiqu;


    private int communityId=-1;
    private int nperId=-1;
    private int floorId=-1;
    private int unitId=-1;
    private int doorId=-1;
    private String mobilePhone;
    private String rentMoney;
    private String note;
    private String takeTime;
    private String realName;
    private WheelMain wheelMainDate;
    @OnClick({R.id.iv_chuangjianjiaofei_fanhui,
            R.id.ll_danweimianji,
            R.id.ll_louhao1,
            R.id.ll_louhao_xiaoqu,
            R.id.ll_louhao_louhao,
            R.id.ll_danyuan,
            R.id.ll_louhao_fanghao,
            R.id.ll_louhao_time,
            R.id.tv_louhao_tijiao,
            R.id.ll_louhao_endtime,
            R.id.ll_xiaoqu,
            R.id.ll_jiezhishijiann,
            R.id.tv_tijiao,
            R.id.tv_louhao_qiqu
    })
    public void onClick(View view) {
        switch (view.getId()){
            //返回
            case R.id.iv_chuangjianjiaofei_fanhui:
                break;
                //显示单位面积
            case R.id.ll_danweimianji:
                showDanWeiMianJi();
                break;
                //显示楼号
            case R.id.ll_louhao1:
                showLouHao();
                break;
                //小区
            case R.id.ll_louhao_xiaoqu:
                showXiaoQu();
                break;
                //期数
            case R.id.tv_louhao_qiqu:
                showQiShu();
                break;
                //楼号
            case R.id.ll_louhao_louhao:
                showLouHaoList();
                break;
                //单元
            case R.id.ll_danyuan:
                showDanYuan();
                break;
                //房号
            case R.id.ll_louhao_fanghao:
                showFangHao();
                break;
                //时间
            case R.id.ll_louhao_time:
                showTime(tv_louhao_time);
                break;
                //提交
            case R.id.tv_louhao_tijiao:
                tiJiao1();
                break;
                //截止时间
            case R.id.ll_louhao_endtime:
                showTime(tv_louhao_endtime);
                break;
                //选择小区2
            case R.id.ll_xiaoqu:
                showXiaoQu();
                break;
                //截止时间2
            case R.id.ll_jiezhishijiann:
                break;
                //提交2
            case R.id.tv_tijiao:
                break;
        }

    }
    private void showLouHao(){
        sc_danweimianji.setVisibility(View.VISIBLE);
        sc_louhao.setVisibility(View.VISIBLE);
        tv_danweimianji.setTextColor(0xff909090);
        tv_louhao1.setTextColor(0xff323232);
        view_louhao1.setVisibility(View.VISIBLE);
        view_danweimianji.setVisibility(View.INVISIBLE);




    }
    private void showDanWeiMianJi(){
        sc_danweimianji.setVisibility(View.GONE);
        sc_louhao.setVisibility(View.VISIBLE);
        tv_danweimianji.setTextColor(0xff323232);
        tv_louhao1.setTextColor(0xff909090);
        view_louhao1.setVisibility(View.INVISIBLE);
        view_danweimianji.setVisibility(View.VISIBLE);
    }
    private void showXiaoQu(){
        selectXiaoQu();
    }
    private void showQiShu(){
        if (communityId!=-1){
            selectNper();
        }else {
            showToast("请先选择小区");
        }
    }
    private void showLouHaoList(){
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
    }
    private void showDanYuan(){
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
    }
    private void showFangHao(){
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
    }
    private void selectDoor() {
        String url= URL.SELEVCT_DOOR
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
                    ListViewDialog.showListDialog(ChuangJianJiaoFeiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_louhao_fanghao.setText(item);
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
                    ListViewDialog.showListDialog(ChuangJianJiaoFeiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_louhao_danyuan.setText(item);
                            unitId=getKey(mCommunityMap,item);
                            doorId=-1;
                            tv_louhao_fanghao.setText("请选择");
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
                    ListViewDialog.showListDialog(ChuangJianJiaoFeiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_louhao_louhao.setText(item);
                            floorId=getKey(mCommunityMap,item);
                            unitId=-1;
                            doorId=-1;
                            tv_louhao_danyuan.setText("请选择");
                            tv_louhao_fanghao.setText("请选择");
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
                    ListViewDialog.showListDialog(ChuangJianJiaoFeiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_louhao_qiqu.setText(item);
                            nperId=getKey(mCommunityMap,item);
                            floorId=-1;
                            unitId=-1;
                            doorId=-1;
                            tv_louhao_louhao.setText("请选择");
                            tv_louhao_danyuan.setText("请选择");
                            tv_louhao_fanghao.setText("请选择");
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
                    ListViewDialog.showListDialog(ChuangJianJiaoFeiActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_louhao_xiaoqu.setText(item);
                            communityId=getKey(mCommunityMap,item);
                            nperId=-1;
                            floorId=-1;
                            unitId=-1;
                            doorId=-1;
                            tv_louhao_qiqu.setText("请选择");
                            tv_louhao_louhao.setText("请选择");
                            tv_louhao_danyuan.setText("请选择");
                            tv_louhao_fanghao.setText("请选择");

                        }

                    });
                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
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
    private void showTime(TextView tv){
        showBottoPopupWindow(tv);
    }
    public void showBottoPopupWindow(final TextView tv) {
        WindowManager manager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        View menuView = LayoutInflater.from(this).inflate(R.layout.show_popup_window,null);
        final PopupWindow mPopupWindow = new PopupWindow(menuView, (int)(width*0.8),
                ActionBar.LayoutParams.WRAP_CONTENT);
        ScreenInfo screenInfoDate = new ScreenInfo(this);
        wheelMainDate = new WheelMain(menuView, true);
        wheelMainDate.screenheight = screenInfoDate.getHeight();
        String time = DateUtils.currentMonth().toString();
        Calendar calendar = Calendar.getInstance();
        if (JudgeDate.isDate(time, "yyyy-MM-DD")) {
            try {
                calendar.setTime(new Date(time));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelMainDate.initDateTimePicker(year, month, day, hours,minute);
        mPopupWindow.setAnimationStyle(R.style.AnimationPreview);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        //动画
        mPopupWindow.showAtLocation(tv, Gravity.CENTER, 0, 0);
//        mPopupWindow.setOnDismissListener(new MyXinXiActivity.poponDismissListener());
//        backgroundAlpha(0.6f);
        TextView tv_cancle = (TextView) menuView.findViewById(R.id.tv_cancle);
        TextView tv_ensure = (TextView) menuView.findViewById(R.id.tv_ensure);
        TextView tv_pop_title = (TextView) menuView.findViewById(R.id.tv_pop_title);
        tv_pop_title.setText("请选择您的生日");
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mPopupWindow.dismiss();
//                backgroundAlpha(1f);
            }
        });
        tv_ensure.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String beginTime1 = wheelMainDate.getTime().toString();
//                        String sp[] = beginTime1.split(" ");

                tv.setText(DateUtils.formateString(beginTime1,DateUtils.yyyyMMdd));
                mPopupWindow.dismiss();
            }
//                tv.setText(DateUtils.formateStringH(beginTime,DateUtils.yyyyMMddHHmm));
//                mPopupWindow.dismiss();
//                backgroundAlpha(1f);

        });
    }
    private void tiJiao1(){
        rentMoney= String.valueOf(ed_louhao_money.getText());
        note= String.valueOf(et_louhao_beizhu.getText());
        takeTime= String.valueOf(tv_louhao_time.getText());


        String url=URL.ADDORDER_ORDER
                +"communityId="+communityId
                +"&nperId="+nperId
                +"&floorId="+floorId
                +"&unitId="+unitId
                +"&doorId="+doorId
                +"&mobilePhone="
                +"&rentMoney="
                +"&note="
                +"&takeTime="
                +"&realName=";
        RequestCenter.all(url, AddOrder.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }




    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        showDanWeiMianJi();
    }


}
