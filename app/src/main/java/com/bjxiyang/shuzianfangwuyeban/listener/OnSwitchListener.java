package com.bjxiyang.shuzianfangwuyeban.listener;

/**
 * Created by gll on 2017/11/3.
 * 开关的回调接口
 */
public interface OnSwitchListener {
    void onSwitchChange();
    boolean onSwitchIsOpen();
}