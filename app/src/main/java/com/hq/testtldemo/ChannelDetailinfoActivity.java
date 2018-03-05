package com.hq.testtldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by 黄庆 on 2017/7/4.
 */

public class ChannelDetailinfoActivity extends Activity {

    private RelativeLayout relativeLayout_history_record;
    private Button btn_take;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_detailinfo);
        relativeLayout_history_record=(RelativeLayout)this.findViewById(R.id.detailinfo_layout4);
        btn_take=(Button)this.findViewById(R.id.btn_take);
        relativeLayout_history_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChannelDetailinfoActivity.this,HistoryRecordActivity.class);
                startActivity(intent);
            }
        });
        btn_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_take.getText().toString().equals("订阅")){
                    Toast.makeText(ChannelDetailinfoActivity.this,"订阅成功",Toast.LENGTH_SHORT).show();
                    btn_take.setText("已订阅");
                }else{
                    Toast.makeText(ChannelDetailinfoActivity.this,"已经订阅过了哦！",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void image_back(View v){
        finish();
    }

    public void toListen(View view){
        Intent intent=new Intent(ChannelDetailinfoActivity.this,BroadcastDetailActivity.class);
        startActivity(intent);
    }

}
