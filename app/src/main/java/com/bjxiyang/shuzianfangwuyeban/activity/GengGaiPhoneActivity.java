package com.bjxiyang.shuzianfangwuyeban.activity;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bjxiyang.shuzianfangwuyeban.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/3.
 */

public class GengGaiPhoneActivity extends MySwipeBackActivity implements View.OnClickListener {
    @BindView(R.id.et_newTel)
    EditText et_newTel;
    @BindView(R.id.et_yanzhengma)
    EditText et_yanzhengma;
    @BindView(R.id.tv_sendyanzhengma)
    TextView tv_sendyanzhengma;
    @BindView(R.id.tv_changeTel_tijiao)
    TextView tv_changeTel_tijiao;
    @BindView(R.id.rl_changeTel_fanhui)
    RelativeLayout rl_changeTel_fanhui;

    private int timeCount = 60;
    private Timer mtimer;
    private boolean isOne=false;
    private boolean isTwo=false;





    @OnClick({R.id.tv_changeTel_tijiao,R.id.tv_sendyanzhengma,R.id.rl_changeTel_fanhui})
    public void onClick(View view) {
        switch (view.getId()){
            //提交的按键
            case R.id.tv_changeTel_tijiao:
                tiJiao();
                break;
            //发送短信的按键
            case R.id.tv_sendyanzhengma:
                sendMSM();
                break;
            //返回的按键
            case R.id.rl_changeTel_fanhui:
                finish();
                break;
        }

    }

    private void pandun(){
        et_newTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()==11){
                    isOne=true;
                    if (isOne&&isTwo) {
                        tv_changeTel_tijiao.setBackgroundResource(R.drawable.conners_5dp_2764ff);
                        tv_changeTel_tijiao.setEnabled(true);
                        tv_changeTel_tijiao.setTextColor(0xfff1f1f1);
                    }
                }else {
                    isOne=false;
                    tv_changeTel_tijiao.setTextColor(0xfff1f1f1);
                    tv_changeTel_tijiao.setBackgroundResource(R.drawable.conners_5dp_f1f1f1);
                    tv_changeTel_tijiao.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_yanzhengma.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()==6){
                    isTwo=true;
                    if (isOne&&isTwo) {
                        tv_changeTel_tijiao.setBackgroundResource(R.drawable.conners_5dp_2764ff);
                        tv_changeTel_tijiao.setTextColor(0xfff1f1f1);
                        tv_changeTel_tijiao.setEnabled(true);
                    }
                }else {
                    isTwo=false;
                    tv_changeTel_tijiao.setTextColor(0xfff1f1f1);
                    tv_changeTel_tijiao.setBackgroundResource(R.drawable.conners_5dp_f1f1f1);
                    tv_changeTel_tijiao.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    private void sendMSM(){
        timeCount=60;
        startCountdown();

    }
    private void tiJiao(){

    }

    //倒计时的方法
    public void setTimerTask(){
        mtimer = new Timer();
        mtimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                timerHandler.sendMessage(message);
            }
        },1000,1000);
    }
    private Handler timerHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                timeCount --;
                if (timeCount >= 0){
                    changeSmsButton();
                }else{
                    mtimer.cancel();
                    tv_sendyanzhengma.setEnabled(true);
                    tv_sendyanzhengma.setText(R.string.getsmsversion);
                }
            }
        }
    };
    //在倒计时的时候,对按钮上的字进行赋值
    public void changeSmsButton(){
        tv_sendyanzhengma.setText(timeCount + "秒重发");

    }
    //开始倒计时
    public void startCountdown(){
        changeSmsButton();
        tv_sendyanzhengma.setEnabled(false);
        setTimerTask();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_genggaishoujihao;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        pandun();

    }

}
