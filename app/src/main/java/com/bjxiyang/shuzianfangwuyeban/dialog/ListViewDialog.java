package com.bjxiyang.shuzianfangwuyeban.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bjxiyang.shuzianfangwuyeban.R;
import com.bjxiyang.shuzianfangwuyeban.adapter.MyBaseAdapter;
import com.bjxiyang.shuzianfangwuyeban.adapter.ViewHolder;

import java.util.List;

/**
 * Created by gll on 2017/11/7.
 */

public class ListViewDialog extends Dialog implements AdapterView.OnItemClickListener {

    private static ListViewDialog mListViewDialog;
    private static List<String> mList;
    private static OnSelectItem onSelectItem;
    private static OnSelectItemAndI onSelectItemAndI;


    public ListViewDialog(@NonNull Context context) {

        super(context);
        mListViewDialog=this;
    }

    public ListViewDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected ListViewDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_listview);

        ListView lv_listview=findViewById(R.id.lv_listview);
        MyBaseAdapter<String> adapter=new MyBaseAdapter<String>(getContext(),mList,R.layout.item_listview_dialog) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_context,item);
            }
        };
        lv_listview.setOnItemClickListener(this);
        lv_listview.setAdapter(adapter);


    }
    public static void showListDialog(Context context,List<String> list,OnSelectItem listener){
        new ListViewDialog(context);
        mList=list;
        onSelectItem=listener;
        mListViewDialog.show();
    }
    public static void showListDialog(Context context,List<String> list,OnSelectItemAndI listener){
        new ListViewDialog(context);
        mList=list;
        onSelectItemAndI=listener;
        mListViewDialog.show();
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (onSelectItem!=null){
            onSelectItem.onSelectItem(mList.get(i));
        }
        if (onSelectItemAndI!=null){
            onSelectItemAndI.onSelectItem(mList.get(i),i);
        }

        mListViewDialog.cancel();

    }

   public interface OnSelectItem{
        public void onSelectItem(String item);
    }

    public interface OnSelectItemAndI{
        public void onSelectItem(String item,int i);
    }
}
