package com.bjxiyang.shuzianfangwuyeban.fragment_main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baisi.imoocsdk.imageloader.ImageLoaderManager;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.activity.MyXinXiActivity;
import com.bjxiyang.shuzianfangwuyeban.activity.SheZhiActivity;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;
import com.bjxiyang.shuzianfangwuyeban.util.WechatShareUtil;
import com.bjxiyang.shuzianfangwuyeban.view.CircleImageView;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/2.
 */

public class GeRenFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.iv_touxiang)
    CircleImageView iv_touxiang;
    @BindView(R.id.tv_fenxinagmingpian)
    TextView tv_fenxinagmingpian;
    @BindView(R.id.ll_shezhi)
    LinearLayout ll_shezhi;
    @BindView(R.id.ll_toxinxi)
    LinearLayout ll_toxinxi;
    @BindView(R.id.tv_wuyename)
    TextView tv_wuyename;








    public static GeRenFragment newInstance() {
        return new GeRenFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        setData();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        setData();
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_geren;
    }

    @OnClick({R.id.ll_toxinxi,R.id.ll_shezhi,R.id.tv_fenxinagmingpian})
    public void onClick(View view) {
        switch (view.getId()){
            //跳转到个人信息页面
            case R.id.ll_toxinxi:
                startActivity(MyXinXiActivity.class);
                break;
            //跳转到设置页面
            case R.id.ll_shezhi:
                startActivity(SheZhiActivity.class);
                break;
            //分享我的名片
            case R.id.tv_fenxinagmingpian:
                shareToWeChatWithWebpage(getContext(),"http://www.bjxiyang.com/share/","测试","我是测试数据", SendMessageToWX.Req.WXSceneSession);
                break;
        }

    }

    public void shareToWeChatWithWebpage(Context context, String url,
                                         String title, String description, int scene) {
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(context, WechatShareUtil.WECHAT_APP_ID);

        if (!iwxapi.isWXAppInstalled()) {
            Toast.makeText(getContext(),"请先安装微信",Toast.LENGTH_LONG).show();
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

    private void setData(){
        ImageLoaderManager.getInstance(getContext())
                .displayImage(iv_touxiang, SPManager.getInstance().getString("headPhoneUrl",""));
        tv_name.setText(SPManager.getInstance().getString("leader","未设置用户名"));
        tv_wuyename.setText(SPManager.getInstance().getString("propertyname",""));
    }


}
