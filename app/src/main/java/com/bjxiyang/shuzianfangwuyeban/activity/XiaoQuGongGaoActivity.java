package com.bjxiyang.shuzianfangwuyeban.activity;

import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;

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
        mListView_right.setAdapter(new MyBaseAdapter<String>(this, TestUtil.getData(),R.layout.item_item_lishigonggao) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_gonggao,item);
            }
        });

    }
}
