package com.bjxiyang.shuzianfangwuyeban.activity;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/3.
 */

public class ZhangHuAnQuanActivity extends MySwipeBackActivity implements View.OnClickListener {

    private static final String WEIXIN_APP_ID="wxfe7d0b3660506256";
    private static final String WEIXIN_SCOPE="snsapi_userinfo";
    private static final String WEIXIN_STATE="wechat_sdk_update";


    @BindView(R.id.rl_safe_fanhui)
    RelativeLayout rl_safe_fanhui;
    @BindView(R.id.ll_safe_xiugai)
    LinearLayout ll_safe_xiugai;
    @BindView(R.id.ll_safe_wechat)
    LinearLayout ll_safe_wechat;
    @BindView(R.id.tv_safe_dinahua)
    TextView tv_safe_dinahua;
    @BindView(R.id.tv_safe_sex)
    TextView tv_safe_sex;

    @OnClick({R.id.rl_safe_fanhui,
            R.id.ll_safe_xiugai,
            R.id.ll_safe_wechat,})
    public void onClick(View view) {
        switch (view.getId()){
            //返回按键
            case R.id.rl_safe_fanhui:
                finish();
                break;
            //修改手机号
            case R.id.ll_safe_xiugai:
                startActivity(GengGaiPhoneActivity.class);
                break;
            //绑定微信
            case R.id.ll_safe_wechat:
                loginWithWeixin();
                break;

        }

    }


    private IWXAPI mWeixinAPI;
    private void loginWithWeixin() {
        if (mWeixinAPI == null) {
            mWeixinAPI = WXAPIFactory.createWXAPI(this, WEIXIN_APP_ID, false);
        }

        if (!mWeixinAPI.isWXAppInstalled()) {
            showToast("请先安装微信");
            //提醒用户没有按照微信
            return;
        }

        mWeixinAPI.registerApp(WEIXIN_APP_ID);

        SendAuth.Req req = new SendAuth.Req();
        req.scope = WEIXIN_SCOPE;
        req.state = WEIXIN_STATE;
        boolean b=mWeixinAPI.sendReq(req);
        finish();
        Log.i("LLLL",b+"");
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_zhanghuanquan;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
    }


}
