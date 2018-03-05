package com.hq.testtldemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.lukedeighton.wheelview.adapter.WheelAdapter;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 黄庆 on 2017/8/1.
 */

public class BroadcastActivity extends Activity {

    private WheelView wheelView;
    private int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        width = size.x;

        wheelView = (WheelView) findViewById(R.id.wheelview);
        wheelView.setWheelSize(3);
        wheelView.setLoop(true);
        wheelView.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView.setSkin(WheelView.Skin.Holo); // common皮肤
        wheelView.setWheelData(createMainDatas());  // 数据集合
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextSize = 20;
        style.textSize = 16;
        style.backgroundColor = Color.TRANSPARENT;
        wheelView.setStyle(style);

    }

    private List<String> createMainDatas() {
        String[] strings = {"综合", "通知", "新闻", "音乐", "寻物"};
        return Arrays.asList(strings);
    }

    public void image_back(View view) {
        finish();
    }

    public void broadcast(View view) {
        Intent intent = new Intent(BroadcastActivity.this, BroadcastDetailActivity.class);
        startActivity(intent);
    }

}
