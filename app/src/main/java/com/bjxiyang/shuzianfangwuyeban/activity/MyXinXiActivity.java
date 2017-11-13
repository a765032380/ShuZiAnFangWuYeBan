package com.bjxiyang.shuzianfangwuyeban.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

import com.baisi.imoocsdk.imageloader.ImageLoaderManager;
import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.baisi.myapplication.okhttp.request.RequestParams;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.Image;
import com.bjxiyang.shuzianfangwuyeban.bean.Update;
import com.bjxiyang.shuzianfangwuyeban.dialog.SelectSexDialog;
import com.bjxiyang.shuzianfangwuyeban.luban.LuBan;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;
import com.bjxiyang.shuzianfangwuyeban.select_date.DateUtils;
import com.bjxiyang.shuzianfangwuyeban.select_date.JudgeDate;
import com.bjxiyang.shuzianfangwuyeban.select_date.ScreenInfo;
import com.bjxiyang.shuzianfangwuyeban.select_date.WheelMain;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.view.CircleImageView;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/2.
 */

public class MyXinXiActivity extends MySwipeBackActivity implements View.OnClickListener{

    final int RESULT_LOAD_IMAGE=5;
    private File mFile;
    private String picturePath;
    private Map map=new HashMap();
    private String mRealName="";
    private String mNickName="";

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
        setData();
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
                Intent intent1 = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1, RESULT_LOAD_IMAGE);
                break;
            //昵称
            case R.id.ll_nickname:
                Intent intent=new Intent(MyXinXiActivity.this,XiuGaiNameActivity.class);
                intent.putExtra("name",mNickName);
                intent.putExtra("type",0);
                startActivity(intent);
                break;
            //电话
            case R.id.ll_gerenxinxi_tel:
                Intent intent2=new Intent(MyXinXiActivity.this,GengGaiPhoneActivity.class);
                startActivity(intent2);
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
                update(3,selectTime,MyXinXiActivity.this);
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
//                        String sp[] = beginTime1.split(" ");




                        update(4,DateUtils.formateString(beginTime1,DateUtils.yyyyMMdd)
                                ,MyXinXiActivity.this);
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
    private void setData(){
        ImageLoaderManager.getInstance(this)
                .displayImage(iv_touxiang, SPManager.getInstance().getString("headPhoneUrl",""));
        tv_gerenxinxi_name.setText(SPManager.getInstance().getString("leader",""));
        tv_gerenxinxi_dinahua.setText(SPManager.getInstance().getString("tel",""));
        tv_gerenxinxi_sex.setText(SPManager.getInstance().getString("sex",""));
        tv_gerenxinxi_shengri.setText(SPManager.getInstance().getString("birthday",""));

    }

    @Override
    protected void onResume() {
        super.onResume();
        setData();
    }

    /**
     * 用onActivityResult()接收传回的图像，当用户拍完照片，或者取消后，系统都会调用这个函数
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {
            final Uri uri1 = intent.getData();
            Bitmap bitmap=getBitmapFromUri(uri1);
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(uri1,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath= cursor.getString(columnIndex);
            mFile=new File(picturePath);
            LuBan.setOnGetImage(MyXinXiActivity.this, mFile, new LuBan.OnGetImage() {
                @Override
                public void getImage(File file) {
                    map.put("pic", file);
                    String url = URL.FILEUPLOAD
                            +"propertyid="+SPManager.getInstance().getInt("PropertyId",0);
                    RequestCenter.uploadPictures2(url, map, new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            Image image= (Image) responseObj;
//                            update(5,);
                        }

                        @Override
                        public void onFailure(Object reasonObj) {

                        }
                    });


//                    String url=XY_Response2.URL_UESRCENTER_UPDATEUSERINFO
//                            +"cmemberId="+ SPManager.getInstance().getString("c_memberId",null);
//                    RequestCenter.uploadPictures2(url, map, new DisposeDataListener() {
//                        @Override
//                        public void onSuccess(Object responseObj) {
//                            Image fanHui2= (Image) responseObj;
//                            if (fanHui2.getCode()==1000){
////                                SPManager.getInstance().putString("headPhotoUrl",fanHui2.getObj().getPicUrl());
//                                String url1=XY_Response2.URL_UESRCENTER_UPDATEUSERPIC
//                                        +"cmemberId="+ SPManager.getInstance().getString("c_memberId",null)
//                                        +"&headPhotoUrl="+fanHui2.getObj().getPicUrl();
//                                Log.i("LLLLL","执行到了这里");
//                                RequestCenter.all(url1, UpdateImage.class, new DisposeDataListener() {
//                                    @Override
//                                    public void onSuccess(Object responseObj) {
//                                        UpdateImage updateImage= (UpdateImage) responseObj;
//                                        if (updateImage.getCode()==1000){
//                                            MyUntil.show(MyXinXiActivity.this,"修改成功");
//                                            ImageLoaderManager.getInstance(MyXinXiActivity.this)
//                                                    .displayImage(iv_gerenxinxi_xiugai_touxiang, String.valueOf(uri1));
//                                            SPManager.getInstance().putString("headPhotoUrl",updateImage.getObj().getHeadPhotoUrl());
//                                        }
//
//                                    }
//
//                                    @Override
//                                    public void onFailure(Object reasonObj) {
//                                        showToast("修改失败");
//
//                                    }
//                                });
//
//
//
//                            }else {
////                                showToast(fanHui2.getMsg());
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Object reasonObj) {
//
//                        }
//                    });

                }
            });
            cursor.close();
            bitmap.recycle();


        }
        if (requestCode == 1 && resultCode == RESULT_OK) {
            mNickName = intent.getStringExtra("name");
            tv_gerenxinxi_name.setText(mNickName);
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
//            mRealName = intent.getStringExtra("realname");
//            tv_gerenxinxi_xiugai_realname.setText(mRealName);
        }


    }
    private Bitmap getBitmapFromUri(Uri uri) {
        try
        {
            // 读取uri所在的图片
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            return bitmap;
        }
        catch (Exception e)
        {
            Log.e("[Android]", e.getMessage());
            Log.e("[Android]", "目录为：" + uri);
            e.printStackTrace();
            return null;
        }
    }
    public static void update(final int type, final String context, final Activity activity){
        RequestParams params=new RequestParams();
        params.put("propertyid",SPManager.getInstance().getInt("PropertyId",0)+"");
        switch (type){
            //修改用户名
            case 1:
                params.put("leader",context);
                params.put("tel","");
                params.put("sex","");
                params.put("birthday","");
                params.put("headPhoneUrl","");

                break;
            case 2:
                //修改手机号
                params.put("leader","");
                params.put("tel",context);
                params.put("sex","");
                params.put("birthday","");
                params.put("headPhoneUrl","");

                break;
            case 3:
                //修改性别
                params.put("leader","");
                params.put("tel","");
                params.put("sex",context);
                params.put("birthday","");
                params.put("headPhoneUrl","");

                break;
            case 4:
                //生日
                params.put("leader","");
                params.put("tel","");
                params.put("sex","");
                params.put("birthday",context);
                params.put("headPhoneUrl","");

                break;
            case 5:
                //头像
                params.put("leader","");
                params.put("tel","");
                params.put("sex","");
                params.put("birthday","");
                params.put("headPhoneUrl",context);

                break;
        }

        String url=URL.PERSONEDIT;
        RequestCenter.all(url, params, Update.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {


                switch (type){
                    case 1:
                        setData("leader",context);
                        activity.finish();
                        break;
                    case 2:
                        setData("tel",context);
                        activity.finish();
                        break;
                    case 3:
                        setData("sex",context);
                        break;
                    case 4:
                        setData("birthday",context);
                        break;
                    case 5:
                        setData("headPhoneUrl",context);
                        break;
                }


            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });






    }


    private static void setData(String key,String context){
        SPManager.getInstance().putString(key,context);
    }



}
