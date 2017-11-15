package com.bjxiyang.shuzianfangwuyeban.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.UpdateMiMa;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/15.
 */

public class XiuGaiMiMaActivity extends MySwipeBackActivity {

    @BindView(R.id.et_paw)
    EditText et_paw;
    @BindView(R.id.et_new_paw)
    EditText et_new_paw;
    @BindView(R.id.et_new_paw_again)
    EditText et_new_paw_again;
    @BindView(R.id.tv_xiugai)
    TextView tv_xiugai;

    private String pwd;
    private String newPwd1;
    private String newPwd2;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_xiugaimima;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        tv_xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pwd = String.valueOf(et_paw.getText());
                newPwd1 = String.valueOf(et_new_paw.getText());
                newPwd2 = String.valueOf(et_new_paw_again.getText());

                if (!newPwd1.equals(newPwd2)){
                    showToast("两次输入密码不一致");
                    return;
                }
                String url= URL.CHANGE_PWD
                        +"oldPwd="+pwd
                        +"&newPwd="+newPwd1;
                RequestCenter.all(url, UpdateMiMa.class, new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        UpdateMiMa updateMiMa= (UpdateMiMa) responseObj;
                        if (updateMiMa.getCode()== CodeUtil.SUCCESS){
                            showToast("修改成功");
                            SPManager.getInstance().remove("PropertyId");
                            SPManager.getInstance().remove("propertyname");
                            SPManager.getInstance().remove("leader");
                            SPManager.getInstance().remove("tel");
                            SPManager.getInstance().remove("sex");
                            SPManager.getInstance().remove("birthday");
                            SPManager.getInstance().remove("headPhoneUrl");

                            MainActivity.appActivity.finish();
                            SheZhiActivity.sheZhiActivity.finish();
                            ZhangHuAnQuanActivity.zhangHuAnQuanActivity.finish();
                            startActivity(SDLoginActivity.class);
                            finish();


                        }else {
                            showToast(updateMiMa.getMsg());
                        }
                    }

                    @Override
                    public void onFailure(Object reasonObj) {

                    }
                });


            }
        });

    }
}
