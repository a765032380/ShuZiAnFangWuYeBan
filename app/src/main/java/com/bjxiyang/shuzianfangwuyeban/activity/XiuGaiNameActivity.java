package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;
import com.bjxiyang.shuzianfangwuyeban.util.DialogUntil;
import com.bjxiyang.shuzianfangwuyeban.util.MyUntil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class XiuGaiNameActivity extends MySwipeBackActivity implements View.OnClickListener {

    @BindView(R.id.rl_username_fanghui)
    RelativeLayout rl_username_fanghui;
    @BindView(R.id.tv_baocun)
    TextView tv_baocun;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.ll_username_delete)
    LinearLayout ll_username_delete;
    @BindView(R.id.tv_title)
    TextView tv_title;

    private String name;
    private String realname;
    private int type;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_username;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        type=intent.getIntExtra("type",0);
        realname=intent.getStringExtra("realname");
        if (type==0){
            et_name.setText(name+"");
            tv_title.setText("用户名");
        }else {
            et_name.setText(realname+"");
            tv_title.setText("真实姓名");
        }

        rl_username_fanghui.setOnClickListener(this);
        tv_baocun.setOnClickListener(this);
        ll_username_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //返回的按键
            case R.id.rl_username_fanghui:
                finish();
                break;
            //保存的按键
            case R.id.tv_baocun:
                name= String.valueOf(et_name.getText());
                if (name==null||name.equals("")){
                    MyUntil.show(XiuGaiNameActivity.this,"请输入用户名");
                    break;
                }

                Intent mIntent = new Intent();
                if (type==0) {
//                    mIntent.putExtra("name", name);
//                    SPManager.getInstance().putString("nickName", name);
                }else {
//                    mIntent.putExtra("realname", name);
//                    SPManager.getInstance().putString("realname", name);
                }
//                setResult(RESULT_OK, mIntent);
//                finish();
                MyXinXiActivity.update(1,name,this);


//                DialogUntil.showLoadingDialog(this,"正在提交",false);
//                String url= XY_Response2.URL_UESRCENTER_UPDATEUSERINFO1
//                        +"cmemberId="+ SPManager.getInstance().getString("c_memberId",null)
//                        +"&name="+name
//                        +"&type="+type;
//                RequestCenter.usercenter_updateUserInfo(url, new DisposeDataListener() {
//                    @Override
//                    public void onSuccess(Object responseObj) {
//                        DialogUntil.closeLoadingDialog();
//                        FanHui2 fanHui2= (FanHui2) responseObj;
//                        if (fanHui2.getCode()==1000){
//                            MyUntil.show(XiuGaiNameActivity.this,"修改成功");
//
//
//                            // 设置结果，并进行传送
//
//                            finish();
//                        }else {
//                            DialogUntil.closeLoadingDialog();
//                            MyUntil.show(XiuGaiNameActivity.this,fanHui2.getMsg());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Object reasonObj) {
//                        DialogUntil.closeLoadingDialog();
//                    }
//                });



                break;
            //清空名字的按键
            case R.id.ll_username_delete:
                et_name.setText("");
                break;



        }
    }
}
