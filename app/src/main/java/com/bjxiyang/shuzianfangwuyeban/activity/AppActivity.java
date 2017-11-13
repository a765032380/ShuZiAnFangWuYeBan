package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.DaiBanFragment;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.GeRenFragment;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.GongZuoFragment;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/2.
 */
public abstract class AppActivity extends BaseActivity {
    public static AppActivity appActivity;

    private final static int BLUE=0xFF3469ff;
    private final static int COLOER90=0xFF909090;

    @BindView(R.id.ll_daiban)
    LinearLayout ll_daiban;
    @BindView(R.id.ll_gongzuo)
    LinearLayout ll_gongzuo;
    @BindView(R.id.ll_mine)
    LinearLayout ll_mine;
    @BindView(R.id.iv_daiban)
    ImageView iv_daiban;
    @BindView(R.id.iv_gongzuo)
    ImageView iv_gongzuo;
    @BindView(R.id.iv_mine)
    ImageView iv_mine;
    @BindView(R.id.tv_daiban)
    TextView tv_daiban;
    @BindView(R.id.tv_gongzuo)
    TextView tv_gongzuo;
    @BindView(R.id.tv_mine)
    TextView tv_mine;


    //获取第一个fragment
    protected abstract BaseFragment getFirstFragment();

    //获取Intent
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        appActivity=this;




        ButterKnife.bind(this);
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        ll_daiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDaiBan();
                addFragment(DaiBanFragment.newInstance());

            }
        });

        ll_gongzuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGongZuo();
                addFragment(GongZuoFragment.newInstance());
            }
        });
        ll_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWoDe();
                addFragment(GeRenFragment.newInstance());
            }
        });


        //避免重复添加Fragment
        Log.i("LLLL",getSupportFragmentManager().getFragments().size()+"++");
        if (null == getSupportFragmentManager().getFragments()
                ||getSupportFragmentManager().getFragments().size()==0) {
            BaseFragment firstFragment = getFirstFragment();

            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }

    private void showDaiBan(){
        iv_daiban.setBackgroundResource(R.drawable.a_icon_daiban_pre);
        iv_gongzuo.setBackgroundResource(R.drawable.a_icon_gongzuo);
        iv_mine.setBackgroundResource(R.drawable.a_icon_wode);
        tv_daiban.setTextColor(BLUE);
        tv_gongzuo.setTextColor(COLOER90);
        tv_mine.setTextColor(COLOER90);
    }
    private void showGongZuo(){
        iv_daiban.setBackgroundResource(R.drawable.a_icon_daiban);
        iv_gongzuo.setBackgroundResource(R.drawable.a_icon_gongzuo_pre);
        iv_mine.setBackgroundResource(R.drawable.a_icon_wode);
        tv_daiban.setTextColor(COLOER90);
        tv_gongzuo.setTextColor(BLUE);
        tv_mine.setTextColor(COLOER90);
    }

    private void showWoDe(){
        iv_daiban.setBackgroundResource(R.drawable.a_icon_daiban);
        iv_gongzuo.setBackgroundResource(R.drawable.a_icon_gongzuo);
        iv_mine.setBackgroundResource(R.drawable.a_icon_wode_pre);
        tv_daiban.setTextColor(COLOER90);
        tv_gongzuo.setTextColor(COLOER90);
        tv_mine.setTextColor(BLUE);
    }




}