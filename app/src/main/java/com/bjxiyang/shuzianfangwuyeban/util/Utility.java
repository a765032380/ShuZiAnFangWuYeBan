package com.bjxiyang.shuzianfangwuyeban.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by gll on 2017/11/7.
 * 解决ListView嵌套ListView的问题的工具类
 */

public class Utility {

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight =totalHeight+ listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        params.height=totalHeight;
        params.height =(int)((totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1))));
        listView.setLayoutParams(params);
    }


}
