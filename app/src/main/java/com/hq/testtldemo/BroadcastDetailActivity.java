package com.hq.testtldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 黄庆 on 2017/8/3.
 */

public class BroadcastDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_detail);
    }

    public void exit(View view) {
        finish();
    }
}
