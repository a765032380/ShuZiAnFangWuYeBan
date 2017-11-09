package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.dialog.ListViewDialog;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;

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

    @OnClick({R.id.rl_zhuhuxinxi_fanhui,
            R.id.rl_jilu,
            R.id.ll_sousuo,
            R.id.ll_xiaoqu,
            R.id.ll_jiaose,
            R.id.ll_louhao,
            R.id.ll_fanghao,
            R.id.tv_queding,
            R.id.ll_danyuan})
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
                ListViewDialog.showListDialog(this, TestUtil.getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {
                        tv_xiaoqu.setText(item);

                    }
                });
                break;
            //选择角色的按键
            case R.id.ll_jiaose:
                ListViewDialog.showListDialog(this, TestUtil.getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {
                        tv_jiaose.setText(item);

                    }
                });
                break;
            //选择楼号的按键
            case R.id.ll_louhao:
                ListViewDialog.showListDialog(this, TestUtil.getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {
                        tv_louhao.setText(item);

                    }
                });
                break;
            //选择单元的按键
            case R.id.ll_danyuan:
                ListViewDialog.showListDialog(this, TestUtil.getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {
                        tv_danyuan.setText(item);

                    }
                });
                break;
            //选择房号的按键
            case R.id.ll_fanghao:
                ListViewDialog.showListDialog(this, TestUtil.getData(), new ListViewDialog.OnSelectItem() {
                    @Override
                    public void onSelectItem(String item) {
                        tv_fanghao.setText(item);
                    }
                });
                break;
            //确定的按键
            case R.id.tv_queding:
                startActivity(ZhuHuXinXiListActivity.class);


                break;
        }
    }





    @Override
    protected int getContentViewId() {
        return R.layout.activity_zhuhuxinxi;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);

    }
}
