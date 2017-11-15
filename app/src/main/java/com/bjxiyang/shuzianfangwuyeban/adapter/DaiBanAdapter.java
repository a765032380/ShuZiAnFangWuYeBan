package com.bjxiyang.shuzianfangwuyeban.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baisi.imoocsdk.imageloader.ImageLoaderManager;
import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.api.URL;
import com.bjxiyang.shuzianfangwuyeban.bean.DaiBan;
import com.bjxiyang.shuzianfangwuyeban.bean.RepairUpdate;
import com.bjxiyang.shuzianfangwuyeban.bean.WuYeFeiCuiShou;
import com.bjxiyang.shuzianfangwuyeban.bean.ZhiDaoLe;
import com.bjxiyang.shuzianfangwuyeban.update.network.RequestCenter;
import com.bjxiyang.shuzianfangwuyeban.util.CodeUtil;
import com.bjxiyang.shuzianfangwuyeban.util.MyUntil;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gll on 2017/11/15.
 */

public class DaiBanAdapter extends BaseAdapter {
    private Context mContext;
    private List<DaiBan.ObjBean> mList;
    HashMap<Integer, View> lmap = new HashMap<Integer, View>();
    public DaiBanAdapter(Context mContext, List<DaiBan.ObjBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (lmap.get(i) ==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_daiban,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
            lmap.put(i,view);
        }else {
            view = lmap.get(i);
            holder= (ViewHolder) view.getTag();
        }

        holder.tv_neirong.setText(mList.get(i).getContent());
        switch (mList.get(i).getType()){
            case "1":
                showWuYeFanKui(holder,mList.get(i),i);
                break;
            case "2":
                showJiaoFeiDingDan(holder,mList.get(i));
                break;
            case "3":
                showWuYeBaoXiu(holder,mList.get(i));
                break;
        }

        return view;
    }
    class ViewHolder{
        @BindView(R.id.tv_wuyefei)
        TextView tv_wuyefei;
        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_neirong)
        TextView tv_neirong;
        @BindView(R.id.tv_wuyefei_money)
        TextView tv_wuyefei_money;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_dizhi)
        TextView tv_dizhi;
        @BindView(R.id.tv_button)
        TextView tv_button;
        @BindView(R.id.tv_button_know)
        TextView tv_button_know;
        @BindView(R.id.tv_dingdanhao)
        TextView tv_dingdanhao;
        @BindView(R.id.ll_jiaofei)
        LinearLayout ll_jiaofei;
        @BindView(R.id.ll_image)
        LinearLayout ll_image;
        @BindView(R.id.iv_1)
        ImageView iv_1;
        @BindView(R.id.iv_2)
        ImageView iv_2;
        @BindView(R.id.iv_3)
        ImageView iv_3;
        @BindView(R.id.iv_4)
        ImageView iv_4;
        @BindView(R.id.ll_shijian)
        LinearLayout ll_shijian;
        @BindView(R.id.ll_neirong)
        LinearLayout ll_neirong;
        @BindView(R.id.ll_dibu)
        LinearLayout ll_dibu;
        @BindView(R.id.ll_dingdanhao)
        LinearLayout ll_dingdanhao;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private void showWuYeFanKui(ViewHolder holder,DaiBan.ObjBean bean,int i){

        holder.ll_jiaofei.setVisibility(View.GONE);
        holder.tv_dingdanhao.setVisibility(View.GONE);
        holder.tv_wuyefei.setText("物业反馈");
        holder.tv_date.setText(bean.getCreate_time());
        holder.tv_neirong.setText(bean.getContent());
        holder.tv_name.setText(bean.getMobilePhone());
        holder.tv_dizhi.setText(bean.getAddress());
        holder.tv_button.setText("打电话");
        holder.tv_button_know.setText("知道了");
        showImage(holder,bean);
        dadianhua(holder,bean);
        zhidaole(holder,bean,i);
    }
    private void showJiaoFeiDingDan(ViewHolder holder,DaiBan.ObjBean bean){
        holder.ll_neirong.setVisibility(View.GONE);
        holder.tv_wuyefei.setText("物业费订单");
        holder.tv_date.setText(bean.getCreate_time());
        holder.tv_neirong.setText(bean.getContent());
        holder.tv_name.setText(bean.getMobilePhone());
        holder.tv_dizhi.setText(bean.getAddress());
        holder.tv_button.setText("催收");
        holder.tv_wuyefei_money.setText(bean.getRentMoney());
        holder.tv_dingdanhao.setText("单号："+bean.getRepair_no());
        holder.tv_button_know.setVisibility(View.GONE);
        cuishou(holder,bean);

    }
    private void showWuYeBaoXiu(ViewHolder holder,DaiBan.ObjBean bean){
        holder.ll_jiaofei.setVisibility(View.GONE);
        holder.tv_dingdanhao.setVisibility(View.VISIBLE);
        holder.tv_dingdanhao.setText("单号："+bean.getRepair_no());
        holder.tv_wuyefei.setText("维修服务");
        holder.tv_date.setText(bean.getCreate_time());
        holder.tv_neirong.setText(bean.getContent());
        holder.tv_name.setText(bean.getMobilePhone());
        holder.tv_dizhi.setText(bean.getAddress());
        holder.tv_button.setText("受理");
        holder.tv_button_know.setVisibility(View.GONE);
        showImage(holder,bean);
        weixiu(holder,bean);
    }

    private void showImage(ViewHolder holder,DaiBan.ObjBean bean){
        if (bean.getPic().size()==0){
            holder.ll_image.setVisibility(View.GONE);
        }else {
            holder.ll_image.setVisibility(View.VISIBLE);
        }
        if (bean.getPic().size()==1){
            setImage(holder.iv_1,bean.getPic().get(0));

        }
        if (bean.getPic().size()==2){
            setImage(holder.iv_1,bean.getPic().get(0));
            setImage(holder.iv_2,bean.getPic().get(1));
        }
        if (bean.getPic().size()==3){
            setImage(holder.iv_1,bean.getPic().get(0));
            setImage(holder.iv_2,bean.getPic().get(1));
            setImage(holder.iv_3,bean.getPic().get(2));
        }
        if (bean.getPic().size()==4){
            setImage(holder.iv_1,bean.getPic().get(0));
            setImage(holder.iv_2,bean.getPic().get(1));
            setImage(holder.iv_3,bean.getPic().get(2));
            setImage(holder.iv_4,bean.getPic().get(3));
        }
    }
    private void setImage(ImageView image,String url){
        ImageLoaderManager.getInstance(mContext)
                .displayImage(image,url);
    }
    private void weixiu(final ViewHolder holder, final DaiBan.ObjBean bean){
        if (bean.getStatus().equals("0")){
            holder.tv_button.setTextColor(0xffffffff);
            holder.tv_button.setText("受理");
            holder.tv_button.setBackgroundResource(R.drawable.b_d_btn_dadianhua);
            final String repairId=bean.getRepair_id();
            holder.tv_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url= URL.REPAIRUPDATE
                            +"repair_status="+1
                            +"&repair_id="+repairId;

                    RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                            if (repairUpdate.getCode()== CodeUtil.SUCCESS){
                                bean.setStatus("1");
                                weixiu(holder,bean);
//                                holder.tv_button.setTextColor(0xff297aff);
//                                holder.tv_button.setText("维修中");
//                                holder.tv_button.setBackgroundResource(R.drawable.a_b_a_btn_fasong);
//
//                                bean.setStatus("1");
//                                final String repairId=bean.getRepair_id();
//                                holder.tv_button.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        String url=URL.REPAIRUPDATE
//                                                +"repair_status="+2
//                                                +"&repair_id="+repairId;
//                                        RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
//                                            @Override
//                                            public void onSuccess(Object responseObj) {
//                                                RepairUpdate repairUpdate= (RepairUpdate) responseObj;
//                                                if (repairUpdate.getCode()==CodeUtil.SUCCESS){
//                                                    mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
//                                                    mHelper.setTextColor(R.id.tv_button,0xffada8a8);
//                                                    mHelper.setText(R.id.tv_button,"维修成功");
//                                                    mItem.setRepair_status(2);
//                                                }
//
//                                            }
//
//                                            @Override
//                                            public void onFailure(Object reasonObj) {
//
//                                            }
//                                        });
//                                    }
//                                });
                            }

                        }

                        @Override
                        public void onFailure(Object reasonObj) {

                        }
                    });
                }
            });

        }
        if (bean.getStatus().equals("1")){
            holder.tv_button.setTextColor(0xff297aff);
            holder.tv_button.setText("维修中");
            holder.tv_button.setBackgroundResource(R.drawable.a_b_a_btn_fasong);
            final String repairId=bean.getRepair_id();
            holder.tv_button.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url=URL.REPAIRUPDATE
                            +"repair_status="+2
                            +"&repair_id="+repairId;
                    RequestCenter.all(url, RepairUpdate.class , new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            RepairUpdate repairUpdate= (RepairUpdate) responseObj;
                            if (repairUpdate.getCode()==CodeUtil.SUCCESS){
                                bean.setStatus("2");
                                weixiu(holder,bean);
//                                mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
//                                mHelper.setTextColor(R.id.tv_button,0xffada8a8);
//                                mHelper.setText(R.id.tv_button,"维修成功");
//                                mHelper.setOnClickListener(R.id.tv_button,null);
//                                mItem.setRepair_status(2);
                            }

                        }

                        @Override
                        public void onFailure(Object reasonObj) {

                        }
                    });
                }
            });

        }
        if (bean.getStatus().equals("2")) {
            holder.tv_button.setTextColor(0xffada8a8);
            holder.tv_button.setText("维修成功");
            holder.tv_button.setBackgroundResource(R.drawable.conners_5dp_f1f1f1);
//            mHelper.setBackgroundResource(R.id.tv_button,R.drawable.conners_5dp_f1f1f1);
//            mHelper.setTextColor(R.id.tv_button,0xffada8a8);
//            mHelper.setText(R.id.tv_button,"维修成功");
//            mHelper.setOnClickListener(R.id.tv_button,null);
        }
    }
    private void cuishou(ViewHolder holder, final DaiBan.ObjBean bean){
        holder.tv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=URL.ORDERHASTEN
                        +"rentMoney="+bean.getRentMoney()
                        +"&mobilePhone="+bean.getMobilePhone();
                RequestCenter.all(url, WuYeFeiCuiShou.class, new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        WuYeFeiCuiShou wuYeFeiCuiShou= (WuYeFeiCuiShou) responseObj;
                        if (wuYeFeiCuiShou.getCode()==CodeUtil.SUCCESS){
                            MyUntil.show(mContext,"催收成功");
                        }

                    }

                    @Override
                    public void onFailure(Object reasonObj) {

                    }
                });
            }
        });



    }
    private void dadianhua(ViewHolder holder, final DaiBan.ObjBean bean){
        holder.tv_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+bean.getMobilePhone()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }
    private void zhidaole(ViewHolder holder, final DaiBan.ObjBean bean, final int i){
        holder.tv_button_know.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String url=URL.KNOW
                        +"complaint_id="+bean.getComplaint_id();
                RequestCenter.all(url, ZhiDaoLe.class, new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        ZhiDaoLe zhiDaoLe= (ZhiDaoLe) responseObj;
                        if (zhiDaoLe.getCode()==CodeUtil.SUCCESS) {
                            mList.remove(i);
                            notifyDataSetChanged();
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
