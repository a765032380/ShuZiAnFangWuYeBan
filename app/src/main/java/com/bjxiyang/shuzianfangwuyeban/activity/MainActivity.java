package com.bjxiyang.shuzianfangwuyeban.activity;

import android.util.Log;

import com.bjxiyang.shuzianfangwuyeban.fragment_main.BaseFragment;
import com.bjxiyang.shuzianfangwuyeban.fragment_main.DaiBanFragment;

public class MainActivity extends AppActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return DaiBanFragment.newInstance();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
