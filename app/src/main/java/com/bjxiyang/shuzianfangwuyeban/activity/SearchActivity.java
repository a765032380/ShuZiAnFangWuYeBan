package com.bjxiyang.shuzianfangwuyeban.activity;


import com.bjxiyang.shuzianfangwuyeban.R;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;


/**
 * Created by gll on 2017/11/6.
 */

public class SearchActivity extends MySwipeBackActivity {

    // 1. 初始化搜索框变量
    private SearchView searchView;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_search_view;
    }

    @Override
    protected void initUI() {
        // 3. 绑定组件
        searchView = (SearchView) findViewById(R.id.search_view);

        // 4. 设置点击搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                //得到输入框的数据。进行下一步的逻辑处理

                System.out.println("我收到了" + string);
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });

    }
}
