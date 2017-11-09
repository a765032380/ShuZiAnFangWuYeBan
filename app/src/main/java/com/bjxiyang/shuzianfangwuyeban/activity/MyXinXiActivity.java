package com.bjxiyang.shuzianfangwuyeban.activity;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.dialog.SelectSexDialog;
import com.bjxiyang.shuzianfangwuyeban.select_date.DateUtils;
import com.bjxiyang.shuzianfangwuyeban.select_date.JudgeDate;
import com.bjxiyang.shuzianfangwuyeban.select_date.ScreenInfo;
import com.bjxiyang.shuzianfangwuyeban.select_date.WheelMain;
import com.bjxiyang.shuzianfangwuyeban.view.CircleImageView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/2.
 */

public class MyXinXiActivity extends MySwipeBackActivity implements View.OnClickListener{

    @BindView(R.id.ll_gerenxinxi_touxiang)
    LinearLayout ll_gerenxinxi_touxiang;
    @BindView(R.id.ll_nickname)
    LinearLayout ll_nickname;
    @BindView(R.id.ll_gerenxinxi_tel)
    LinearLayout ll_gerenxinxi_tel;
    @BindView(R.id.ll_gerenxinxi_sex)
    LinearLayout ll_gerenxinxi_sex;
    @BindView(R.id.ll_gerenxinxi_sehngri)
    LinearLayout ll_gerenxinxi_sehngri;
    @BindView(R.id.iv_touxiang)
    CircleImageView iv_touxiang;
    @BindView(R.id.tv_gerenxinxi_name)
    TextView tv_gerenxinxi_name;
    @BindView(R.id.tv_gerenxinxi_dinahua)
    TextView tv_gerenxinxi_dinahua;
    @BindView(R.id.tv_gerenxinxi_sex)
    TextView tv_gerenxinxi_sex;
    @BindView(R.id.tv_gerenxinxi_shengri)
    TextView tv_gerenxinxi_shengri;
    @BindView(R.id.rl_gerenxinxi_fanhui)
    RelativeLayout rl_gerenxinxi_fanhui;
    @BindView(R.id.ll_gerenxinxi)
    LinearLayout ll_gerenxinxi;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_gerenxinxi;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
    }


    @OnClick({R.id.rl_gerenxinxi_fanhui,
            R.id.ll_gerenxinxi_touxiang,
            R.id.ll_nickname,
            R.id.ll_gerenxinxi_tel,
            R.id.ll_gerenxinxi_sex,
            R.id.ll_gerenxinxi_sehngri})
    public void onClick(View view) {
        switch (view.getId()){
            //返回的按键
            case R.id.rl_gerenxinxi_fanhui:
                finish();
                break;
            //头像
            case R.id.ll_gerenxinxi_touxiang:

                break;
            //昵称
            case R.id.ll_nickname:
                break;
            //电话
            case R.id.ll_gerenxinxi_tel:
                break;
            //性别
            case R.id.ll_gerenxinxi_sex:
                showSelectSexDialog();
                break;
            //生日
            case R.id.ll_gerenxinxi_sehngri:
                showBottoPopupWindow(tv_gerenxinxi_shengri);
                break;





        }
    }
    private SelectSexDialog dialog;
    private void showSelectSexDialog(){
        dialog=new SelectSexDialog(MyXinXiActivity.this);
        dialog.setOnGetSelectTime(new SelectSexDialog.OnGetSelectTime() {
            @Override
            public void getSelectTime(String selectTime) {
                tv_gerenxinxi_sex.setText(selectTime);
            }

            @Override
            public void getSelectTime_int(int selectTime_int) {
//                String url= XY_Response2.URL_UESRCENTER_UPDATEUSERINFO
//                        +"cmemberId="+ SPManager.getInstance().getString("c_memberId",null)
//                        +"&sex="+selectTime_int;
//                Log.i("lllll",selectTime_int+"");
//                RequestCenter.usercenter_updateUserInfo(url, new DisposeDataListener() {
//                    @Override
//                    public void onSuccess(Object responseObj) {
//                        FanHui2 fanHui2= (FanHui2) responseObj;
//                        if (fanHui2.getCode()==1000){
//                            MyUntil.show(MyXinXiActivity.this,"修改成功");
//                            dialog.dismiss();
//                        }else {
//                            MyUntil.show(MyXinXiActivity.this,fanHui2.getMsg());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Object reasonObj) {
//
//                    }
//                });

            }
        });
        dialog.show();
    }
    private WheelMain wheelMainDate;

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
        mPopupWindow.setOnDismissListener(new poponDismissListener());
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

                        tv.setText(DateUtils.formateString(beginTime1,DateUtils.yyyyMMdd));
                        mPopupWindow.dismiss();
                }
//                tv.setText(DateUtils.formateStringH(beginTime,DateUtils.yyyyMMddHHmm));
//                mPopupWindow.dismiss();
//                backgroundAlpha(1f);

        });
    }
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
    }
    class poponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }

    }
}
