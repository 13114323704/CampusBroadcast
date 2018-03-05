package com.hq.testtldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 黄庆 on 2017/7/4.
 */

public class HistoryRecordActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_record);
    }

    public void image_back(View v) {
        finish();
    }
}
