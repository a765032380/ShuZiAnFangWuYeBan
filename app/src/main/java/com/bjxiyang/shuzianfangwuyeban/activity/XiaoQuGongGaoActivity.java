package com.bjxiyang.shuzianfangwuyeban.activity;

import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.AddNotice;
import com.bjxiyang.shuzianfangwuyeban.bean.FindCommunity;
import com.bjxiyang.shuzianfangwuyeban.bean.XiaoQuGongGaoList;
import com.bjxiyang.shuzianfangwuyeban.dialog.ListViewDialog;
import com.bjxiyang.shuzianfangwuyeban.manager.SPManager;
import com.bjxiyang.shuzianfangwuyeban.testutil.TestUtil;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gll on 2017/11/7.
 */

public class XiaoQuGongGaoActivity extends MySwipeBackActivity {
    @BindView(R.id.rl_xiaoqugonggao_fanhui)
    RelativeLayout rl_xiaoqugonggao_fanhui;
    @BindView(R.id.rl_xiaoqugonggao_jilu)
    RelativeLayout rl_xiaoqugonggao_jilu;
    @BindView(R.id.ed_biaoti)
    EditText ed_biaoti;
    @BindView(R.id.ed_neirong)
    EditText ed_neirong;
    @BindView(R.id.tv_queding)
    TextView tv_queding;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.mListView_right)
    ListView mListView_right;
    @BindView(R.id.ll_selete)
    LinearLayout ll_selete;
    @BindView(R.id.tv_louhao_xiaoqu)
    TextView tv_louhao_xiaoqu;



    private String neirong;
    private String biaoti;
    private List<XiaoQuGongGaoList.ObjBean.ListBean> mList;

    private Map<Integer,String> mCommunityMap;
    private int communityId;

    @OnClick({R.id.rl_xiaoqugonggao_fanhui,
            R.id.rl_xiaoqugonggao_jilu,
            R.id.tv_queding,
            R.id.drawerlayout,
            R.id.ll_selete})
    public void OnClick(View view){
        switch (view.getId()){
            //返回的按键
            case R.id.rl_xiaoqugonggao_fanhui:
                finish();
                break;
            //记录的按键
            case R.id.rl_xiaoqugonggao_jilu:
                drawerlayout.openDrawer(Gravity.RIGHT);
                break;
            //确认的按键
            case R.id.tv_queding:
                biaoti= String.valueOf(ed_biaoti.getText());
                neirong=String.valueOf(ed_neirong.getText());
                if (biaoti.length()==0){
                    showToast("标题不能为空");
                    return;
                }
                if (neirong.length()==0){
                    showToast("内容不能为空");
                    return;
                }

                tijiao();
                break;
            case R.id.ll_selete:
                selectXiaoQu();
                break;
        }
    }

    private void selectXiaoQu() {

        String url=URL.FINDCOMMUNTITY
                +"pageNum=1"
                +"&pageSize=10";
        RequestCenter.all(url, FindCommunity.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                mCommunityMap=new HashMap<>();
                List<String> mCommunityList=new ArrayList<>();
                FindCommunity findCommunity= (FindCommunity) responseObj;
                if (findCommunity.getCode()==CodeUtil.SUCCESS){
                    for (int i=0;i<findCommunity.getObj().size();i++) {
                        mCommunityMap.put(findCommunity.getObj().get(i).getCommunityid(),findCommunity.getObj().get(i).getCommunityname());
                        mCommunityList.add(findCommunity.getObj().get(i).getCommunityname());
                    }
                    ListViewDialog.showListDialog(XiaoQuGongGaoActivity.this, mCommunityList, new ListViewDialog.OnSelectItemAndI() {
                        @Override
                        public void onSelectItem(String item, int i) {
                            tv_louhao_xiaoqu.setText(item);
                            communityId=getKey(mCommunityMap,item);
                        }

                    });
                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });





//

    }
    public  int getKey(Map<Integer,String> map,String value){
        int  key = 0;
                //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
                for(Integer getKey: map.keySet()){
                        if(map.get(getKey).equals(value)){
                                key = getKey;
                            }
                    }
                return key;
                //这个key肯定是最后一个满足该条件的key.
             }

    private void tijiao(){
//        String oldStr = SPManager.getInstance().getString("propertyname","");
//        String newStr="";
//        try {
//            newStr = new String(oldStr.getBytes(), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String url=URL.ADDNOTICE
                +"noticeId="
                +"&noticer="+SPManager.getInstance().getString("propertyname","")
                +"&title="+biaoti
                +"&content="+neirong
                +"&type="+0
                +"&notice_type="+0
                +"&community_id="+communityId;
        Log.i("LLLL",SPManager.getInstance().getString("propertyname",""));
        RequestCenter.all(url, AddNotice.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                AddNotice addNotice= (AddNotice) responseObj;
                if (addNotice.getCode()==CodeUtil.SUCCESS){
                    showToast("提交成功");
                    tv_louhao_xiaoqu.setText("请选择所要反馈的物业");
                    communityId=0;
                    ed_biaoti.setText("");
                    ed_biaoti.setHint("请填写公告标题");
                    ed_neirong.setText("");
                    ed_neirong.setHint("请填写内容");
                }else {
                    showToast(addNotice.getMsg());
                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });





    }






    @Override
    protected int getContentViewId() {
        return R.layout.activity_xiaoqugonggao;
    }

    @Override
    protected void initUI() {
        ButterKnife.bind(this);
        getdata();



    }
    private void getdata(){

        String url= URL.PROPERTYFUNCTIONS_NOTICE_SELECT
                +"pageNum="+1+"&pageSize="+5+"&search=";
        RequestCenter.all(url, XiaoQuGongGaoList.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                XiaoQuGongGaoList xiaoQuGongGaoList= (XiaoQuGongGaoList) responseObj;
                if (xiaoQuGongGaoList.getCode()== CodeUtil.SUCCESS){
                    mList=xiaoQuGongGaoList.getObj().getList();
                    mListView_right.setAdapter(new MyBaseAdapter<XiaoQuGongGaoList.ObjBean.ListBean>(
                            XiaoQuGongGaoActivity.this, mList,R.layout.item_item_lishigonggao) {
                        @Override
                        public void convert(ViewHolder helper, XiaoQuGongGaoList.ObjBean.ListBean item) {
                            helper.setText(R.id.tv_gonggao,item.getTitle());
                            helper.setText(R.id.tv_item_gonggao_date,item.getAdd_time()+"");
                        }

//                        @Override
//                        public void convert(ViewHolder helper, String item) {
//                            helper.setText(R.id.tv_gonggao,item);
//                        }
                    });
                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });



    }



}
