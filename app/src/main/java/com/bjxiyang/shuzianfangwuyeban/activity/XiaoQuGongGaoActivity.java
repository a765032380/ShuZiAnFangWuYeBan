package com.bjxiyang.shuzianfangwuyeban.activity;

import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.XiaoQuGongGaoList;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/7.
 */

public class XiaoQuGongGaoActivity extends MySwipeBackActivity {
    @BindView(R.id.rl_xiaoqugonggao_fanhui)
    RelativeLayout rl_xiaoqugonggao_fanhui;
    @BindView(R.id.rl_xiaoqugonggao_jilu)
    RelativeLayout rl_xiaoqugonggao_jilu;
    @BindView(R.id.ed_biaoti)
    EditText ed_biaoti;
    @BindView(R.id.ed_neirong)
    EditText ed_neirong;
    @BindView(R.id.tv_queding)
    TextView tv_queding;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.mListView_right)
    ListView mListView_right;



    private String neirong;
    private String biaoti;
    private List<XiaoQuGongGaoList.ObjBean.ListBean> mList;

    @OnClick({R.id.rl_xiaoqugonggao_fanhui,
            R.id.rl_xiaoqugonggao_jilu,
            R.id.tv_queding,
            R.id.drawerlayout})
    public void OnClick(View view){
        switch (view.getId()){
            //返回的按键
            case R.id.rl_xiaoqugonggao_fanhui:
                finish();
                break;
            //记录的按键
            case R.id.rl_xiaoqugonggao_jilu:
                drawerlayout.openDrawer(Gravity.RIGHT);
                break;
            //确认的按键
            case R.id.tv_queding:
                biaoti= String.valueOf(ed_biaoti.getText());
                neirong=String.valueOf(ed_neirong.getText());
                break;
        }
    }






    @Override
    protected int getContentViewId() {
        return R.layout.activity_xiaoqugonggao;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        getdata();



    }
    private void getdata(){

        String url= URL.PROPERTYFUNCTIONS_NOTICE_SELECT
                +"pageNum="+1+"&pageSize="+5+"&search=";
        RequestCenter.all(url, XiaoQuGongGaoList.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                XiaoQuGongGaoList xiaoQuGongGaoList= (XiaoQuGongGaoList) responseObj;
                if (xiaoQuGongGaoList.getCode()== CodeUtil.SUCCESS){
                    mList=xiaoQuGongGaoList.getObj().getList();
                    mListView_right.setAdapter(new MyBaseAdapter<XiaoQuGongGaoList.ObjBean.ListBean>(
                            XiaoQuGongGaoActivity.this, mList,R.layout.item_item_lishigonggao) {
                        @Override
                        public void convert(ViewHolder helper, XiaoQuGongGaoList.ObjBean.ListBean item) {
                            helper.setText(R.id.tv_gonggao,item.getTitle());
                            helper.setText(R.id.tv_item_gonggao_date,item.getAdd_time()+"");
                        }

//                        @Override
//                        public void convert(ViewHolder helper, String item) {
//                            helper.setText(R.id.tv_gonggao,item);
//                        }
                    });
                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });



    }



}
