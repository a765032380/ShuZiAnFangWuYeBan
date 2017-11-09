package com.bjxiyang.shuzianfangwuyeban.fragment_main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baisi.imoocsdk.imageloader.ImageLoaderManager;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.activity.SearchActivity;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyFragmentAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.fragment_home.FragmentFour;
import com.bjxiyang.shuzianfangwuyeban.fragment_home.FragmentOne;
import com.bjxiyang.shuzianfangwuyeban.fragment_home.FragmentThree;
import com.bjxiyang.shuzianfangwuyeban.fragment_home.FragmentTwo;
import com.bjxiyang.shuzianfangwuyeban.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gll on 2017/11/2.
 */

public class DaiBanFragment extends BaseFragment {
    private ListView lv_mListView;
    private List<String> mList;
    private static final String QUANBU="全部";
    private static final String FANKUI="物业反馈";
    private static final String WEIXIU="维修";
    private static final String WUYEFEI="物业费";

    private RelativeLayout rl_jinrong_fanhui;
    private View view;
    private Context mContext;
    private MyFragmentAdapter mMyFragmentAdapter;
    //声明ViewPager
    private ViewPager mViewPager;
    //ViewPager的指示器
    private PagerTabStrip mPagerTabStrip;
    //储存ViewPager的指示器文本内容的集合
    private List<String> mTitleList;
    //储存Fragment的集合
    private List<Fragment> mFragmentList;
    //Fragment管理者
    private FragmentManager fm;

    private PagerSlidingTabStrip tabs;



    public static DaiBanFragment newInstance() {
        return new DaiBanFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        //实例化UI
        mViewPager = view.findViewById(R.id.pager);
//        mPagerTabStrip= (PagerTabStrip)view. findViewById(R.id.tab);
        //实例化Fragment管理者
        fm=getChildFragmentManager();
        //实例化集合
        mTitleList=new ArrayList<>();
        mFragmentList=new ArrayList<>();
        //获取数据源
        getData();
        //实例化适配器

        mMyFragmentAdapter=new MyFragmentAdapter(fm,mFragmentList,mTitleList);
        //加载适配器
        mViewPager.setAdapter(mMyFragmentAdapter);
        tabs= (PagerSlidingTabStrip)view.findViewById(R.id.tabs);
        tabs.setViewPager(mViewPager);
        initUI(view);



    }

    private void initUI(View view) {

    }

    private void getData(){
        mTitleList.add(QUANBU);
        mTitleList.add(FANKUI);
        mTitleList.add(WEIXIU);
        mTitleList.add(WUYEFEI);

        mFragmentList.add(new FragmentOne());
        mFragmentList.add(new FragmentTwo());
        mFragmentList.add(new FragmentThree());
        mFragmentList.add(new FragmentFour());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daiban;
    }
}
