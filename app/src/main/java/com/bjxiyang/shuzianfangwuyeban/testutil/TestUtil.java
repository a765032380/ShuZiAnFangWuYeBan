package com.bjxiyang.shuzianfangwuyeban.testutil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gll on 2017/11/7.
 */

public class TestUtil {

    public static List<String> getData() {
        List mList=new ArrayList();
        for (int i=0;i<10;i++){
            mList.add("测试数据"+i);
        }
        return mList;
    }
    public static List<String> getData(int j) {
        List mList=new ArrayList();
        for (int i=0;i<j;i++){
            mList.add("测试数据"+i);
        }
        return mList;
    }
}
