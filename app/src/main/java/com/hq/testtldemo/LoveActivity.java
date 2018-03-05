package com.hq.testtldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 黄庆 on 2017/8/3.
 */

public class LoveActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
    }

    public void image_back(View view) {
        finish();
    }
}
