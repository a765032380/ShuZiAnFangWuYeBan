package com.bjxiyang.shuzianfangwuyeban.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baisi.myapplication.adutil.APP_ID;
import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.baisi.myapplication.okhttp.request.RequestParams;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.Login;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;
import com.bjxiyang.shuzianfangwuyeban.util.DialogUntil;
import com.bjxiyang.shuzianfangwuyeban.util.MyUntil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SDLoginActivity extends AppCompatActivity {

    private static final String WEIXIN_APP_ID="wxfe7d0b3660506256";
    private static final String WEIXIN_SCOPE="snsapi_userinfo";
    private static final String WEIXIN_STATE="wechat_sdk_login";
    private TextView tv_yonghuxieyi;
    private LinearLayout il_deletephone;

    public static SDLoginActivity sdLoginActivity;


    private EditText et_zhuce_password_again;
    private Button bt_get_smscode;
    private Button wx;
    Button loginMenutView;
//    Button regiestMenutView;
    LinearLayout loginView;
    LinearLayout regiestView;

    ImageView point_login;
    ImageView point_regiest;

    // 登录模块的
    EditText input_user_name_login_editview;
    EditText input_user_password_login_editview;
    Button login_action_button;

    //注册模块的
    EditText input_user_name_regiest_editview;
    EditText input_user_sms_code_editview;
    EditText input_user_password_regiest_editeView;
    Button regiest_action_button;

    TextView tv_pro_content;
    TextView forget_password_button;

//    ImageButton check_out;

    String sms_id;


    private int timeCount = 60;
    private Timer mtimer;
    //Activity最外层的Layout视图
    private RelativeLayout activityRootView;
    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;
    boolean islogin  =true;
    int usedsafeheight;
    Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==8000){
                loginView.setVisibility(View.VISIBLE);
                regiestView.setVisibility(View.GONE);
                MyUntil.show(SDLoginActivity.this,"注册成功");
//                showPointForLogin();
                qingkong();
                DialogUntil.closeLoadingDialog();

            }
            if (msg.what==7000){
                MyUntil.show(SDLoginActivity.this,"短信发送成功，请注意查收");
                startCountdown();
            }

            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login4);
        sdLoginActivity=this;
        getQuanxian();

        if (AppActivity.appActivity!=null) {
            AppActivity.appActivity.finish();
        }
//        if (GeRenZhongXinActivity.geRenZhongXinActivity!=null) {
//            GeRenZhongXinActivity.geRenZhongXinActivity.finish();
//        }

        //判断有没有用户的信息,如果有,直接跳转到主界面
        if (SPManager.getInstance().getInt("PropertyId",-1)!=-1){
            //将得到的用户信息保存到实体类中
            Intent intent = new Intent(SDLoginActivity.this, MainActivity.class);
            startActivity(intent);
            //关闭当前页面

            finish();
           
            //跳转到主页面

        }
        //初始化控件
        initView();
        //获取屏幕高度
//        setHeight();

    }


    @Override
    protected void onResume() {
        super.onResume();
        //添加layout大小发生改变监听器
//        activityRootView.addOnLayoutChangeListener(this);
    }

    private void initView()
    {
        input_user_name_login_editview = (EditText) findViewById(R.id.et_login_username);
        wx= (Button) findViewById(R.id.bt_weixindenglu);
        wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithWeixin();
            }
        });
        tv_yonghuxieyi= (TextView) findViewById(R.id.tv_yonghuxieyi);
        tv_yonghuxieyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyUntil.mStartActivity(SDLoginActivity.this,FuWuTiaoKuanActivity.class);
            }
        });
        il_deletephone= (LinearLayout) findViewById(R.id.il_deletephone);
        il_deletephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_user_name_login_editview.setText("");
            }
        });
//        point_login = (ImageView)findViewById(R.id.selected_menu_login);
//        point_regiest = (ImageView) findViewById(R.id.selected_menu_regiest);


        //记住密码的选择框
//        check_out = (ImageButton) findViewById(R.id.checkbox_button);
        //设置记住密码为选中状态
//        check_out.setSelected(true);
//        check_out.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //设置状态为相反的状态
//                boolean isCheckout = check_out.isSelected();
//                check_out.setSelected(!isCheckout);
//            }
//        });
        //发送验证码按钮
        bt_get_smscode= (Button) findViewById(R.id.bt_get_smscode);
        //点击发送验证码按钮后的逻辑处理
        bt_get_smscode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置发送验证码后的倒计时的时间
                timeCount=60;
                //得到用户的手机号
                String uPhone= String.valueOf(input_user_name_login_editview.getText());
//                String url=XY_Response.URL+"";
                //判断用户输入的手机号是不是正确的手机号
                if (!isMobilephone(uPhone)) {
                    Toast.makeText(SDLoginActivity.this,"请输入正确的手机号", Toast.LENGTH_LONG).show();
                    return;
                }
                //弹出等待的Dialog
                DialogUntil.showLoadingDialog(SDLoginActivity.this,"请稍等",true);
                //设置类型为注册类型,后台需要的
                String type="3";
                //拼接访问的URL
//                String test= XY_Response.URL_SED_MSM+"mobilePhone="+uPhone+"&type="+type;
//                //请求后台数据
//                RequestCenter.register(test, new DisposeDataListener() {
//                    @Override
//                    public void onSuccess(Object responseObj) {
//                        //请求成功返回数据并转化为实体类
//                        FanHui fanHui= (FanHui) responseObj;
//                        //清除Dialog
//                        DialogUntil.closeLoadingDialog();
//                        //判断后台的返回码,如果是1000的话说明发送验证码成功
//                        if (fanHui.getCode().equals("1000")){
//                            //发送验证码成功以后进行操作,因为是在线程中所以发送给Handler
//                            Message message=new Message();
//                            message.what=7000;
//                            handler.sendMessage(message);
//                            //如果返回的是500的话打印返回的错误信息
//                        }else if (fanHui.getCode().equals("500")){
//                            Toast.makeText(SDLoginActivity.this,
//                                    fanHui.getMsg(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Object reasonObj) {
//                        //网络请求失败也要清掉Dialog
//                        DialogUntil.closeLoadingDialog();
//                        //弹出请用户检查网络的Dialog,可以选择取消或者调到网络修改的页面
//                        MyDialog.showDialog(SDLoginActivity.this,"请检查网络连接");
//                    }
//                });
            }
        });



        //登录按钮实例化
        login_action_button = (Button) findViewById(R.id.btn_login);
        //点击登录按钮后的逻辑处理
        login_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录时输入的手机号
                 String uPhone = String.valueOf(input_user_name_login_editview.getText());
                //登录时输入的密码
                 String uPassword = String.valueOf(input_user_sms_code_editview.getText());
//                if (isMobilephone(uPhone)){
//                        Toast.makeText(SDLoginActivity.this,"输入格式没问题",Toast.LENGTH_LONG).show();
//                        String url= XY_Response.URL_LOGIN+"mobilePhone="+uPhone+"&password="+uPassword;
                //判断用户输入的手机号是否正确
//                if (!isMobilephone(uPhone)) {
//                    Toast.makeText(SDLoginActivity.this,"请输入正确的手机号", Toast.LENGTH_LONG).show();
//                    return;
//                }
                //判断用户输入的密码格式是否正确
//                if (!rexCheckPassword(uPassword)){
//                    Toast.makeText(SDLoginActivity.this,"请输入8~16位密码,密码必须包含字母和数字",Toast.LENGTH_LONG).show();
//                    return;
//                }
                //弹出正在登陆的等待动画
                DialogUntil.showLoadingDialog(SDLoginActivity.this,"正在登陆",true);
                //拼接访问的URL
                String url= URL.LOGIN
                        +"username="
                        +uPhone+"&password="
                        +uPassword;
                RequestCenter.login(url, Login.class, new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        Login login= (Login) responseObj;
                        if (login.getCode()==CodeUtil.SUCCESS){
                            setData(login);
                            Intent intent=new Intent(SDLoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Object reasonObj) {

                    }
                });

            }
        });
        //手机号输入框
        //验证码输入框
        input_user_sms_code_editview = (EditText) findViewById(R.id.et_reg_smscode) ;

    }
    private void setData(Login login){
        if (login.getObj().size()>0){
            SPManager.getInstance().putInt("PropertyId", Integer.parseInt(login.getObj().get(0).getPropertyId()));
            SPManager.getInstance().putString("propertyname",login.getObj().get(0).getPropertyName());
            SPManager.getInstance().putString("leader",login.getObj().get(0).getLeader());
            SPManager.getInstance().putString("tel",login.getObj().get(0).getTel());
//            SPManager.getInstance().putString("address",login.getObj().get(0).getAddress());
//            SPManager.getInstance().putString("nperid",login.getObj().get(0).getNperid());
//            SPManager.getInstance().putString("note",login.getObj().get(0).getNote());
//            SPManager.getInstance().putString("unitid",login.getObj().get(0).getUnitid());
//            SPManager.getInstance().putString("communityid",login.getObj().get(0).getCommunityid());
//            SPManager.getInstance().putString("floorid",login.getObj().get(0).getFloorid());
//            SPManager.getInstance().putString("doorid",login.getObj().get(0).getDoorid());
            SPManager.getInstance().putString("sex",login.getObj().get(0).getSex());
            SPManager.getInstance().putString("birthday",login.getObj().get(0).getBirthday());
            SPManager.getInstance().putString("headPhoneUrl",login.getObj().get(0).getHeadPhoneUrl());
            SPManager.getInstance().putString("loginKey",login.getObj().get(0).getPrivate_token());
        }
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
    //在倒计时的时候,对按钮上的字进行赋值
    public void changeSmsButton(){
        bt_get_smscode.setText(timeCount + "秒重发");

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
                    bt_get_smscode.setEnabled(true);
                    bt_get_smscode.setText(R.string.getsmsversion);
                }
            }
        }
    };

    //开始倒计时
    public void startCountdown(){
//        regiest_action_button.setEnabled(true);
        changeSmsButton();
        bt_get_smscode.setEnabled(false);
        setTimerTask();
    }
    public static boolean isMobilephone(String phone) {
        if (phone.startsWith("86") || phone.startsWith("+86")) {
            phone = phone.substring(phone.indexOf("86") + 2);
        }
        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }
    //密码的正则验证
    public static boolean rexCheckPassword(String input) {
       // 7-16 位，字母、数字、字符
       //String reg = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";
        String regStr = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
//       String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){8,16}$";
       return input.matches(regStr);
    }
    //MD5加密的方法
    public static String getMD5(String info){
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes("UTF-8"));
            byte[] encryption = md5.digest();
            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++)
            {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1)
                {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                }
                else
                {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            return strBuf.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            return "";
        }
        catch (UnsupportedEncodingException e)
        {
            return "";
        }
    }
    //清空已输入信息的方法
    private void qingkong(){
        input_user_name_login_editview.setText("");
        input_user_password_login_editview.setText("");
        input_user_name_regiest_editview.setText("");
        //验证码输入框
        input_user_sms_code_editview.setText("");
        //首次输入密码
        input_user_password_regiest_editeView.setText("");
        //第二次密码输入框
        et_zhuce_password_again.setText("");
    }
    //保存信息到SP中
//    private void setSP(){
//        //会员编号
//        SPManager.getInstance().putString("loginKey", String.valueOf(users.getObj().getLoginKey()));
//        SPManager.getInstance().putString("c_memberId", String.valueOf(users.getObj().getCmemberId()));
//        SPManager.getInstance().putString("mobilePhone",users.getObj().getMobilePhone());
//        SPManager.getInstance().putString("realName",users.getObj().getRealName());
//        SPManager.getInstance().putString("nickName",users.getObj().getNickName());
//        SPManager.getInstance().putString("sex", String.valueOf(users.getObj().getSex()));
//        SPManager.getInstance().putString("headPhotoUrl",users.getObj().getHeadPhotoUrl());
////        SPManager.getInstance().putString("status",users.getObj().get(0).getStatus());
////        SPManager.getInstance().putString("birthday",users.getObj().getBirthday());
////        SPManager.getInstance().putString("email",users.getObj().getEmail());
////        SPManager.getInstance().putString("address",users.getObj().getAddress());
////        SPManager.getInstance().putString("qq",users.getObj().getQq());
////        SPManager.getInstance().putString("weChat",users.getObj().getWeChat());
////        SPManager.getInstance().putString("age", users.getObj().getAge());
////        SPManager.getInstance().putString("ownerId",users.getObj().getOwnerId());
//    }



    //得到设备码
    private void getIMEI(){
        TelephonyManager telephonyManager=(TelephonyManager)
                this.getSystemService(Context.TELEPHONY_SERVICE);
        APP_ID.APP_ID =telephonyManager.getDeviceId();

    }
    public void getQuanxian() {
        if (Build.VERSION.SDK_INT >= 23) {
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
                android.support.v4.app.ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},1);

            }

        }
    }


    private IWXAPI mWeixinAPI;

    private void loginWithWeixin() {
        if (mWeixinAPI == null) {
            mWeixinAPI = WXAPIFactory.createWXAPI(this, WEIXIN_APP_ID, false);
        }

        if (!mWeixinAPI.isWXAppInstalled()) {
            MyUntil.show(this,"请先安装微信");
            //提醒用户没有按照微信
            return;
        }

        mWeixinAPI.registerApp(WEIXIN_APP_ID);

        SendAuth.Req req = new SendAuth.Req();
        req.scope = WEIXIN_SCOPE;

        req.state = WEIXIN_STATE;
        boolean b=mWeixinAPI.sendReq(req);
        Log.i("LLLL",b+"");
    }


}
