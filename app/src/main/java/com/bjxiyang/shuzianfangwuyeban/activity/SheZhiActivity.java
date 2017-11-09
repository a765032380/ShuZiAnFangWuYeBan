package com.bjxiyang.shuzianfangwuyeban.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.listener.OnSwitchListener;
import com.bjxiyang.shuzianfangwuyeban.manager.DataCleanManager;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;
import com.bjxiyang.shuzianfangwuyeban.util.WechatShareUtil;
import com.bjxiyang.shuzianfangwuyeban.view.SwitchButton;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/3.
 */

public class SheZhiActivity extends MySwipeBackActivity implements View.OnClickListener{

    @BindView(R.id.rl_setting_fanhui)
    RelativeLayout rl_setting_fanhui;
    @BindView(R.id.ll_setting_safe)
    LinearLayout ll_setting_safe;
    @BindView(R.id.ll_fenxiang)
    LinearLayout ll_fenxiang;
    @BindView(R.id.ll_setting_news)
    LinearLayout ll_setting_news;
    @BindView(R.id.ll_setting_clear)
    LinearLayout ll_setting_clear;
    @BindView(R.id.ll_setting_about)
    LinearLayout ll_setting_about;
    @BindView(R.id.ll_setting_exit)
    LinearLayout ll_setting_exit;
    @BindView(R.id.tv_setting_catch)
    TextView tv_setting_catch;



    @OnClick({R.id.rl_setting_fanhui,
            R.id.ll_setting_safe,
            R.id.ll_fenxiang,
            R.id.ll_setting_news,
            R.id.ll_setting_clear,
            R.id.ll_setting_about,
            R.id.ll_setting_exit,})
    public void onClick(View view) {
        switch (view.getId()){
            //返回按键
            case R.id.rl_setting_fanhui:
                finish();
                break;
            //账户与安全
            case R.id.ll_setting_safe:
                startActivity(ZhangHuAnQuanActivity.class);
                break;
            //分享好友加入
            case R.id.ll_fenxiang:
                shareToWeChatWithWebpage(SheZhiActivity.this,"http://www.bjxiyang.com/share/","测试","我是测试数据", SendMessageToWX.Req.WXSceneSession);
                break;
            //新消息通知
            case R.id.ll_setting_news:
                startActivity(XinXiaoXiTongZhiActivity.class);
                break;
            //清理缓存
            case R.id.ll_setting_clear:
                qingChu();
                break;
            //关于数字安防
            case R.id.ll_setting_about:
                startActivity(GuanYuWoMenActivity.class);
                break;
            //退出账号
            case R.id.ll_setting_exit:
                logOut();
                break;
        }
    }

private void qingChu(){
    final AlertDialog.Builder builder = new AlertDialog.Builder(SheZhiActivity.this);
    builder.setTitle("您确定要清除缓存吗？");
    builder.setIcon(R.mipmap.ic_launcher);
    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            DataCleanManager.clearAllCache(SheZhiActivity.this);
            try {
                tv_setting_catch.setText(DataCleanManager.getTotalCacheSize(SheZhiActivity.this));
            } catch (Exception e) {
                e.printStackTrace();
            }
            builder.create();
        }
    });
    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            builder.create();
        }
    });
    builder.show();




}
private void logOut(){
    final AlertDialog.Builder builder = new AlertDialog.Builder(SheZhiActivity.this);
    builder.setTitle("您确定要退出吗？");
    builder.setIcon(R.mipmap.ic_launcher);
    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            SPManager.getInstance().remove("mobilePhone");
            SPManager.getInstance().remove("communityId_one");
            SPManager.getInstance().remove("c_memberId");
            SPManager.getInstance().remove("test_men");

        }
    });
    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            builder.create();
        }
    });
    builder.show();
}





    @Override
    protected int getContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        try {
            tv_setting_catch.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void shareToWeChatWithWebpage(Context context, String url,
                                         String title, String description, int scene) {
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(context, WechatShareUtil.WECHAT_APP_ID);

        if (!iwxapi.isWXAppInstalled()) {
            Toast.makeText(this,"请先安装微信",Toast.LENGTH_LONG).show();
            return;
        }

        WXWebpageObject wxWebpageObject = new WXWebpageObject();
        wxWebpageObject.webpageUrl = url;

        WXMediaMessage wxMediaMessage = new WXMediaMessage(wxWebpageObject);
        wxMediaMessage.mediaObject = wxWebpageObject;
        wxMediaMessage.title = title;
        wxMediaMessage.description = description;
//        wxMediaMessage.thumbData =bmpToByteArray(BitmapFactory.decodeResource(context.getResources(), R.mipmap.logo_app), true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wxMediaMessage;
        req.scene = scene;

        iwxapi.sendReq(req);
    }



}
